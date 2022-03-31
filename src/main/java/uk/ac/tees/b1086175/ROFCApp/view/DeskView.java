/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.view;

import javax.swing.JPanel;
import uk.ac.tees.b1086175.ROFCApp.Desk;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.main.details.DeskDetailsPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.DeskPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.ItemPanel;

/**
 *
 * @author b1086175
 */
public class DeskView implements ItemView{

    @Override
    public JPanel getDetailsPanel(Item item) {
        return new DeskDetailsPanel(item);
    }

    @Override
    public ItemPanel getEditPanel(Item item) {
        return new DeskPanel((Desk) item);
    }
    
    public static ItemPanel getNewItemPanel() {
        return new DeskPanel();
    }
    
}
