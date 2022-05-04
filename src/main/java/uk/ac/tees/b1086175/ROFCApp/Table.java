/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp;

import java.io.File;
import javax.swing.ImageIcon;


/**
 *
 * @author b1086175 | Jake Taylor
 */
public class Table extends Item implements java.io.Serializable {
    private TableBase base;
    private int diameter;
    
    private static final File myImage = new File("table2.jpg");

    /** Constructor
     *
     * @param ID
     * @param wood
     * @param quantity
     * @param base
     * @param diameter
     */
    public Table(String ID, WoodType wood, int quantity, TableBase base, int diameter) {
        super(ID, wood, quantity);
        this.base = base;
        this.diameter = diameter;
        
        calculatePrice();
    }
    
    @Override
    protected void calculatePrice() {
        int units = diameter * diameter;
        
        this.itemPrice = (units * wood.getPrice()) + base.getPrice();
    }

    @Override
    public String toString() {
        String result = super.toString();
        
        result += String.format("Table Base: %s\n", this.base.toString());
        result += String.format("Diameter: %d\n", this.diameter);
        
        return result;
    }

    /** Returns the type of base of the table.
     *
     * @return
     */
    public TableBase getBase() {
        return base;
    }

    /** Sets the type of base of the table.
     *
     * @param base
     */
    public void setBase(TableBase base) {
        this.base = base;
        calculatePrice();
    }

    /** Returns the diameter of the table.
     *
     * @return
     */
    public int getDiameter() {
        return diameter;
    }

    /** Sets the diameter of the table.
     *
     * @param diameter
     */
    public void setDiameter(int diameter) {
        this.diameter = diameter;
        calculatePrice();
    }

    @Override
    public File getImage() {
        return myImage;
    }
    
    
}
