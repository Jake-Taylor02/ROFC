/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.view;

import javax.swing.JPanel;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.newitem.ItemPanel;

/**
 *
 * @author b1086175
 */
public abstract class ItemView {
    protected Item item;

    public ItemView(Item item) {
        this.item = item;
    }
    
    public abstract JPanel getDetailsPanel();
    
    public abstract ItemPanel getEditPanel();

    public Item getItem() {
        return item;
    }
    
    
}
