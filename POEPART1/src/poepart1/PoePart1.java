/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poepart1;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class PoePart1 {

    public static void main(String[] args) {
        // Create an object of the Login class
        Login register = new Login();
        
        // Create a scanner to read user input
        Scanner scan = new Scanner(System.in);

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

        // Call the registerUser method and print the result
        System.out.println(register.registerUser(name, password, cellphone));

        // If registration was successful, proceed to login
        if (register.registerStatus(name, password, cellphone)) {
            
            System.out.println("\n======= Login =======");
            
            // Ask for username again for login
            System.out.println("Please enter your username to login");
            String loginName = scan.nextLine();
            
            // Ask for password again for login
            System.out.println("Please enter your password to login");
            String loginPass = scan.nextLine();
            
            // Check if login was successful
            boolean loginSuccess = register.loginUser(loginName, loginPass);
            
            // Print the login status message
            System.out.println(register.returnLoginStatus(loginSuccess));
            
        } else {
            // If registration failed, tell the user they can't login
            System.out.println("Registration failed. Cannot login.");
        }
        
        // Close the scanner
        scan.close();
    }
}