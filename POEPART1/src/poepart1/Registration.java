/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepart1;

/**
 *
 * @author Student
 */
public class Registration { // Start of class

    // These variables will store the user's details
    String userName;
    String Password;
    String CellPhone;
    String firstName;
    String lastName;

    // Method to check if the username is valid
    public boolean checkUserName(String username) { // Start of username method
        // Rule from brief: must contain underscore and be no more than 5 characters
        return username.contains("_") && username.length() <= 5;
    } // End of username method

    // Method to check if the password is strong enough using Regex
    public boolean checkPasswordComplexity(String password) { // Start of password method
        // Checks if password has 8+ chars, capital letter, lowercase, number, and special character
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[a-z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[^a-zA-Z0-9].*");
    } // End of password method

    // Method to check if the cell phone number is correct using Regex
    // Reference: https://stackoverflow.com/questions/49423017/regex-for-south-african-phone-numbers
    public boolean checkCellPhoneNumber(String cellphone) { // Start of cellphone method
        // Checks if it starts with +27 and has 9 digits after it
        return cellphone.matches("^\\+27[0-9]{9}$") || 
               cellphone.matches("^0[0-9]{9}$");
    } // End of cellphone method

    // Method to register the user and return the correct message
    public String registerUser(String username, String password, String cellphone) {
        
        // Check username first
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        
        // Check password
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        
        // Check cell phone number
        if (!checkCellPhoneNumber(cellphone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        
        // If we get here, all checks passed
        this.userName = username;
        this.Password = password;
        this.CellPhone = cellphone;
        
        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
    }

    // Method to return the registration status as a boolean
    public boolean registerStatus(String username, String password, String cellphone) {
        return checkUserName(username) &&
               checkPasswordComplexity(password) &&
               checkCellPhoneNumber(cellphone);
    }
    
} // End of class