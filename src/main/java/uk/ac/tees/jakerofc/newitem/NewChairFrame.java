/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.newitem;

import java.awt.HeadlessException;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

/**
 *
 * @author jake
 */
public class NewChairFrame extends NewItemFrame {
    JCheckBox jcbArmrest;
    
    public NewChairFrame() throws HeadlessException {
        super();
    }
    
    public void init() {
        //this.jpForm
        
        jcbArmrest = new JCheckBox("Armrest");
        
        jpForm.add(jcbArmrest);
        
        //spLayout.putConstraint(SpringLayout.NORTH, jcbArmrest, 5, SpringLayout.SOUTH, jpForm.);
        
        /*
        spLayout.putConstraint(SpringLayout.WEST, spQuantity, 5, SpringLayout.EAST, jlQuantity);
                spLayout.putConstraint(SpringLayout.NORTH, spQuantity, 5, SpringLayout.SOUTH, jcbWoodType);
        */
    }
}
