/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this templates
 */
package uk.ac.tees.b1086175.ROFCApp;

import java.io.File;
import javax.swing.ImageIcon;


/**
 *
 * @author b1086175 | Jake Taylor
 */
public class Chair extends Item implements java.io.Serializable {
    private boolean armrests;
    
    private static ImageIcon myImage = new ImageIcon("chair3.png");;

    public Chair(String ID, WoodType wood, int quantity, boolean armrests) {
        super(ID, wood, quantity);
        this.armrests = armrests;
        
        calculatePrice();
    }
    
    @Override
    protected void calculatePrice(){
        int units = 1625;
        
        if (armrests) units += 250;
        
        this.itemPrice = this.wood.getPrice() * units;
    }
    
    @Override
    public String getSummary() {
        String result = super.getSummary();
        
        result += String.format("%16s %s\n", "Armrests:", armrests ? "Yes" : "No");
        
        return result;
    }
    
    /*@Override
    public String getSummary() {
    
    }*/

    public boolean isArmrests() {
        return armrests;
    }

    public void setArmrests(boolean armrests) {
        this.armrests = armrests;
        calculatePrice();
    }

    @Override
    public ImageIcon getImage() {
        return myImage;
    }
    
    
    
    
    
}
