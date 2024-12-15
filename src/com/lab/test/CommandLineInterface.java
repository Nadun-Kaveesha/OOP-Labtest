package com.lab.test;

import java.util.Scanner;

public class CommandLineInterface {
    public CommandLineInterface() {
    }

    public static Configuration configureSystem() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int totalTickets = getInput(scanner, "Enter Total Tickets: ");
        int ticketReleaseRate = getInput(scanner, "Enter Ticket Release Rate: ");
        int customerRetrievalRate = getInput(scanner, "Enter com.lab.test.Customer Retrieval Rate: ");
        int maxTicketCapacity = getInput(scanner, "Enter Max Ticket Capacity: ");
        Logger.log("System configured successfully.");
        return new Configuration(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
    }

    private static int getInput(Scanner scanner, String prompt) throws Exception {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value > 0) {
                    return value; // Valid input, return the value
                }
                // Throw exception but catch it immediately to continue
                throw new InvalidConfigurationException("Value must be positive. Try again.");
            } catch (NumberFormatException e) {
                // Catch invalid number input
                System.out.println("Invalid input. Please enter a number.");
            } catch (InvalidConfigurationException e) {
                // Catch and handle custom exception
                System.out.println(e.getMessage());
            }
        }
    }
}
