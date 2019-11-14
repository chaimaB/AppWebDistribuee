package com.materiels.restApi;

import com.materiels.entities.Materiels;
import com.materiels.services.MaterielsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/materiels")
public class MaterielRESTAPI {
    @Autowired
    private MaterielsService materielsService;

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("hello");

        return "hello";
    }

    ///////// user rest api

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Materiels> addMaterial(@RequestBody Materiels materiels){
        return new ResponseEntity<>(materielsService.addMateriels(materiels), HttpStatus.OK);
    }

    @GetMapping(value = "/getOne/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Materiels> getOneMaterial(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(materielsService.getMaterielById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponseEntity<Object> getAllMaterials(){
        return new ResponseEntity<Object>(materielsService.getAllMateriels(), HttpStatus.OK);
    }

    @PutMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Materiels> updateMaterial(@PathVariable(value = "id") int id,
                                           @RequestBody Materiels materiels){
        return new ResponseEntity<>(materielsService.updateMateriel(id, materiels), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteMaterial(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(materielsService.deleteMaterial(id), HttpStatus.OK);
    }

}
