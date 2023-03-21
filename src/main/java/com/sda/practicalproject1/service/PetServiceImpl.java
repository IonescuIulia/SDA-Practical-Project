package com.sda.practicalproject1.service;

import com.sda.practicalproject1.model.Pet;
import com.sda.practicalproject1.repository.PetRepository;
import com.sda.practicalproject1.repository.exception.EntityUpdateFailedException;
import com.sda.practicalproject1.service.exception.EntitiyNotFoundException;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public void addPet(String race, Date dateOfBirth, boolean isVaccinated, String ownerName) throws EntityUpdateFailedException {
        if (race == null || race.isEmpty() || race.isEmpty()) {
            throw new IllegalArgumentException("Please insert a valid race");
        }
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("Please insert a date of birth");
        }
        if (dateOfBirth.after(Date.from(Instant.now().plus(Duration.ofDays(1))))) {
            throw new IllegalArgumentException("Please insert a date from the past");
        }
        if (ownerName == null || ownerName.isEmpty() || ownerName.isBlank()) {
            throw new IllegalArgumentException("Please insert a valid owner name");
        }
        Pet pet = new Pet(race, dateOfBirth, isVaccinated, ownerName);
        petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public void updatePet(long id, boolean isVaccinated, String ownerName) throws EntitiyNotFoundException, EntityUpdateFailedException {
        if (id <= 0) {
            throw new IllegalArgumentException("Please insert a correct id, must be bigger than zero");
        }
        if (ownerName == null || ownerName.isEmpty() || ownerName.isBlank()) {
            throw new IllegalArgumentException("Please enter a valid owner name");
        }
        Optional<Pet> optionalPet = petRepository.findById(id);
        if (optionalPet.isPresent()) {


            Pet pet = optionalPet.get();
            pet.setVaccinated(isVaccinated);
            pet.setOwnerName(ownerName);
            petRepository.update(pet);
        } else {
            throw new EntitiyNotFoundException("Pet id was not found" + id);
        }
    }
    @Override
    public Optional<Pet> getPetById(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is less or equal to zero");
        }
        return petRepository.findById(id);
    }

    @Override
    public void deletePetById(long id) throws EntityUpdateFailedException, EntitiyNotFoundException {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is less or equal to zero");
        }
        Optional<Pet> optionalPet = petRepository.findById(id);
        if (optionalPet.isPresent()) {
            petRepository.delete(optionalPet.get());
        } else {
            throw new EntitiyNotFoundException("Pet id not found");
        }
    }
}
