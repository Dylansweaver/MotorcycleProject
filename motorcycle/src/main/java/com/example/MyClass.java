package com.example;
/*
ideas:
allow a person to add notes/pictures to each stop/destination to look back on for memories
*/
import java.util.*;
import java.lang.*;

public class MyClass {
    public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);


        System.out.println("Motorcycle Trip Planner");
        System.out.println("1. Destination");
        System.out.println("2. New Destination");
        System.out.println("3. Exit");

        selection = input.nextInt();
        return selection;
    }

    public static void main(String args[]) {
        // variables
        List<String> listDestinations = new ArrayList<String>();
        boolean menuChoices=true;
        int choice;
        Scanner scanner = new Scanner(System.in);

while(menuChoices!=false) {
    choice = menu();

    switch (choice) {
        case 1:
            for (int i = 0; i < listDestinations.size(); i++) {
                System.out.println(listDestinations.get(i));
            }
            break;
        case 2:
            System.out.println("Destination Name: ");
            String destination = scanner.nextLine();
            listDestinations.add(destination);


            break;
        return;

        case 3:
            //menuChoices=true;

        default:

    }
}
    }
}
