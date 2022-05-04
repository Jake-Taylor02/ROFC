/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this templates
 */
package uk.ac.tees.b1086175.ROFCApp;

import java.io.File;


/** Represents a Chair item
 *
 * @author b1086175 | Jake Taylor
 */
public class Chair extends Item implements java.io.Serializable {
    private boolean armrests;
    
    private static final File myImage = new File("chair3.png");

    /** Constructor requiring ID Number, Type of Wood, Quantity and Armrests.
     *
     * @param ID
     * @param wood
     * @param quantity
     * @param armrests
     */
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
    public String toString() {
        String result = super.toString();
        
        result += String.format("Armrests: %s\n", armrests ? "Yes" : "No");
        
        return result;
    }

    /** Returns if the chair has armrests.
     *
     * @return
     */
    public boolean isArmrests() {
        return armrests;
    }

    /** Sets the armrests.
     *
     * @param armrests
     */
    public void setArmrests(boolean armrests) {
        this.armrests = armrests;
        calculatePrice();
    }

    @Override
    public File getImage() {
        return myImage;
    }
    
    
    
    
    
}
