package poepart1;

public class Login {
    
    // Variables to store registration details
    private String registeredUsername;
    private String registeredPassword;
    private String registeredCellNumber;
    
    // Method to check if username is correctly formatted
    public boolean checkUserName(String username) {
        // Check if username contains underscore and is no more than 5 characters
        if (username.contains("_") && username.length() <= 5) {
            return true;
        }
        else {
            return false;
        }
    }
    
    // Method to check if password meets complexity requirements
    public boolean checkPasswordComplexity(String password) {
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        
        // Check password length
        if (password.length() < 8) {
            return false;
        }
        
        // Check each character in password
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            
            // Check for capital letter
            if (ch >= 'A' && ch <= 'Z') {
                hasCapital = true;
            }
            
            // Check for number
            if (ch >= '0' && ch <= '9') {
                hasNumber = true;
            }
            
            // Check for special character (not letter or number)
            if (!(ch >= 'A' && ch <= 'Z') && !(ch >= 'a' && ch <= 'z') && !(ch >= '0' && ch <= '9')) {
                hasSpecial = true;
            }
        }
        
        // Return true only if all conditions are met
        if (hasCapital && hasNumber && hasSpecial) {
            return true;
        }
        else {
            return false;
        }
    }
    
    // Method to check if cell phone number is correctly formatted
    // Reference: https://stackoverflow.com/questions/49423017/regex-for-south-african-phone-numbers
    public boolean checkCellPhoneNumber(String cellNumber) {
        // Check if cell number starts with +27 and has proper length
        if (cellNumber.startsWith("+27")) {
            // Remove the country code to check remaining digits
            String numberPart = cellNumber.substring(3);
            
            // Check if the remaining part has 9 digits (since SA numbers have 9 digits after +27)
            if (numberPart.length() == 9) {
                // Check if all remaining characters are digits
                for (int i = 0; i < numberPart.length(); i++) {
                    char ch = numberPart.charAt(i);
                    if (!(ch >= '0' && ch <= '9')) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    // Method to register the user
    public String registerUser(String username, String password, String cellNumber) {
        boolean validUsername = checkUserName(username);
        boolean validPassword = checkPasswordComplexity(password);
        boolean validCell = checkCellPhoneNumber(cellNumber);
        
        if (!validUsername) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        else if (!validPassword) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        else if (!validCell) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }
        else {
            // Store registration details
            registeredUsername = username;
            registeredPassword = password;
            registeredCellNumber = cellNumber;
            return "User registered successfully.";
        }
    }
    
    // Method to verify login details
    public boolean loginUser(String username, String password) {
        if (username.equals(registeredUsername) && password.equals(registeredPassword)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    // Method to return login status message
    public String returnLoginStatus(boolean loginSuccess, String firstName, String lastName) {
        if (loginSuccess) {
            return "Welcome " + firstName + " " + lastName + " it is great to see you again.";
        }
        else {
            return "Username or password incorrect, please try again.";
        }
    }
}