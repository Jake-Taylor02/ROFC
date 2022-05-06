/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp;

import java.io.File;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Test of Table Class.
 * @author b1086175 | Jake Taylor
 */
public class TableTest {
    
    public TableTest() {
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
     * Test of calculatePrice method, of class Table.
     */
    @Test
    public void testCalculatePrice() {
        System.out.println("calculatePrice");
        Table instance = new Table("002", WoodType.WALNUT, 2, TableBase.CHROME, 100);
        instance.calculatePrice();
        int expResult = 335_00;
        int result = instance.getItemPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Table.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Table instance = new Table("002", WoodType.WALNUT, 2, TableBase.CHROME, 100);
        String expResult = "Type of Item: Table\n" +
                "Item ID: 002\n" +
                "Type of Wood: WALNUT\n" +
                "Item Price: £335.00\n" +
                "Quantity: 2\n" +
                "Total Price: £670.00\n" +
                "Table Base: CHROME\n" +
                "Diameter: 100\n" +
                "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBase method, of class Table.
     */
    @Test
    public void testGetBase() {
        System.out.println("getBase");
        Table instance = new Table("002", WoodType.WALNUT, 2, TableBase.CHROME, 100);
        TableBase expResult = TableBase.CHROME;
        TableBase result = instance.getBase();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBase method, of class Table.
     */
    @Test
    public void testSetBase() {
        System.out.println("setBase");
        TableBase base = TableBase.WOODEN;
        Table instance = new Table("002", WoodType.WALNUT, 2, TableBase.CHROME, 100);
        instance.setBase(base);
        assertEquals(base, instance.getBase());
    }

    /**
     * Test of getDiameter method, of class Table.
     */
    @Test
    public void testGetDiameter() {
        System.out.println("getDiameter");
        Table instance = new Table("002", WoodType.WALNUT, 2, TableBase.CHROME, 100);
        int expResult = 100;
        int result = instance.getDiameter();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDiameter method, of class Table.
     */
    @Test
    public void testSetDiameter() {
        System.out.println("setDiameter");
        int diameter = 130;
        Table instance = new Table("002", WoodType.WALNUT, 2, TableBase.CHROME, 100);
        instance.setDiameter(diameter);
        assertEquals(diameter, instance.getDiameter());
    }

    /**
     * Test of getImage method, of class Table.
     */
    @Test
    public void testGetImage() {
        System.out.println("getImage");
        Table instance = new Table("002", WoodType.WALNUT, 2, TableBase.CHROME, 100);
        File expResult = new File("table2.jpg");
        File result = instance.getImage();
        assertEquals(expResult, result);
    }
    
}
