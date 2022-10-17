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
 * Unit test of Desk class.
 * @author b1086175 | Jake Taylor
 */
public class DeskTest {
    
    public DeskTest() {
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
     * Test of calculatePrice method, of class Desk.
     */
    @Test
    public void testCalculatePrice() {
        System.out.println("calculatePrice");
        Desk instance = new Desk("DE001", WoodType.WALNUT, 1, 100, 75, 3);
        instance.calculatePrice();
        int expResult = 28110;
        assertEquals(expResult, instance.getItemPrice());
    }

    /**
     * Test of toString method, of class Desk.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Desk instance = new Desk("DE001", WoodType.WALNUT, 1, 100, 75, 3);
        String expResult = "Type of Item: Desk\n" +
            "Item ID: DE001\n" +
            "Type of Wood: WALNUT\n" +
            "Item Price: £281.10\n" +
            "Quantity: 1\n" +
            "Total Price: £281.10\n" +
            "Draws: 3\n" +
            "Width: 100\n" +
            "Depth: 75\n" +
            "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDraws method, of class Desk.
     */
    @Test
    public void testGetDraws() {
        System.out.println("getDraws");
        Desk instance = new Desk("DE001", WoodType.WALNUT, 1, 100, 75, 3);
        int expResult = 3;
        int result = instance.getDraws();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDraws method, of class Desk.
     */
    @Test
    public void testSetDraws() {
        System.out.println("setDraws");
        int draws = 0;
        Desk instance = new Desk("DE001", WoodType.WALNUT, 1, 100, 75, 3);
        instance.setDraws(draws);
        
        assertEquals(draws, instance.getDraws());
    }

    /**
     * Test of getWidth method, of class Desk.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Desk instance = new Desk("DE001", WoodType.WALNUT, 1, 100, 75, 3);
        int expResult = 100;
        int result = instance.getWidth();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWidth method, of class Desk.
     */
    @Test
    public void testSetWidth() {
        System.out.println("setWidth");
        int width = 150;
        Desk instance = new Desk("DE001", WoodType.WALNUT, 1, 100, 75, 3);
        instance.setWidth(width);
        
        assertEquals(width, instance.getWidth());
    }

    /**
     * Test of getDepth method, of class Desk.
     */
    @Test
    public void testGetDepth() {
        System.out.println("getDepth");
        Desk instance = new Desk("DE001", WoodType.WALNUT, 1, 100, 75, 3);
        int expResult = 75;
        int result = instance.getDepth();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDepth method, of class Desk.
     */
    @Test
    public void testSetDepth() {
        System.out.println("setDepth");
        int depth = 98;
        Desk instance = new Desk("DE001", WoodType.WALNUT, 1, 100, 75, 3);
        instance.setDepth(depth);
        
        assertEquals(depth, instance.getDepth());
    }

    
}
