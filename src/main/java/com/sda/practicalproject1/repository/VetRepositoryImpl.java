package com.sda.practicalproject1.repository;

import com.sda.practicalproject1.model.Vet;
import com.sda.practicalproject1.repository.base.RepositoryImpl;

public class VetRepositoryImpl extends RepositoryImpl<Vet> implements VetRepository  {

    public VetRepositoryImpl() {
        super(Vet.class);
    }
}
