package com.sda.practicalproject1;

import com.sda.practicalproject1.model.Vet;
import com.sda.practicalproject1.repository.VetRepository;
import com.sda.practicalproject1.repository.VetRepositoryImpl;
import com.sda.practicalproject1.repository.exception.EntityUpdateFailedException;
import com.sda.practicalproject1.utils.SessionManager;

public class Main {
    public static void main(String[] args) throws EntityUpdateFailedException {
        SessionManager.getSessionFactory().openSession();

        SessionManager.shutdown();
    }
}