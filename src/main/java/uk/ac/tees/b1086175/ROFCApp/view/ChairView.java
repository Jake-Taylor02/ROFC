/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.main.details.ChairDetailsPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.EditItemFrame;
import uk.ac.tees.b1086175.ROFCApp.newitem.NewItemFrame;
import uk.ac.tees.b1086175.ROFCApp.newitem.panels.ChairPanel;

/**
 *
 * @author jake
 */
public class ChairView extends ItemView{

    public ChairView(Item item) {
        super(item);
    }
    
    @Override
    public JPanel getDetailsPanel() {
        return new ChairDetailsPanel(item);
    }

    @Override
    public EditItemFrame getEditItemPanel() {
        return new EditItemFrame(new ChairPanel(item), item);
    }
    
    public static NewItemFrame getNewChairFrame() {
        return new NewItemFrame(new ChairPanel());
    }
    
}
