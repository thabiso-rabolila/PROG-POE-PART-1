package poepart1;

import java.util.Scanner;

public class POEPART1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Create an instance of the Login class
        Login login = new Login();
        
        System.out.println("===== REGISTRATION SYSTEM =====");
        System.out.println();
        
        // Step 1: Get user details for registration
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        
        System.out.print("Enter username: ");
        String username = input.nextLine();
        
        System.out.print("Enter password: ");
        String password = input.nextLine();
        
        
        System.out.print("Enter cell phone number (e.g., +27821234567): ");
        String cellNumber = input.nextLine();
        
        System.out.println();
        
        // Register the user
        String registrationResult = login.registerUser(username, password, cellNumber);
        System.out.println(registrationResult);
        
        // If registration was successful, proceed to login
        if (registrationResult.equals("User registered successfully.")) {
            System.out.println();
            System.out.println("===== LOGIN SYSTEM =====");
            System.out.println();
            
            System.out.print("Enter username: ");
            String loginUsername = input.nextLine();
            
            System.out.print("Enter password: ");
            String loginPassword = input.nextLine();
            
            // Attempt login
            boolean loginSuccess = login.loginUser(loginUsername, loginPassword);
            System.out.println(login.returnLoginStatus(loginSuccess, firstName, lastName));
        }
        
        input.close();
    }
}