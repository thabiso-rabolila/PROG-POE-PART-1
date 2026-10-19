/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepart2;

// Import Random so we can generate message IDs
import java.util.Random;

// Import ArrayList so we can store multiple messages
import java.util.ArrayList;

// Import FileWriter so we can save messages to a file (JSON-style)
import java.io.FileWriter;

// Import IOException to handle file errors
import java.io.IOException;

/**
 *
 * @author Student
 */
public class Message {

    // These variables store the message details
    String messageID;
    int messageNumber;
    String recipient;
    String messageText;
    String messageHash;

    // This ArrayList stores all messages that were sent
    static ArrayList<String> sentMessages = new ArrayList<>();

    // This counter keeps track of how many messages have been sent
    static int totalMessagesSent = 0;

    // This Random object is used to generate random message IDs
    Random random = new Random();

    // This method checks if the message ID is not more than 10 characters
    public boolean checkMessageID(String id) {
        // Return true if the ID is 10 characters or less
        return id.length() <= 10;
    }

    // This method checks if the recipient cell number is valid
    public String checkRecipientCell(String cell) {
        // Check if the cell number is valid (starts with +27 OR starts with 0 and is 10 digits)
        if (cell.startsWith("+27") || (cell.startsWith("0") && cell.length() == 10)) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }
    // This method generates a unique 10-digit message ID
    public String generateMessageID() {
        String id = "";
        // Loop 10 times to create 10 random digits
        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);
            id = id + digit;
        }
        return id;
    }

    // This method creates the message hash in the correct format
    public String createMessageHash(String id, int num, String message) {
        // Get the first two digits of the message ID
        String firstTwo = id.substring(0, 2);

        // Find the first word of the message
        String firstWord = "";
        if (message.contains(" ")) {
            firstWord = message.substring(0, message.indexOf(" "));
        } else {
            firstWord = message;
        }

        // Find the last word of the message
        String lastWord = "";
        if (message.contains(" ")) {
            lastWord = message.substring(message.lastIndexOf(" ") + 1);
        } else {
            lastWord = message;
        }

        // Combine everything into the hash format and make it uppercase
        String hash = firstTwo + ":" + num + ":" + firstWord + lastWord;
        return hash.toUpperCase();
    }

    // This method asks the user what to do with the message
    public String SentMessage(int choice) {
        if (choice == 1) {
            // Increment the total messages counter
            totalMessagesSent++;
            return "Message successfully sent.";
        } else if (choice == 2) {
            return "Press 0 to delete the message.";
        } else if (choice == 3) {
            return "Message successfully stored.";
        } else {
            return "Invalid option.";
        }
    }

    // This method returns all the messages that were sent
    public String printMessages() {
        String allMessages = "";
        // Loop through the ArrayList and add each message
        for (int i = 0; i < sentMessages.size(); i++) {
            allMessages = allMessages + sentMessages.get(i) + "\n";
        }
        return allMessages;
    }

    // This method returns the total number of messages sent
    public int returnTotalMessages() {
        return totalMessagesSent;
    }

    // This method stores a message in a JSON-style file
    // Reference: https://www.w3schools.com/java/java_files_create.asp
    public void storeMessage(String id, String hash, String recipient, String message) {
        try {
            // Create a FileWriter to write to the file (append mode)
            FileWriter writer = new FileWriter("messages.json", true);

            // Write the message as a JSON object
            writer.write("{\n");
            writer.write("  \"id\": \"" + id + "\",\n");
            writer.write("  \"hash\": \"" + hash + "\",\n");
            writer.write("  \"recipient\": \"" + recipient + "\",\n");
            writer.write("  \"message\": \"" + message + "\"\n");
            writer.write("}\n");

            // Close the writer
            writer.close();

        } catch (IOException e) {
            // If something goes wrong, print the error
            System.out.println("Error saving message: " + e.getMessage());
        }
    }
}