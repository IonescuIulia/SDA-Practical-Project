package com.sda.practicalproject1;

import com.sda.practicalproject1.controller.VetController;
import com.sda.practicalproject1.controller.menu.MenuItem;
import com.sda.practicalproject1.repository.VetRepositoryImpl;
import com.sda.practicalproject1.service.VetServiceImpl;
import com.sda.practicalproject1.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SessionManager.getSessionFactory();
        VetController vetController = new VetController(
                new VetServiceImpl(new VetRepositoryImpl()),
                scanner
        );


        for (int i = 1; i <= 100; i++) {
            System.out.println("///////////////////////////////////////////////////////////////////////////////////");
        }

        MenuItem selectedOption = MenuItem.UNKNOWN;
        while (selectedOption != MenuItem.EXIT) {
            System.out.println();
            MenuItem.printMeniuItems();
            System.out.println("Please select an option:");
            try {
                int numericOption = Integer.parseInt(scanner.nextLine());
                selectedOption = MenuItem.searchByOption(numericOption);
            } catch (NumberFormatException e){
                System.out.println("Please use a numeric value");
                selectedOption = MenuItem.UNKNOWN;
            }

            switch (selectedOption) {
                case ADD_VET:
                    vetController.createVet();
                    break;
                case UPDATE_VET:
                   vetController.updateVet();
                    break;
                case DELETE_VET:
                    System.out.println("Delete vet not implemented");
                    break;
                case VIEW_VET_LIST:
                    vetController.displayAllVets();
                    break;
                case VIEW_VET_BY_ID:
                    vetController.findVetById();
                    break;
                case EXIT:
                    System.out.println("Good bye!");
                    break;
                case UNKNOWN:
                    System.out.println("Please insert a valid option");
                    break;
                default:
                    System.out.println("Option not implemented");
                    break;

            }
        }

        SessionManager.shutdown();
    }
}