package com.sda.practicalproject1.service;

import com.sda.practicalproject1.repository.exception.EntityUpdateFailedException;
import com.sda.practicalproject1.service.exception.EntitiyNotFoundException;

import java.util.Date;

public interface ConsultService {
    void createConsult(long vetId, long petId, Date dateOfConsult, String description) throws EntitiyNotFoundException, EntityUpdateFailedException;

}
