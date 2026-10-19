/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package poepart2;

import poepart2.Message;
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
public class MessageNGTest {

    public MessageNGTest() {
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

    // ==================== MESSAGE ID TESTS ====================

    /**
     * Test: Message ID is not more than 10 characters
     */
    @Test
    public void testCheckMessageID_Valid() {
        System.out.println("testCheckMessageID_Valid");
        Message instance = new Message();
        String id = instance.generateMessageID();
        System.out.println("Message ID generated: " + id);
        boolean expResult = true;
        boolean result = instance.checkMessageID(id);
        assertEquals(result, expResult);
    }

    /**
     * Test: Message ID that is too long (11 digits)
     */
    @Test
    public void testCheckMessageID_Invalid() {
        System.out.println("testCheckMessageID_Invalid");
        Message instance = new Message();
        String id = "12345678901"; // 11 digits
        boolean expResult = false;
        boolean result = instance.checkMessageID(id);
        assertEquals(result, expResult);
    }

    // ==================== RECIPIENT CELL TESTS ====================

    /**
     * Test: Recipient cell number is correctly formatted (starts with +)
     */
    @Test
    public void testCheckRecipientCell_Valid() {
        System.out.println("testCheckRecipientCell_Valid");
        Message instance = new Message();
        String cell = "+27718693002";
        String expResult = "Cell phone number successfully captured.";
        String result = instance.checkRecipientCell(cell);
        assertEquals(result, expResult);
    }

    /**
     * Test: Recipient cell number is incorrectly formatted (no +)
     */
    @Test
    public void testCheckRecipientCell_Invalid() {
        System.out.println("testCheckRecipientCell_Invalid");
        Message instance = new Message();
        String cell = "08575975889";
        String expResult = "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        String result = instance.checkRecipientCell(cell);
        assertEquals(result, expResult);
    }

    // ==================== MESSAGE LENGTH TESTS ====================

    /**
     * Test: Message is ready to send (under 250 characters)
     */
    @Test
    public void testMessageLength_Valid() {
        System.out.println("testMessageLength_Valid");
        String message = "Hi Mike, can you join us for dinner tonight?";
        boolean expResult = true;
        // A message under 250 characters should be valid
        boolean result = message.length() <= 250;
        assertEquals(result, expResult);
    }

    /**
     * Test: Message exceeds 250 characters
     */
    @Test
    public void testMessageLength_Invalid() {
        System.out.println("testMessageLength_Invalid");
        // Create a message longer than 250 characters
        String message = "";
        for (int i = 0; i < 260; i++) {
            message = message + "a";
        }
        boolean expResult = false;
        boolean result = message.length() <= 250;
        assertEquals(result, expResult);
    }

    // ==================== MESSAGE HASH TESTS ====================

    /**
     * Test: Message hash is created correctly for the test data
     * Expected: 00:0:HITONIGHT
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("testCreateMessageHash");
        Message instance = new Message();
        String id = "0012345678";
        int num = 0;
        String message = "Hi tonight";
        String expResult = "00:0:HITONIGHT";
        String result = instance.createMessageHash(id, num, message);
        assertEquals(result, expResult);
    }

    // ==================== SEND MESSAGE TESTS ====================

    /**
     * Test: Send Message option returns correct message
     */
    @Test
    public void testSentMessage_Send() {
        System.out.println("testSentMessage_Send");
        Message instance = new Message();
        int choice = 1;
        String expResult = "Message successfully sent.";
        String result = instance.SentMessage(choice);
        assertEquals(result, expResult);
    }

    /**
     * Test: Disregard Message option returns correct message
     */
    @Test
    public void testSentMessage_Disregard() {
        System.out.println("testSentMessage_Disregard");
        Message instance = new Message();
        int choice = 2;
        String expResult = "Press 0 to delete the message.";
        String result = instance.SentMessage(choice);
        assertEquals(result, expResult);
    }

    /**
     * Test: Store Message option returns correct message
     */
    @Test
    public void testSentMessage_Store() {
        System.out.println("testSentMessage_Store");
        Message instance = new Message();
        int choice = 3;
        String expResult = "Message successfully stored.";
        String result = instance.SentMessage(choice);
        assertEquals(result, expResult);
    }

    // ==================== RETURN TOTAL MESSAGES TESTS ====================

    /**
     * Test: returnTotalMessages returns the correct count
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("testReturnTotalMessages");
        Message instance = new Message();
        // Send a message to increment the counter
        instance.SentMessage(1);
        int expResult = Message.totalMessagesSent;
        int result = instance.returnTotalMessages();
        assertEquals(result, expResult);
    }
}