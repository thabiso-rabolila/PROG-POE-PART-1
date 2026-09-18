/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepart1;

/**
 *
 * @author Student
 */
public class Login extends Registration {

    // Method to check if the login details match what was registered
    public boolean loginUser(String name, String password) {
        // Compare the input with the stored class variables
        return name.equals(userName) && password.equals(Password);
    }

    // Method to return the login message based on status
    public String returnLoginStatus(boolean status) {
        if (status) {
            // If login was successful, welcome the user by name
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            // If login failed
            return "Username or password incorrect, please try again.";
        }
    }
}