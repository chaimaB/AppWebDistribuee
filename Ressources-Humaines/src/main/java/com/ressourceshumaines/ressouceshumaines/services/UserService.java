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

    public user updateUser(String id, user newUser) {
        if (userRepository.findById(id).isPresent()) {
            user existingUSer = userRepository.findById(id).get();
            existingUSer.setUsername(newUser.getUsername());
            existingUSer.setFirstName(newUser.getFirstName());
            existingUSer.setLastName(newUser.getLastName());
            existingUSer.setCivilStatus(newUser.getCivilStatus());

            return userRepository.save(existingUSer);
        } else
            return null;
    }

    public String deleteUser(String id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return "user supprimé";
        } else
            return "user non supprimé";
    }
}
