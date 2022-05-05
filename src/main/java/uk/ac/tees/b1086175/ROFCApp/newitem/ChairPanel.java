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

/** Provides the necessary input fields for an Item.
 *
 * @author b1086175 | Jake Taylor
 */
public class ChairPanel extends ItemPanel implements ActionListener {
    private JCheckBox jcbArmrest;
    
    /**
     * Constructor used when Adding a new Chair.
     */
    public ChairPanel() {
        super();

        init();
    }
    
    /**
     * Constructor used when editing an existing Chair.
     * @param chair The Chair to be edited
     */
    public ChairPanel(Item chair) {
        this();
        
        setItem(chair);
    }
    
    private void init() {
        jcbArmrest = new JCheckBox("Armrest");
        jcbArmrest.addActionListener(this);
        this.add(jcbArmrest);

        spLayout.putConstraint(SpringLayout.WEST, jcbArmrest, 5, SpringLayout.EAST, jlQuantity);
        spLayout.putConstraint(SpringLayout.NORTH, jcbArmrest, 5, SpringLayout.SOUTH, jlQuantity);
    }
    
    @Override
    public void setItem(Item existingChair) {
        super.setItem(existingChair);
        
        Chair myChair;
        try {
            myChair = (Chair) existingChair;
        } catch (ClassCastException ex) {
            System.out.println("couldn't parse item to chair");
            return;
        }
        
        jcbArmrest.setSelected(myChair.isArmrests());
        this.updateTotal();
    }

    @Override
    protected boolean initialiseItem() {
        // refactor into try-catch
        newItem = new Chair(
                this.txtidNum.getText(), // ID Number
                (WoodType) jcbWoodType.getSelectedItem(), // Type of Wood | 
                (Integer) this.spQuantity.getValue(),// Quantity
                jcbArmrest.isSelected() // Armrest
        );
        
        Order.getInstance().myViews.add(newItem);
        return true;
    }

    @Override
    protected boolean validInputs() {
        if (!super.validInputs()) return false;
        
        
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        if (e.getSource() == jcbArmrest) {
            ((Chair)newItem).setArmrests(jcbArmrest.isSelected());
        }
        
        updateTotal();
    }

    @Override
    public String getTitle() {
        return "Chair";
    }
}
