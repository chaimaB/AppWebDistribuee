package com.materiels.services;

import com.materiels.entities.Materiels;
import com.materiels.repositories.MaterielsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterielsService {

    @Autowired
    private MaterielsRepository materielsRepository;

    public Materiels addMateriels(Materiels materiels) {
        return materielsRepository.save(materiels);
    }

    public Materiels getMaterielById(int id) {
        return materielsRepository.getOne(id);
    }

    public List<Materiels> getAllMateriels() {
        return materielsRepository.findAll();
    }

    public Materiels updateMateriel(int id, Materiels newMateriel) {
        if (materielsRepository.findById(id).isPresent()) {
            Materiels existingMateriel = materielsRepository.findById(id).get();
            existingMateriel.setNom(newMateriel.getNom());
            existingMateriel.setDescription(newMateriel.getDescription());
            existingMateriel.setType(newMateriel.getType());
            // existingMateriel.setProject_id(newMateriel.getProject_id());

            return materielsRepository.save(existingMateriel);
        } else
            return null;
    }

    public String deleteMaterial(int id) {
        if (materielsRepository.findById(id).isPresent()) {
            materielsRepository.deleteById(id);
            return "materiel supprimé";
        } else
            return "materiel non supprimé";
    }

    public Materiels addProjectId(int id, Materiels newMateriel) {
        if (materielsRepository.findById(id).isPresent()) {
            Materiels existingMateriel = materielsRepository.findById(id).get();
            existingMateriel.setProject_id(newMateriel.getProject_id());

            return materielsRepository.save(existingMateriel);
        } else
            return null;
    }
}
