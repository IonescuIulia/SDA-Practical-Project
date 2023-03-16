package com.sda.practicalproject1.controller;

import com.sda.practicalproject1.repository.exception.EntityUpdateFailedException;
import com.sda.practicalproject1.service.VetService;

import java.util.Scanner;

public class VetController {
    private final VetService vetService;
    private final Scanner scanner;

    public VetController(VetService vetService, Scanner scanner) {
        this.vetService = vetService;
        this.scanner = scanner;
    }

    public void createVet() {
        try {
            System.out.println("Please insert the vet's first name:");
            String firstName = scanner.nextLine();
            System.out.println("Please insert the vet's last name:");
            String lastName = scanner.nextLine();
            System.out.println("Please insert the vet's address:");
            String address = scanner.nextLine();
            System.out.println("Please insert the vet's speciality:");
            String speciality = scanner.nextLine();

            vetService.addVet(firstName,lastName,address,speciality);
            System.out.println("Vet's details successfully saved!");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (EntityUpdateFailedException e){
            System.err.println(e.getMessage());
            System.err.println("Please retry!");
        }catch (Exception e){
            System.err.println("Internal server error");
        }
    }
}
