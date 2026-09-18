/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package poepart1;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Student
 */
public class RegistrationNGTest {

    public RegistrationNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    // ==================== USERNAME TESTS ====================

    /**
     * Test: Username is correctly formatted (kyl_1)
     */
    @Test
    public void testCheckUserName_Valid() {
        System.out.println("testCheckUserName_Valid");
        String username = "kyl_1";
        Registration instance = new Registration();
        boolean expResult = true;
        boolean result = instance.checkUserName(username);
        assertEquals(result, expResult);
    }

    /**
     * Test: Username is incorrectly formatted (kyle!!!!!!!)
     */
    @Test
    public void testCheckUserName_Invalid() {
        System.out.println("testCheckUserName_Invalid");
        String username = "kyle!!!!!!!";
        Registration instance = new Registration();
        boolean expResult = false;
        boolean result = instance.checkUserName(username);
        assertEquals(result, expResult);
    }

    // ==================== PASSWORD TESTS ====================

    /**
     * Test: Password meets complexity requirements (Ch&&sec@ke99!)
     */
    @Test
    public void testCheckPasswordComplexity_Valid() {
        System.out.println("testCheckPasswordComplexity_Valid");
        String password = "Ch&&sec@ke99!";
        Registration instance = new Registration();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(result, expResult);
    }

    /**
     * Test: Password does not meet complexity requirements (password)
     */
    @Test
    public void testCheckPasswordComplexity_Invalid() {
        System.out.println("testCheckPasswordComplexity_Invalid");
        String password = "password";
        Registration instance = new Registration();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(result, expResult);
    }

    // ==================== CELL PHONE TESTS ====================

    /**
     * Test: Cell phone is correctly formatted (+27838968976)
     */
    @Test
    public void testCheckCellPhoneNumber_Valid() {
        System.out.println("testCheckCellPhoneNumber_Valid");
        String cellphone = "+27838968976";
        Registration instance = new Registration();
        boolean expResult = true;
        boolean result = instance.checkCellPhoneNumber(cellphone);
        assertEquals(result, expResult);
    }

    /**
     * Test: Cell phone is incorrectly formatted (08966553)
     */
    @Test
    public void testCheckCellPhoneNumber_Invalid() {
        System.out.println("testCheckCellPhoneNumber_Invalid");
        String cellphone = "08966553";
        Registration instance = new Registration();
        boolean expResult = false;
        boolean result = instance.checkCellPhoneNumber(cellphone);
        assertEquals(result, expResult);
    }

    // ==================== REGISTER USER TESTS ====================

    /**
     * Test: registerUser returns the correct success messages
     */
    @Test
    public void testRegisterUser_Success() {
        System.out.println("testRegisterUser_Success");
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String cellphone = "+27838968976";
        Registration instance = new Registration();
        String expResult = "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
        String result = instance.registerUser(username, password, cellphone);
        assertEquals(result, expResult);
    }

    /**
     * Test: registerUser returns correct message for invalid username
     */
    @Test
    public void testRegisterUser_InvalidUsername() {
        System.out.println("testRegisterUser_InvalidUsername");
        String username = "kyle!!!!!!!";
        String password = "Ch&&sec@ke99!";
        String cellphone = "+27838968976";
        Registration instance = new Registration();
        String expResult = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        String result = instance.registerUser(username, password, cellphone);
        assertEquals(result, expResult);
    }

    /**
     * Test: registerUser returns correct message for invalid password
     */
    @Test
    public void testRegisterUser_InvalidPassword() {
        System.out.println("testRegisterUser_InvalidPassword");
        String username = "kyl_1";
        String password = "password";
        String cellphone = "+27838968976";
        Registration instance = new Registration();
        String expResult = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        String result = instance.registerUser(username, password, cellphone);
        assertEquals(result, expResult);
    }

    /**
     * Test: registerUser returns correct message for invalid cell phone
     */
    @Test
    public void testRegisterUser_InvalidCellPhone() {
        System.out.println("testRegisterUser_InvalidCellPhone");
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String cellphone = "08966553";
        Registration instance = new Registration();
        String expResult = "Cell phone number incorrectly formatted or does not contain international code.";
        String result = instance.registerUser(username, password, cellphone);
        assertEquals(result, expResult);
    }

    // ==================== REGISTER STATUS TESTS ====================

    /**
     * Test: registerStatus returns true for valid data
     */
    @Test
    public void testRegisterStatus_Valid() {
        System.out.println("testRegisterStatus_Valid");
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String cellphone = "+27838968976";
        Registration instance = new Registration();
        boolean expResult = true;
        boolean result = instance.registerStatus(username, password, cellphone);
        assertEquals(result, expResult);
    }

    /**
     * Test: registerStatus returns false for invalid data
     */
    @Test
    public void testRegisterStatus_Invalid() {
        System.out.println("testRegisterStatus_Invalid");
        String username = "kyle!!!!!!!";
        String password = "password";
        String cellphone = "08966553";
        Registration instance = new Registration();
        boolean expResult = false;
        boolean result = instance.registerStatus(username, password, cellphone);
        assertEquals(result, expResult);
    }

    // ==================== LOGIN TESTS ====================

    /**
     * Test: loginUser returns true for correct credentials
     */
    @Test
    public void testLoginUser_Successful() {
        System.out.println("testLoginUser_Successful");
        Login instance = new Login();
        // Register first
        instance.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        // Now try to login
        boolean expResult = true;
        boolean result = instance.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertEquals(result, expResult);
    }

    /**
     * Test: loginUser returns false for incorrect credentials
     */
    @Test
    public void testLoginUser_Failed() {
        System.out.println("testLoginUser_Failed");
        Login instance = new Login();
        // Register first
        instance.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        // Try wrong password
        boolean expResult = false;
        boolean result = instance.loginUser("kyl_1", "wrongpass");
        assertEquals(result, expResult);
    }
}