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
public abstract class Item implements java.io.Serializable, java.util.Comparator {
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
     * Sets itemPrice to the correct price based on the item type and attributes
     */
    protected abstract void calculatePrice();
    
    /**
     *
     * @return
     */
    public abstract File getImage();
    
    /**
     *
     * @return
     */
    public String getSummary() {
        String result = String.format("%16s %s\n", "Type of Item:", this.getClass().getSimpleName());
        
        result += String.format("%16s %s\n", "ID:", this.ID);
        result += String.format("%16s £%.2f\n", "Item Price:", (double)this.itemPrice / 100);
        result += String.format("%16s %d\n", "Quantity:", this.quantity);
        result += String.format("%16s £%.2f\n", "Total Price:", (double)this.getTotalPrice() / 100);
        
        return result;
    }

    /**
     *
     * @return
     */
    public String getID() {
        return ID;
    }

    /**
     *
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     *
     * @return
     */
    public WoodType getWood() {
        return wood;
    }

    /**
     *
     * @param wood
     */
    public void setWood(WoodType wood) {
        this.wood = wood;
        calculatePrice();
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
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

    @Override
    public int compare(Object o1, Object o2) {
        Item a = (Item) o1;
        Item b = (Item) o2;
        if (a.itemPrice < b.itemPrice) return -1;
        
        if (a.itemPrice == b.itemPrice) return 0;
        
        return 1;
    }
    
}
