/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp;

import java.io.File;
import javax.swing.ImageIcon;


/** Represents a Desk item.
 *
 * @author b1086175 | Jake Taylor
 */
public class Desk extends Item implements java.io.Serializable {

    /** Represents the fixed height of the Desk in Centimetres.
     *
     */
    public static final int HEIGHT = 80;
    
    private int draws;
    private int width, depth;
    
    private static final File myImage = new File("desk2.jpg");

    /** Constructor
     *
     * @param ID
     * @param wood
     * @param quantity
     * @param width
     * @param depth
     * @param draws
     */
    public Desk(String ID, WoodType wood, int quantity, int width, int depth, int draws) {
        super(ID, wood, quantity);
        this.draws = draws;
        this.width = width;
        this.depth = depth;
        
        calculatePrice();
    }
    
    @Override
    protected void calculatePrice() {// is this correct?
        this.itemPrice = (((HEIGHT + width + depth) *12) + (width * depth) * wood.getPrice())
                + (draws * 850);
    }

    @Override
    public String toString() {
        String result = super.toString();
        
        result += String.format("Draws: %d\n", draws);
        result += String.format("Width: %d\n", width);
        result += String.format("Depth: %d\n", depth);
        
        return result;
    }

    /** Returns the number of draws.
     *
     * @return
     */
    public int getDraws() {
        return draws;
    }

    /** Sets the number of draws.
     *
     * @param draws
     */
    public void setDraws(int draws) {
        this.draws = draws;
        calculatePrice();
    }

    /** Returns the width of the desk.
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /** Sets the width of the desk.
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
        calculatePrice();
    }

    /** Returns the depth of the desk.
     *
     * @return
     */
    public int getDepth() {
        return depth;
    }

    /** Sets the depth of the desk.
     *
     * @param depth
     */
    public void setDepth(int depth) {
        this.depth = depth;
        calculatePrice();
    }

    @Override
    public File getImage() {
        return myImage;
    }
    
    
}
