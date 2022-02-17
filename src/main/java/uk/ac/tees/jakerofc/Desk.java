/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc;

import java.io.File;
import javax.swing.ImageIcon;


/**
 *
 * @author b1086175
 */
public class Desk extends Item{
    private int draws;
    private int width, depth;

    public Desk(String ID, WoodType wood, int quantity, int width, int depth, int draws) {
        super(ID, wood, quantity);
        this.draws = draws;
        this.width = width;
        this.depth = depth;
    }
    
    @Override
    protected void calculatePrice() {
        this.itemPrice = ((80 * width * depth) *12) + (width * depth) * wood.getPrice()
                + (draws * 850);
    }
    
    @Override
    protected void setImage() {
        image = new ImageIcon("desk2.jpg");
    }

    @Override
    public void newItem() {
        new NewItemFrame();
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
