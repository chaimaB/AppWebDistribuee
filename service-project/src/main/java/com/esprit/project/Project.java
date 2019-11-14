package com.esprit.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Project {
	@Id
	@GeneratedValue
	private Long id;
	private String nameProject ;
	private String startDate;
	private String endDate;
	private float cost;
	private String description;
	private Long idClient;
	private Long idChef;
	public Project() {
		super();
	}
	public Project(Long id, String nameProject, String startDate, String endDate, float cost, String description,
			Long idClient, Long idChef) {
		super();
		this.id = id;
		this.nameProject = nameProject;
		this.startDate = startDate;
		this.endDate = endDate;
		this.cost = cost;
		this.description = description;
		this.idClient = idClient;
		this.idChef = idChef;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameProject() {
		return nameProject;
	}
	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public Long getIdChef() {
		return idChef;
	}
	public void setIdChef(Long idChef) {
		this.idChef = idChef;
	}
	
	
	
}
