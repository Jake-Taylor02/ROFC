/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp;

/** Represents the type of base used in a table item.
 *
 * @author b1086175 | Jake Taylor
 * @see Table
 */
public enum TableBase implements java.io.Serializable {

    /** Represents a Wooden table along with its price.
     *
     */
    WOODEN(4500),

    /** Represents a Chrome table along with its price.
     *
     */
    CHROME(3500);
    
    private final int price;

    private TableBase(int price) {
        this.price = price;
    }

    /** Returns the price of the table base.
     *
     * @return
     */
    public int getPrice() {
        return price;
    }
    
    
}
