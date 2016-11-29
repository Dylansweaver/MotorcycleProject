package com.example;
/*
ideas:
allow a person to add notes/pictures to each stop/destination to look back on for memories
*/
import java.util.*;
import java.lang.*;

public class MyClass {
    public static int menu() {

        int selection=0;

            Scanner input = new Scanner(System.in);

            System.out.println(" ");
            System.out.println("Motorcycle Trip Planner");
            System.out.println("1. Destination");
            System.out.println("2. New Destination");
            System.out.println("3. Exit");


          
                selection = input.nextInt();
             

        return selection;
    }
    public static int secondMenu() {

        int selection=0;
        Scanner input = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("1. Main Menu");
        System.out.println("2. New Stop");
        System.out.println("3. Display Stops");
        System.out.println("4. Exit");

        
            selection = input.nextInt();
          

        return selection;
    }

    public static void main(String args[]) {
        // variables
        List<String> listDestinations = new ArrayList<String>();
        List<ArrayList<String>> listStops = new ArrayList<ArrayList<String>>();
        List<String> arrayStops = new ArrayList<String>();
        boolean menuChoices=true;
        boolean menuChoices2=true;
        int choice;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);





        while(menuChoices!=false) {//to list the main menu
            choice = menu();
            menuChoices2=true;
            switch (choice) {
                case 1://to display all destinations
                    int choice2;
                    menuChoices=false;
                    System.out.println("*****Destinations*****");
                    for (int i = 0; i < listDestinations.size(); i++) {
                        System.out.println((i+1)+". "+listDestinations.get(i));
                    }
                    System.out.println("\n");

                    choice2=scanner.nextInt();

                    while(menuChoices2!=false){//to list the second menu
                        choice2 = secondMenu();
                        switch (choice2){
                            case 1:
                                menuChoices=true;
                                menuChoices2=false;
                                break;
                            case 2:

                                System.out.print("\n\nStop Name: \n");
                                String name = scanner2.nextLine();

                                arrayStops.add(name);


                                break;
                            case 3:

                                for (int i = 0; i < arrayStops.size(); i++) {
                                    System.out.println((i+1)+". "+arrayStops.get(i));
                                }
                                break;

                            case 4:
                                return;


                            default:
                                System.out.println("Please Choose one!");

                        }
                    }


                    break;
                case 2:
                    System.out.println("\n\nDestination Name: ");
                    String destination = scanner.nextLine();
                    listDestinations.add(destination);
                    System.out.println("\n");

                    break;


                case 3:
                    //menuChoices=true;
                    return;
                default:
                    System.out.println("Please Choose one!");

            }
        }
    }
}
