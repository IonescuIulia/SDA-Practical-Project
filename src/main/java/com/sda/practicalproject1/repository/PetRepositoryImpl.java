package com.sda.practicalproject1.repository;

import com.sda.practicalproject1.model.Pet;
import com.sda.practicalproject1.repository.PetRepository;
import com.sda.practicalproject1.repository.base.RepositoryImpl;

public class PetRepositoryImpl extends RepositoryImpl<Pet> implements PetRepository {

    public PetRepositoryImpl() {
        super(Pet.class);
    }
}
