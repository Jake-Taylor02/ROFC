/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc;

import java.io.File;
import javax.swing.ImageIcon;


/**
 *
 * @author b1086175
 */
public class Table extends Item{
    private TableBase base;
    private int diameter;

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
    protected void setImage() {
        image = new ImageIcon("table2.jpg");
    }

    /*@Override
    public String getSummary() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public TableBase getBase() {
        return base;
    }

    public void setBase(TableBase base) {
        this.base = base;
        calculatePrice();
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
        calculatePrice();
    }
    
    
}
