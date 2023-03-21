package com.sda.practicalproject1.controller;

import com.sda.practicalproject1.model.Pet;
import com.sda.practicalproject1.model.Vet;
import com.sda.practicalproject1.repository.exception.EntityUpdateFailedException;
import com.sda.practicalproject1.service.PetService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PetController {
    private final Scanner scanner;
    private final PetService petService;

    public PetController(Scanner scanner, PetService petService) {
        this.scanner = scanner;
        this.petService = petService;
    }

    public void createPet() {
        try {
            System.out.println("Please insert race");
            String race = scanner.nextLine();
            System.out.println("Is pet vaccinated? (True/False)");
            boolean isVaccinated = Boolean.parseBoolean(scanner.nextLine());
            System.out.println("Please insert owner name");
            String ownerName = scanner.nextLine();
            System.out.println("Please insert date of birth (YYYY-MM-DD) : ");

            Date dateOfBirth = Date.from(LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_TIME)
                    .atStartOfDay()
                    .toInstant(ZoneOffset.UTC));
            petService.addPet(race, dateOfBirth, isVaccinated, ownerName);
            System.out.println("Pet was created");

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (EntityUpdateFailedException e) {
            System.err.println(e.getMessage());
            System.err.println("Please retry!");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format");
        } catch (Exception e) {
            System.err.println("Internal server error");
            e.printStackTrace();
        }
    }
    public void viewAllPets(){
        petService.getAllPets().stream().forEach(pet -> System.out.println(pet.getId()
                + " "+ pet.getRace() + " "+ pet.getOwnerName()));
    }
    public void viewPetById(){
        try {
            System.out.println("Please enter pet's id");
            long id = Long.parseLong(scanner.nextLine());
            Optional<Pet> optionalPet = petService.getPetById(id);
            if (optionalPet.isPresent()) {
                System.err.println(optionalPet.get());
            } else {
                System.err.println("Pet was not found by id"+ id);
            }
        } catch (NumberFormatException e) {
            System.err.println("Please insert a valid numeric id");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Internal server error");
        }
    }
}
