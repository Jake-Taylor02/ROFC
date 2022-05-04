/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp;

/** Represents the type of wood used in an item.
 *
 * @author b1086175 | Jake Taylor
 * @see Item
 */
public enum WoodType implements java.io.Serializable {

    /** Represents Oak material and its price.
     *
     */
    OAK(4),

    /** Represents Walnut material and its price.
     *
     */
    WALNUT(3);
    
    private final int price;

    private WoodType(int price) {
        this.price = price;
    }

    /** Returns the price per unit of the material.
     *
     * @return
     */
    public int getPrice() {
        return price;
    }
    
}
