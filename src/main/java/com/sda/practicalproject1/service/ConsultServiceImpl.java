package com.sda.practicalproject1.service;

import com.sda.practicalproject1.model.Consult;
import com.sda.practicalproject1.model.Pet;
import com.sda.practicalproject1.model.Vet;
import com.sda.practicalproject1.repository.ConsultRepository;
import com.sda.practicalproject1.repository.PetRepository;
import com.sda.practicalproject1.repository.VetRepository;
import com.sda.practicalproject1.repository.exception.EntityUpdateFailedException;
import com.sda.practicalproject1.service.exception.EntitiyNotFoundException;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

public class ConsultServiceImpl implements ConsultService {
    private final VetRepository vetRepository;
    private final PetRepository petRepository;
    private final ConsultRepository consultRepository;

    public ConsultServiceImpl(VetRepository vetRepository, PetRepository petRepository, ConsultRepository consultRepository) {
        this.vetRepository = vetRepository;
        this.petRepository = petRepository;
        this.consultRepository = consultRepository;
    }

    @Override
    public void createConsult(long vetId, long petId, Date dateOfConsult, String description) throws EntitiyNotFoundException, EntityUpdateFailedException {
        if (vetId <= 0) {
            throw new IllegalArgumentException("Invalid Vet id, value must pe greater than 0");
        }
        if (petId <= 0) {
            throw new IllegalArgumentException("Invalid Pet id, value must pe greater than 0");
        }
        if (dateOfConsult == null) {
            throw new IllegalArgumentException("Invalid date, null value found");
        }
        if (dateOfConsult.before(Date.from(Instant.now().minus(Duration.ofDays(1))))) {
            throw new IllegalArgumentException("Invalid date, date from future found");
        }
        if (description == null || description.isBlank() || description.isEmpty()) {
            throw new IllegalArgumentException("Invalid description, value must be not null or not blank");
        }
        Optional<Vet> optionalVet = vetRepository.findById(vetId);
        if (optionalVet.isEmpty()) {
            throw new EntitiyNotFoundException("Vet id was not found" + vetId);
        }
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isEmpty()){
            throw new EntitiyNotFoundException("Pet id was not found" + petId);
        }
        Consult consult = new Consult(dateOfConsult,description);
        consult.setVet(optionalVet.get());
        consult.setPet(optionalPet.get());
        consultRepository.save(consult);
    }
}
