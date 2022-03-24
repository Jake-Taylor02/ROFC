/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.view;

import javax.swing.JPanel;
import uk.ac.tees.b1086175.ROFCApp.Chair;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.main.details.ChairDetailsPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.panels.ChairPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.panels.ItemPanel;

/**
 *
 * @author b1086175
 */
public class ChairView extends ItemView{

    public ChairView(Item item) {
        super(item);
    }

    @Override
    public JPanel getDetailsPanel() {
        return new ChairDetailsPanel(this.item);
    }

    @Override
    public ItemPanel getEditPanel() {
        return new ChairPanel((Chair) item);
    }
    
    public static ItemPanel getNewItemPanel() {
        return new ChairPanel();
    }
    
}
