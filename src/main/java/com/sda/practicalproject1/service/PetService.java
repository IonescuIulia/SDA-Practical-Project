package com.sda.practicalproject1.service;

import com.sda.practicalproject1.repository.exception.EntityUpdateFailedException;

import java.util.Date;

public interface PetService {
    void addPet(String race, Date dateOfBirth, boolean isVaccinated, String ownerName) throws EntityUpdateFailedException;
}
