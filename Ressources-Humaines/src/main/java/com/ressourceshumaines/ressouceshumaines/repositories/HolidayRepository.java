package com.ressourceshumaines.ressouceshumaines.repositories;

import com.ressourceshumaines.ressouceshumaines.entities.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<Holiday, Integer> {
}
