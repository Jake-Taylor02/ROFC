/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.view;

import javax.swing.JPanel;
import uk.ac.tees.b1086175.ROFCApp.Desk;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.main.details.DeskDetailsPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.panels.ChairPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.panels.DeskPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.panels.ItemPanel;

/**
 *
 * @author b1086175
 */
public class DeskView extends ItemView{

    public DeskView(Item item) {
        super(item);
    }

    @Override
    public JPanel getDetailsPanel() {
        return new DeskDetailsPanel(item);
    }

    @Override
    public ItemPanel getEditPanel() {
        return new DeskPanel((Desk) item);
    }
    
    public static ItemPanel getNewItemPanel() {
        return new DeskPanel();
    }
    
}
