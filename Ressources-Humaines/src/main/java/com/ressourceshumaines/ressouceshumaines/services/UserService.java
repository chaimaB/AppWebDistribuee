package com.ressourceshumaines.ressouceshumaines.services;

import com.ressourceshumaines.ressouceshumaines.entities.user;
import com.ressourceshumaines.ressouceshumaines.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public user addUser(user user) {
        return userRepository.save(user);
    }

    public user getUserById(String id) {
        return userRepository.getOne(id);
    }

    public List<user> getAllUsers() {
        return userRepository.findAll();
    }

    public List<user> getAllEmployees() {
        return userRepository.findAllByRole("employee");
    }
}
