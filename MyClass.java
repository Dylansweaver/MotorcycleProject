package com.example;
/*
ideas:
allow a person to add notes/pictures to each stop/destination to look back on for memories
*/
import java.util.*;
import java.lang.*;

public class MyClass {
    public static int menu() {//this is the main menu

        int selection = 0;

        Scanner input = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Motorcycle Trip Planner");
        System.out.println("1. Destination");//option to view destinations
        System.out.println("2. New Destination");//option for new destination
        System.out.println("3. Remove Destination");//option to remove a destination and all its stops
        System.out.println("4. Exit");//exit program

        try//this is check validation to makes sure only option offered can be chosen
        {
            selection = input.nextInt();
            input.nextLine();
        }
        catch(InputMismatchException exception)
        {

            //when user put other than integer

        }
        return selection;//this returns the selection

    }

    public static int secondMenu() {//this is the menu that appears once a destination is chosen

        int selection = 0;
        Scanner input = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("1. Main Menu");//choice to return to main menu
        System.out.println("2. New Stop");//create a new stop for the destination
        System.out.println("3. Display Stops");//this displays the stops for the specific destination
        System.out.println("4. Remove Stops");//this is to remove a specific stop from the destination
        System.out.println("5. Exit");//ends program

        try//another input validation
        {
            selection = input.nextInt();
            input.nextLine();
        }
        catch(InputMismatchException exception)
        {
            //when user put other than integer

        }

        return selection;//returns the selection
    }

    public static void main(String args[]) {//messy main
        // variables
        List<String> listDestinations = new ArrayList<String>();//the list array for the main destinations
        ArrayList<List<String>> listStops = new ArrayList<List<String>>();//a list array of list arrays to store the stops

        boolean menuChoices = true;//this is to display the first menu when needed
        boolean menuChoices2 = true;//this is to display the second menu when needed
        int choice;//this is for the first menu choice
        int choice2;//this is for the second menu choice
        int storingStops;//this is a variable i use to help store stops to the specific destination
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);


        while (menuChoices != false) {//to list the main menu
            choice = menu();//displays menu
            menuChoices2 = true;
            switch (choice) {
                case 1://to display all destinations
                    if (listDestinations.isEmpty()) {//checks to see if there are destiantions so it wont open the list and break the program
                        System.out.println("\n\nNo Destinations Yet!\n\n");
                        break;
                    } else {
                        menuChoices = false;
                        System.out.println("*****Destinations*****");//displays the destinations
                        for (int i = 0; i < listDestinations.size(); i++) {//uses the destinations list to display the destinations
                            System.out.println((i + 1) + ". " + listDestinations.get(i));
                        }

                        System.out.println("\n");

                        choice2 = scanner.nextInt();//takes the destination choice
                        scanner.nextLine();//cleans up any possible left over scanner space
                        storingStops = choice2;//stores the destination choice for use in storting stops

                        while (choice2 > listDestinations.size() || choice2 <= 0) {//input validation for destinations
                            System.out.println("\n\n\nError: Please Choose One!");
                            for (int i = 0; i < listDestinations.size(); i++) {
                                System.out.println((i + 1) + ". " + listDestinations.get(i));
                            }
                            choice2 = scanner.nextInt();
                            scanner.nextLine();//cleans up any possible left over scanner space
                            storingStops = choice2;

                        }
                        while (menuChoices2 != false) {//to list the second menu
                            choice2 = secondMenu();
                            switch (choice2) {
                                case 1://returns to main menu
                                    menuChoices = true;
                                    menuChoices2 = false;
                                    break;
                                case 2://new stops for the destination
                                    //ArrayList<String> arrayStops = new ArrayList<String>();//the list array to store the stops
                                    System.out.print("\n\nStop Name: \n");
                                    String name = scanner2.nextLine();
                                    scanner2.nextLine();//cleans up any possible left over scanner space
                                    listStops.get(storingStops - 1).add(name);


                                    break;
                                case 3://displays stops
                                    if (listStops.get(storingStops - 1).isEmpty()) {//checks for stops to prevent opening nothing
                                        System.out.println("\n\nThere are no Stops Yet!\n\n");
                                        break;
                                    } else {
                                        System.out.println("\n\nThe Stops for this Destination");
                                        System.out.println("******************************");
                                        for (int i = 0; i < listStops.get(storingStops - 1).size(); i++) {//list stops
                                            System.out.println((i + 1) + ". " + listStops.get(storingStops - 1).get(i));
                                        }
                                    }
                                    break;
                                case 4://to remove stops from the destination
                                    if (listStops.get(storingStops - 1).isEmpty()) {//checks for stops to prevent opening nothing
                                        System.out.println("\n\nThere are no Stops Yet!\n\n");
                                        break;
                                    } else {
                                        System.out.println("\n\n Which stop would you like to remove?");
                                        for (int i = 0; i < listStops.get(storingStops - 1).size(); i++) {//list stops
                                            System.out.println((i + 1) + ". " + listStops.get(storingStops - 1).get(i));
                                        }
                                        int removeStop = scanner.nextInt();//creates value to use to choose stop to remove
                                        scanner.nextLine();//cleans up any possible left over scanner space
                                        listStops.get(storingStops - 1).remove(removeStop - 1);//removes stop
                                        System.out.println("Stop removed");
                                        break;
                                    }
                                case 5://ends program
                                    return;


                                default:
                                    System.out.println("\n\n\nError: Please Choose One!");

                            }
                        }
                    }

                    break;
                case 2://creates new destination
                    System.out.println("\n\nDestination Name: ");
                    String destination = scanner.nextLine();
                    scanner.nextLine();//cleans up any possible left over scanner space
                    listDestinations.add(destination);
                    System.out.println("\n");
                    ArrayList<String> arrayStops = new ArrayList<String>();
                    listStops.add(arrayStops);
                    break;

                case 3://deletes a destination
                    if (listDestinations.isEmpty()) {//checks to see if there are destiantions so it wont open the list and break the program
                        System.out.println("\n\nNo Destinations Yet!\n\n");
                        break;
                    } else {
                        System.out.println("\n\n Which Destination would you like to remove?");
                        System.out.println("*****Destinations*****");
                        for (int i = 0; i < listDestinations.size(); i++) {//displays destiantions
                            System.out.println((i + 1) + ". " + listDestinations.get(i));
                        }
                        int removeDestination = scanner.nextInt();//creates value to use to remove destination
                        scanner.nextLine();//cleans up any possible left over scanner space
                        listDestinations.remove(removeDestination - 1);//removes destination
                        listStops.remove(removeDestination - 1);//removes all stops associated with the destination
                        System.out.println("Destination Removed\n\n");
                        break;
                    }
                        case 4://ends program
                            //menuChoices=true;
                            return;
                        default:
                            System.out.println("\n\n\nError: Please Choose One!");

                    }

        }
    }
}
