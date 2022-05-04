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
public abstract class Item implements java.io.Serializable {
    private String ID;

    /**
     * Type of Wood used in the Item's manufacture
     */
    protected WoodType wood;

    /**
     * The price of the Item, Disregarding the quantity
     */
    protected int itemPrice;
    private int quantity;

    /**
     * Constructor using Item ID, Type of Wood, and Quantity
     * @param ID
     * @param wood
     * @param quantity
     */
    public Item(String ID, WoodType wood, int quantity) {
        this.ID = ID;
        this.wood = wood;
        this.quantity = quantity;
        
    }
    
    /**
     * Sets itemPrice to the correct price based on the item type and attributes.
     */
    protected abstract void calculatePrice();
    
    /** Returns the image file to represent a type of item.
     *
     * @return image file
     */
    public abstract File getImage();
    
    /** Returns a String indicating the state of the object.
     *
     * @return
     */
    @Override
    public String toString() {
        String result = String.format("Type of Item: %s\n", this.getClass().getSimpleName());
        
        result += String.format("Item ID: %s\n", this.ID);
        result += String.format("Type of Wood: %s\n", this.wood.toString());
        result += String.format("Item Price: £%.2f\n", (double)this.itemPrice / 100);
        result += String.format("Quantity: %d\n", this.quantity);
        result += String.format("Total Price: £%.2f\n", (double)this.getTotalPrice() / 100);
        
        return result;
    }

    /** Returns the ID Number of the Item.
     *
     * @return ID Number
     */
    public String getID() {
        return ID;
    }

    /** Sets the ID Number of the Item.
     *
     * @param ID the new ID Number.
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /** Returns the Type of Wood of the Item.
     *
     * @return the Type of Wood
     */
    public WoodType getWood() {
        return wood;
    }

    /** Sets the Type of Wood of the Item.
     *
     * @param wood the new Type of Wood
     */
    public void setWood(WoodType wood) {
        this.wood = wood;
        calculatePrice();
    }

    /** Returns the Quantity of the Item.
     *
     * @return Quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /** Sets the Quantity of the Item.
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public int getItemPrice() {
        return itemPrice;
    }
    
    /**
     *
     * @return
     */
    public int getTotalPrice() {
        return itemPrice * quantity;
    }
    
}
