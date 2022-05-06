/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.view;

import javax.swing.JPanel;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.newitem.ItemPanel;

/** Interface to provide correct components based on item type.
 *
 * @author b1086175 | Jake Taylor
 */
public abstract interface ItemView {
    
    /**
     * Returns panel displaying details of an item.
     * @param item
     * @return JPanel
     */
    public JPanel getDetailsPanel(Item item);
    
    /**
     * Returns ItemPanel based on item type.
     * @param item
     * @return ItemPAnel
     */
    public abstract ItemPanel getEditPanel(Item item);
}
