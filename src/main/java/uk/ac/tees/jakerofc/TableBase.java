/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package uk.ac.tees.jakerofc;

/**
 *
 * @author b1086175
 */
public enum TableBase {
    WOODEN(4500),
    CHROME(3500);
    
    private final int price;

    private TableBase(final int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    
    
}
