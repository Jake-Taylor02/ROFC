/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package uk.ac.tees.jakerofc;

/**
 *
 * @author b1086175
 */
public enum WoodType implements java.io.Serializable {
    OAK(4),
    WALNUT(3);
    
    private final int price;

    private WoodType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    
}
