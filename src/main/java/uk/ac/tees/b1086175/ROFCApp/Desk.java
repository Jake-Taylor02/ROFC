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
public class Desk extends Item implements java.io.Serializable {
    public static final int HEIGHT = 80;
    private int draws;
    private int width, depth;

    public Desk(String ID, WoodType wood, int quantity, int width, int depth, int draws) {
        super(ID, wood, quantity);
        this.draws = draws;
        this.width = width;
        this.depth = depth;
        
        calculatePrice();
    }
    
    @Override
    protected void calculatePrice() {
        this.itemPrice = (((HEIGHT * width * depth) *12) + (width * depth)) * wood.getPrice()
                + (draws * 850);
        
        int hwd = (HEIGHT * width * depth) *12;
        System.out.println("hwd: " + hwd);
        
        int wd = width * depth;
        System.out.println("wd: " + wd);
        
        int timeswood = (hwd + wd) * wood.getPrice();
        System.out.println("wood: " + wood.getPrice());
        System.out.println("* wood: " + timeswood);
        
        int drw = draws * 850;
        System.out.println("draw cost: " + drw);
        
        int total = timeswood + drw;
        System.out.println("total: " + total);
    }
    
    @Override
    protected void setImage() {
        image = new ImageIcon("desk2.jpg");
    }

    /*@Override
    public String getSummary() {
    return "";
    }*/

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
        calculatePrice();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        calculatePrice();
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
        calculatePrice();
    }
    
    
}
