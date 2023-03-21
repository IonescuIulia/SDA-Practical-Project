package com.sda.practicalproject1.service;

import com.sda.practicalproject1.model.Pet;
import com.sda.practicalproject1.repository.exception.EntityUpdateFailedException;
import com.sda.practicalproject1.service.exception.EntitiyNotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PetService {
    void addPet(String race, Date dateOfBirth, boolean isVaccinated, String ownerName
    ) throws EntityUpdateFailedException;
    List<Pet> getAllPets();
    Optional<Pet> getPetById(long id);
    void deletePetById(long id) throws EntityUpdateFailedException, EntitiyNotFoundException;
}
