package com.sda.practicalproject1.controller;

import com.sda.practicalproject1.service.ConsultService;

import java.rmi.ServerError;
import java.util.Scanner;

public class ConsultController {
    private final ConsultService consultService;
    private final Scanner scanner;

    public ConsultController(ConsultService consultService, Scanner scanner) {
        this.consultService = consultService;
        this.scanner = scanner;
    }

    public void createConsult(){
        System.err.println("Please insert vet's id");
        long vetId = Long.parseLong(scanner.nextLine().trim());
        System.err.println("Please insert pet's id");
        long petId = Long.parseLong(scanner.nextLine().trim());
        System.err.println("Please insert description");
        String description = scanner.nextLine().trim();
        System.err.println();
    }
}
