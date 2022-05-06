/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.view;

import javax.swing.JPanel;
import uk.ac.tees.b1086175.ROFCApp.Chair;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.main.details.ChairDetailsPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.ChairPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.ItemPanel;

/**
 * Provides the components needed to display and edit a Chair.
 * @author b1086175 | Jake Taylor
 */
public class ChairView implements ItemView{

    @Override
    public JPanel getDetailsPanel(Item item) {
        return new ChairDetailsPanel(item);
    }

    @Override
    public ItemPanel getEditPanel(Item item) {
        return new ChairPanel((Chair) item);
    }
    
    /**
     * Returns panel required to create a new chair.
     * @return ChairPanel
     */
    public static ItemPanel getNewItemPanel() {
        return new ChairPanel();
    }
    
}
