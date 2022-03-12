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
    protected WoodType wood;
    protected int itemPrice;
    private int quantity;
    protected ImageIcon image;

    public Item(String ID, WoodType wood, int quantity) {
        this.ID = ID;
        this.wood = wood;
        this.quantity = quantity;
        
        setImage();
    }
    
    
    protected abstract void calculatePrice();
    
    protected abstract void setImage();
    
    public static ImageIcon defaultImage() {
        return new ImageIcon("no_image2.jpg");
    }
    
    public ImageIcon getImage() {
        return image;
    }
    
    public String getSummary() {
        String result = String.format("ID: %s\n", this.ID);
        
        result += String.format("\tType of Item: %s\n", this.getClass().getSimpleName());
        result += String.format("\tItem Price: £%.2f\n", (double)this.itemPrice / 100);
        result += "\n";
        
        return result;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public WoodType getWood() {
        return wood;
    }

    public void setWood(WoodType wood) {
        this.wood = wood;
        calculatePrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemPrice() {
        return itemPrice;
    }
    
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