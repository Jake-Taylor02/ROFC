/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp;

/**
 *
 * @author b1086175
 */
public enum TableBase implements java.io.Serializable {
    WOODEN(4500),
    CHROME(3500);
    
    private final int price;

    private TableBase(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    
    
}