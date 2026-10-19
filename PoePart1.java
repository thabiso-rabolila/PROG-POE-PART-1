/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poepart2;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class PoePart1 {

    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner scan = new Scanner(System.in);

        // Create an object of the Login class
        Login register = new Login();

        // Create an object of the Message class
        Message msg = new Message();

        // ==================== REGISTRATION ====================
        System.out.println("\n======= Register =======");

        // Ask for the first name
        System.out.println("Please enter your first name");
        String firstName = scan.nextLine();

        // Ask for the last name
        System.out.println("Please enter your last name");
        String lastName = scan.nextLine();

        // Ask for the username
        System.out.println("Please enter the username");
        String name = scan.nextLine();

        // Ask for the password
        System.out.println("Please enter the password");
        String password = scan.nextLine();

        // Ask for the cellphone number
        System.out.println("Enter cellphone number");
        String cellphone = scan.nextLine();

        // Store the names in the object so Login can use them
        register.firstName = firstName;
        register.lastName = lastName;

        // Register the user and print the result
        System.out.println(register.registerUser(name, password, cellphone));

        // Only continue if registration was successful
        if (!register.registerStatus(name, password, cellphone)) {
            System.out.println("Registration failed. Cannot login.");
            scan.close();
            return;
        }

        // ==================== LOGIN ====================
        System.out.println("\n======= Login =======");

        System.out.println("Please enter your username to login");
        String loginName = scan.nextLine();

        System.out.println("Please enter your password to login");
        String loginPass = scan.nextLine();

        // Check if login was successful
        boolean loginSuccess = register.loginUser(loginName, loginPass);
        System.out.println(register.returnLoginStatus(loginSuccess));

        // If login failed, exit the program
        if (!loginSuccess) {
            scan.close();
            return;
        }

        // ==================== WELCOME & MENU ====================
        System.out.println("\nWelcome to QuickChat.");

        // This boolean controls the main menu loop
        boolean running = true;

        // Keep showing the menu until the user chooses to quit
        while (running) {

            System.out.println("\nPlease choose an option:");
            System.out.println("Option 1) Send Messages");
            System.out.println("Option 2) Show recently sent messages");
            System.out.println("Option 3) Quit");

            // Read the user's choice
            int menuChoice = scan.nextInt();
            scan.nextLine(); // Consume the newline character

            if (menuChoice == 1) {
                // Ask how many messages they want to send
                System.out.println("How many messages do you want to send?");
                int numMessages = scan.nextInt();
                scan.nextLine(); // Consume the newline

                // Loop for each message the user wants to send
                for (int i = 0; i < numMessages; i++) {

                    System.out.println("\n--- Message " + (i + 1) + " ---");

                    // Ask for the recipient cell number
                    System.out.println("Enter recipient cell number");
                    String recipient = scan.nextLine();

                    // Ask for the message text
                    System.out.println("Enter your message");
                    String messageText = scan.nextLine();

                    // Check if the message is too long (more than 250 characters)
                    if (messageText.length() > 250) {
                        int excess = messageText.length() - 250;
                        System.out.println("Message exceeds 250 characters by " + excess + "; please reduce the size.");
                        i--; // Repeat this message
                        continue;
                    } else {
                        System.out.println("Message ready to send.");
                    }

                    // Generate the message ID
                    String messageID = msg.generateMessageID();
                    System.out.println("Message ID generated: " + messageID);

                    // Check the recipient cell
                    System.out.println(msg.checkRecipientCell(recipient));

                    // Create the message hash
                    String hash = msg.createMessageHash(messageID, i + 1, messageText);

                    // Ask the user what to do with the message
                    System.out.println("\nWhat would you like to do?");
                    System.out.println("1) Send Message");
                    System.out.println("2) Disregard Message");
                    System.out.println("3) Store Message to send later");
                    int sendChoice = scan.nextInt();
                    scan.nextLine(); // Consume newline

                    // Call the SentMessage method and print the result
                    String result = msg.SentMessage(sendChoice);
                    System.out.println(result);

                    // Only display details if the message was sent
                    if (sendChoice == 1) {
                        System.out.println("\n--- Message Details ---");
                        System.out.println("Message ID: " + messageID);
                        System.out.println("Message Hash: " + hash);
                        System.out.println("Recipient: " + recipient);
                        System.out.println("Message: " + messageText);

                        // Save to the ArrayList so we can print them later
                        Message.sentMessages.add("ID: " + messageID + " | Hash: " + hash + " | To: " + recipient + " | " + messageText);
                    }

                    // If the user chose to store the message
                    if (sendChoice == 3) {
                        msg.storeMessage(messageID, hash, recipient, messageText);
                    }
                }

                // Display total messages sent
                System.out.println("\nTotal messages sent: " + msg.returnTotalMessages());

            } else if (menuChoice == 2) {
                // Show the messages that were sent
                System.out.println("Coming Soon.");

            } else if (menuChoice == 3) {
                // Exit the loop
                System.out.println("Goodbye!");
                running = false;

            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        // Close the scanner
        scan.close();
    }
}