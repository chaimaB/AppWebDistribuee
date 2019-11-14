package com.esprit.project;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ProjectRessource {
	@Autowired
	private ProjectRepository projectRepository;
	@GetMapping("/projects")
	public List<Project> retrieveAllStudents() {
		return projectRepository.findAll();
	}
	
	@GetMapping("/projects/{id}")
	public Project retrieveProject(@PathVariable long id) {
		Optional<Project> project = projectRepository.findById(id);

		if (!project.isPresent())
			throw new ProjectNotFoundException("id-" + id);

		return project.get();
	}
	@DeleteMapping("/projects/{id}")
	public void deleteProject(@PathVariable long id) {
		projectRepository.deleteById(id);
	}
	
	@PostMapping("/projects")
	public ResponseEntity<Object> createProject(@RequestBody Project project) {
		Project savedProject = projectRepository.save(project);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProject.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	@PutMapping("/projects/{id}")
	public ResponseEntity<Object> updateProject(@RequestBody Project project, @PathVariable long id) {

		Optional<Project> projectOptional = projectRepository.findById(id);

		if (!projectOptional.isPresent())
			return ResponseEntity.notFound().build();

		project.setId(id);
		
		projectRepository.save(project);

		return ResponseEntity.noContent().build();
	}
}
