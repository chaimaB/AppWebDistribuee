package com.ressourceshumaines.ressouceshumaines.repositories;

import com.ressourceshumaines.ressouceshumaines.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<user, String> {

    List<user> findAllByRole(String role);
    List<user> findAllByCivilStatus(String civilStatus);
    List<user> findAllBySexeAndCivilStatus(String sexe, String civilStatus);
}
