package com.example;
/*
ideas:
allow a person to add notes/pictures to each stop/destination to look back on for memories
*/
import java.util.*;
import java.lang.*;

public class MyClass {
    public static int menu() {

        int selection = 0;

        Scanner input = new Scanner(System.in);

            System.out.println(" ");
            System.out.println("Motorcycle Trip Planner");
            System.out.println("1. Destination");
            System.out.println("2. New Destination");
            System.out.println("3. Remove Destination");
            System.out.println("4. Exit");

        try
        {
            selection = input.nextInt();
        }
        catch(InputMismatchException exception)
        {

            //when user put other than integer

        }
            return selection;

    }

    public static int secondMenu() {

        int selection = 0;
        Scanner input = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("1. Main Menu");
        System.out.println("2. New Stop");
        System.out.println("3. Display Stops");
        System.out.println("4. Remove Stops");
        System.out.println("5. Exit");

        try
        {
            selection = input.nextInt();
        }
        catch(InputMismatchException exception)
        {
            //when user put other than integer

        }

        return selection;
    }

    public static void main(String args[]) {
        // variables
        List<String> listDestinations = new ArrayList<String>();//the list array for the main destinations
        ArrayList<List<String>> listStops = new ArrayList<List<String>>();//a list array of list arrays to store the stops

        boolean menuChoices = true;//this is to display the first menu when needed
        boolean menuChoices2 = true;//this is to display the second menu when needed
        int choice;//this is for the first menu choice
        int choice2;//this is for the second menu choice
        int storingStops;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);


        while (menuChoices != false) {//to list the main menu
            choice = menu();
            menuChoices2 = true;
            switch (choice) {
                case 1://to display all destinations
                    if(listDestinations.isEmpty()){
                        System.out.println("\n\nNo Destinations Yet!\n\n");
                        break;
                    }
                    else {
                        menuChoices = false;
                        System.out.println("*****Destinations*****");
                        for (int i = 0; i < listDestinations.size(); i++) {
                            System.out.println((i + 1) + ". " + listDestinations.get(i));
                        }

                        System.out.println("\n");

                        choice2 = scanner.nextInt();
                        storingStops = choice2;

                        while (choice2 > listDestinations.size() || choice2 <= 0) {
                            System.out.println("\n\n\nError: Please Choose One!");
                            for (int i = 0; i < listDestinations.size(); i++) {
                                System.out.println((i + 1) + ". " + listDestinations.get(i));
                            }
                            choice2 = scanner.nextInt();

                        }
                        while (menuChoices2 != false) {//to list the second menu
                            choice2 = secondMenu();
                            switch (choice2) {
                                case 1:
                                    menuChoices = true;
                                    menuChoices2 = false;
                                    break;
                                case 2:
                                    //ArrayList<String> arrayStops = new ArrayList<String>();//the list array to store the stops
                                    System.out.print("\n\nStop Name: \n");
                                    String name = scanner2.nextLine();

                                    listStops.get(storingStops - 1).add(name);


                                    break;
                                case 3:
                                    if(listStops.get(storingStops - 1).isEmpty()){
                                        System.out.println("\n\nThere are no Stops Yet!\n\n");
                                        break;
                                    }
                                    else {
                                        System.out.println("\n\nThe Stops for this Destination");
                                        System.out.println("******************************");
                                        for (int i = 0; i < listStops.get(storingStops - 1).size(); i++) {
                                            System.out.println((i + 1) + ". " + listStops.get(storingStops - 1).get(i));
                                        }
                                    }
                                    break;
                                case 4:
                                    System.out.println("\n\n Which stop would you like to remove?");
                                    for (int i = 0; i < listStops.get(storingStops - 1).size(); i++) {
                                        System.out.println((i + 1) + ". " + listStops.get(storingStops - 1).get(i));
                                    }
                                    int removeStop = scanner.nextInt();
                                    listStops.get(storingStops - 1).remove(removeStop - 1);
                                    break;
                                case 5:
                                    return;


                                default:
                                    System.out.println("\n\n\nError: Please Choose One!");

                            }
                        }
                    }

                    break;
                case 2:
                    System.out.println("\n\nDestination Name: ");
                    String destination = scanner.nextLine();
                    listDestinations.add(destination);
                    System.out.println("\n");
                    ArrayList<String> arrayStops = new ArrayList<String>();
                    listStops.add(arrayStops);
                    break;

                case 3:
                    System.out.println("\n\n Which Destination would you like to remove?");
                    System.out.println("*****Destinations*****");
                    for (int i = 0; i < listDestinations.size(); i++) {
                        System.out.println((i + 1) + ". " + listDestinations.get(i));
                    }
                    int removeDestination= scanner.nextInt();
                    listDestinations.remove(removeDestination-1);
                    listStops.remove(removeDestination-1);
                    System.out.println("Destination Removed\n\n");
                    break;
                case 4:
                    //menuChoices=true;
                    return;
                default:
                    System.out.println("\n\n\nError: Please Choose One!");

            }
        }
    }
}
