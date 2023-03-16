package com.sda.practicalproject1.service;

import com.sda.practicalproject1.repository.exception.EntityUpdateFailedException;

public interface VetService {

    void addVet(
           String firstName,
           String lastName,
           String address,
           String speciality
    ) throws EntityUpdateFailedException;


}
