package poepart1;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
    
    @Test
    public void testCheckUserName_CorrectFormat() {
        Login login = new Login();
        boolean result = login.checkUserName("kyl_1");
        assertEquals("Username should be correctly formatted", true, result);
    }
    
    @Test
    public void testCheckUserName_IncorrectFormat() {
        Login login = new Login();
        boolean result = login.checkUserName("kyle!!!!!!!");
        assertEquals("Username should be incorrectly formatted", false, result);
    }
    
    @Test
    public void testCheckPasswordComplexity_CorrectPassword() {
        Login login = new Login();
        boolean result = login.checkPasswordComplexity("Ch&&sec@ke99!");
        assertEquals("Password should meet complexity requirements", true, result);
    }
    
    @Test
    public void testCheckPasswordComplexity_IncorrectPassword() {
        Login login = new Login();
        boolean result = login.checkPasswordComplexity("password");
        assertEquals("Password should not meet complexity requirements", false, result);
    }
    
    @Test
    public void testCheckCellPhoneNumber_CorrectFormat() {
        Login login = new Login();
        boolean result = login.checkCellPhoneNumber("+27838968976");
        assertEquals("Cell number should be correctly formatted", true, result);
    }
    
    @Test
    public void testCheckCellPhoneNumber_IncorrectFormat() {
        Login login = new Login();
        boolean result = login.checkCellPhoneNumber("08966553");
        assertEquals("Cell number should be incorrectly formatted", false, result);
    }
    
    @Test
    public void testLoginUser_Successful() {
        Login login = new Login();
        // First register a user
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        // Then test login
        boolean result = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertEquals("Login should be successful", true, result);
    }
    
    @Test
    public void testLoginUser_Failed() {
        Login login = new Login();
        // First register a user
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        // Then test login with wrong password
        boolean result = login.loginUser("kyl_1", "wrongpass");
        assertEquals("Login should fail", false, result);
    }
    
    @Test
    public void testRegisterUser_ValidUsername_InvalidPassword() {
        Login login = new Login();
        String result = login.registerUser("kyl_1", "pass", "+27838968976");
        String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        assertEquals("Should return password error message", expected, result);
    }
    
    @Test
    public void testRegisterUser_ValidUsername_ValidPassword_ValidCell() {
        Login login = new Login();
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        String expected = "User registered successfully.";
        assertEquals("Should return success message", expected, result);
    }
}