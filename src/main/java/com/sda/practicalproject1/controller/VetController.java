package com.sda.practicalproject1.controller;

import com.sda.practicalproject1.model.Vet;
import com.sda.practicalproject1.repository.exception.EntityUpdateFailedException;
import com.sda.practicalproject1.service.VetService;
import com.sda.practicalproject1.service.exception.EntitiyNotFoundException;

import java.nio.channels.ScatteringByteChannel;
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

            vetService.addVet(firstName, lastName, address, speciality);
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
    public void displayAllVets(){
        for(Vet vet : vetService.getAllVets()){
            System.out.println((vet.getId()+" "+vet.getFirstName()+" "+vet.getLastName()));
        }
    }
    public void updateVet() {
        try {
            System.out.println("Please enter vet's id");
            long id = Long.parseLong(scanner.nextLine());
            System.out.println("Please insert the vet's last name:");
            String lastName = scanner.nextLine();
            System.out.println("Please insert the vet's address:");
            String address = scanner.nextLine();
            System.out.println("Please insert the vet's speciality:");
            String speciality = scanner.nextLine();

            vetService.updateVet(id, lastName, address, speciality);
            System.out.println("Vet has been updated");


        }catch (NumberFormatException e){
            System.err.println("Please insert a valid numeric id");
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }catch (EntityUpdateFailedException e) {
            System.err.println(e.getMessage());
            System.err.println("Please retry!");
        }catch (EntitiyNotFoundException e){
            System.err.println(e.getMessage());
        } catch (Exception e){
        System.err.println("Internal server error");
    }


    }
}
