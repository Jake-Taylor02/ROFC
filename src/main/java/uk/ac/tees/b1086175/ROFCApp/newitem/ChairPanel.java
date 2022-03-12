/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.newitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.SpringLayout;
import uk.ac.tees.b1086175.ROFCApp.Chair;
import uk.ac.tees.b1086175.ROFCApp.WoodType;

/**
 *
 * @author jake
 */
public class ChairPanel extends ItemPanel implements ActionListener {
    private JCheckBox jcbArmrest;
    
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

        if (!this.validEntries) {
            return;
        }
        // Do actions related to chair
        WoodType s = (WoodType) jcbWoodType.getSelectedItem();

        newItem = new Chair(
                this.txtidNum.getText(), // ID Number
                s, // Type of Wood
                (Integer) this.spQuantity.getValue(),// Quantity
                jcbArmrest.isSelected() // Armrest
        );
        this.upttotal();
    }

    @Override
    public String getTitle() {
        return "Chair";
    }
}
