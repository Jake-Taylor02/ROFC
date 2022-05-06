/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Test of Chair Class.
 * @author b1086175 | Jake Taylor
 */
public class ChairTest {
    
    public ChairTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of calculatePrice method, of class Chair.
     */
    @org.junit.jupiter.api.Test
    public void testCalculatePrice() {
        System.out.println("calculatePrice");
        Chair instance1 = new Chair("001", WoodType.OAK, 1, true);
        instance1.calculatePrice();
        int result = instance1.itemPrice;
        int expResult = 7500;
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Chair.
     */
    @org.junit.jupiter.api.Test
    public void testGetSummary() {
        System.out.println("getSummary");
        Chair instance = new Chair("001", WoodType.OAK, 1, true);
        String expResult = "Type of Item: Chair\n" +
            "Item ID: 001\n" +
            "Type of Wood: OAK\n" +
            "Item Price: £75.00\n" +
            "Quantity: 1\n" +
            "Total Price: £75.00\n" +
            "Armrests: Yes\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of isArmrests method, of class Chair.
     */
    @org.junit.jupiter.api.Test
    public void testIsArmrests() {
        System.out.println("isArmrests");
        Chair instance = new Chair("001", WoodType.OAK, 1, true);
        boolean expResult = true;
        boolean result = instance.isArmrests();
        assertEquals(expResult, result);
        
        instance = new Chair("001", WoodType.OAK, 1, false);
        expResult = true;
        result = instance.isArmrests();
        assertFalse(expResult == result);
    }

    /**
     * Test of setArmrests method, of class Chair.
     */
    @org.junit.jupiter.api.Test
    public void testSetArmrests() {
        System.out.println("setArmrests");
        boolean armrests = true;
        Chair instance = new Chair("001", WoodType.OAK, 1, false);
        instance.setArmrests(armrests);
        assertEquals(armrests, instance.isArmrests());
    }
    
}
