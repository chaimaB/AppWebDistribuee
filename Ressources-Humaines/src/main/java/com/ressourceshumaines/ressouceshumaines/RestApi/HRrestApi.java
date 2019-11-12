package com.ressourceshumaines.ressouceshumaines.RestApi;


import com.ressourceshumaines.ressouceshumaines.entities.user;
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

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("hello");

        return "hello";
    }

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
}
