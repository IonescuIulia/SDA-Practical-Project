package com.sda.practicalproject1;

import com.sda.practicalproject1.model.Vet;
import com.sda.practicalproject1.repository.VetRepository;
import com.sda.practicalproject1.repository.VetRepositoryImpl;
import com.sda.practicalproject1.repository.exception.EntityUpdateFailedException;
import com.sda.practicalproject1.utils.SessionManager;

public class Main {
    public static void main(String[] args) throws EntityUpdateFailedException {
        SessionManager.getSessionFactory().openSession();

        VetRepository vetRepository = new VetRepositoryImpl();
        Vet veterinarulTiti = new Vet(
                "Titi",
                "Aur",
                "Strada Vitezei nr 10",
                "Pisici"
        );

        vetRepository.save(veterinarulTiti);

        System.out.println(vetRepository.findById(1L));
        System.out.println(vetRepository.findAll());
        veterinarulTiti.setFirstName("TitiUpdatat");
        vetRepository.update(veterinarulTiti);
        System.out.println(vetRepository.findById(1L));

        vetRepository.delete(veterinarulTiti);
        System.out.println(vetRepository.findById(1L));


        SessionManager.shutdown();
    }
}