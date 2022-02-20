/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.newitem;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import uk.ac.tees.jakerofc.*;

/**
 *
 * @author jake
 */
public class NewChairFrame extends NewItemFrame {
    private JCheckBox jcbArmrest;
    protected ItemPanel mainPanel;
    
    public NewChairFrame() throws HeadlessException {
        super();
        
        initCenter();
        
        this.setVisible(true);
    }
    
    @Override
    protected void initCenter() {
        class ChairPanel extends ItemPanel implements ActionListener {

            public ChairPanel() {
                super();
                
                jcbArmrest = new JCheckBox("Armrest");
                jcbArmrest.addActionListener(this);
                this.add(jcbArmrest);
                
                spLayout.putConstraint(SpringLayout.WEST, jcbArmrest, 5, SpringLayout.EAST, jlQuantity);
                spLayout.putConstraint(SpringLayout.NORTH, jcbArmrest, 5, SpringLayout.SOUTH, jlQuantity);
                
                
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform Superclass ation
                super.actionPerformed(e);
                
                if (!this.validEntries) return;
                // Do actions related to chair
                WoodType s = (WoodType) jcbWoodType.getSelectedItem();
                
                newItem = new Chair(
                        this.txtidNum.getText(),            // ID Number
                        s,                                  // Type of Wood
                        (Integer)this.spQuantity.getValue(),// Quantity
                        jcbArmrest.isSelected()             // Armrest
                );
                jpFooter.setTotal(newItem.getItemPrice() * newItem.getQuantity());
            }
        }
        mainPanel = new ChairPanel();
        this.add(mainPanel, BorderLayout.CENTER);
        System.out.println("mainPanel");
        
        
        //spLayout.putConstraint(SpringLayout.NORTH, jcbArmrest, 5, SpringLayout.SOUTH, jpForm.);
        
        /*
        spLayout.putConstraint(SpringLayout.WEST, spQuantity, 5, SpringLayout.EAST, jlQuantity);
                spLayout.putConstraint(SpringLayout.NORTH, spQuantity, 5, SpringLayout.SOUTH, jcbWoodType);
        */
    }

}
