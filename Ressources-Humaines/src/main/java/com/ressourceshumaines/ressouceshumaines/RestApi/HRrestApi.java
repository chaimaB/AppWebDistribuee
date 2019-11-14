package com.ressourceshumaines.ressouceshumaines.RestApi;


import com.ressourceshumaines.ressouceshumaines.entities.Holiday;
import com.ressourceshumaines.ressouceshumaines.entities.user;
import com.ressourceshumaines.ressouceshumaines.services.HolidayService;
import com.ressourceshumaines.ressouceshumaines.services.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/HR")
public class HRrestApi {

    @Autowired
    private UserService userService;

    @Autowired
    private HolidayService holidayService;

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("hello");

        return "hello";
    }

    ///////// user rest api

    @PostMapping(value = "/addUser")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<user> addUser(@RequestBody user user){
        user.setCreatedDate(new Date());
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }

    @GetMapping(value = "/getOne/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<user> getOneUser(@PathVariable(value = "id") String id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponseEntity<Object> getAllUsers(){
        return new ResponseEntity<Object>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PutMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<user> updateUser(@PathVariable(value = "id") String id,
                                                   @RequestBody user user){
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") String id){
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }


    ////////// holiday rest api
    @PostMapping(value = "/holiday/add/{idUser}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Holiday> addHoliday(@RequestBody Holiday holiday, @PathVariable String idUser){
        return new ResponseEntity<>(holidayService.addHoliday(holiday, idUser), HttpStatus.OK);
    }

    @PutMapping(value = "/holiday/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Holiday> updateHoliday(@PathVariable(value = "id") int id,
                                           @RequestBody Holiday holiday){
        return new ResponseEntity<>(holidayService.updateHoliday(id, holiday), HttpStatus.OK);
    }

    @GetMapping(value = "/holiday/getOne/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Holiday> getOneHoliday(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(holidayService.getOneHoliday(id), HttpStatus.OK);
    }
}
