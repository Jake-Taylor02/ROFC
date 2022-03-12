/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.newitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.SpringLayout;
import uk.ac.tees.b1086175.ROFCApp.*;

/**
 *
 * @author b1086175 | Jake Taylor
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
    
    public ChairPanel(Item chair) {
        this();
        
        setItem(chair);
    }
    
    @Override
    public void setItem(Item existingChair) {
        super.setItem(existingChair);
        
        Chair myChair;
        try {
            myChair = (Chair) existingChair;
        } catch (Exception ex) {
            System.out.println("couldn't parse item to chair");
            return;
        }
        
        jcbArmrest.setSelected(myChair.isArmrests());
        this.actionPerformed(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Perform Superclass action
        super.actionPerformed(e);

        if (!this.validEntries) {
            return;
        }
        // Do actions related to chair
        WoodType s = (WoodType) jcbWoodType.getSelectedItem();// should a catch this?

        newItem = new Chair(
                this.txtidNum.getText(), // ID Number
                s, // Type of Wood
                (Integer) this.spQuantity.getValue(),// Quantity
                jcbArmrest.isSelected() // Armrest
        );
        this.updateTotal();
    }

    @Override
    public String getTitle() {
        return "Chair";
    }
}
