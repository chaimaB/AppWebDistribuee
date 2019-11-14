package com.materiels.repositories;

import com.materiels.entities.Materiels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterielsRepository extends JpaRepository<Materiels, Integer> {
}
