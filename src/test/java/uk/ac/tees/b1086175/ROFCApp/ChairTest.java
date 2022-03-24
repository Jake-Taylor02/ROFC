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
 *
 * @author b1086175
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
        Chair instance = new Chair("001", WoodType.OAK, 1, true);
        instance.calculatePrice();
        int result = instance.itemPrice;
        int expResult = 7500;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getSummary method, of class Chair.
     */
    @org.junit.jupiter.api.Test
    public void testGetSummary() {
        System.out.println("getSummary");
        Chair instance = null;
        String expResult = "";
        String result = instance.getSummary();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isArmrests method, of class Chair.
     */
    @org.junit.jupiter.api.Test
    public void testIsArmrests() {
        System.out.println("isArmrests");
        Chair instance = null;
        boolean expResult = false;
        boolean result = instance.isArmrests();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArmrests method, of class Chair.
     */
    @org.junit.jupiter.api.Test
    public void testSetArmrests() {
        System.out.println("setArmrests");
        boolean armrests = false;
        Chair instance = null;
        instance.setArmrests(armrests);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
