/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.newitem;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import uk.ac.tees.jakerofc.WoodType;

/**
 *
 * @author jake
 */
public class ItemPanel extends JPanel implements ActionListener, ChangeListener {
    protected SpringLayout spLayout;
    protected JTextField txtidNum;
    protected JComboBox jcbWoodType;
    protected JSpinner spQuantity;
    protected JLabel jlQuantity;
    
    protected boolean validEntries;

    public ItemPanel() {
        // ID Number
        JLabel jlIdNum = new JLabel("ID Number:", SwingConstants.RIGHT);
        jlIdNum.setPreferredSize(new Dimension(100, 20));

        txtidNum = new JTextField();
        txtidNum.setPreferredSize(new Dimension(120, 20));

        // Wood type
        JLabel jlWoodType = new JLabel("Type of Wood:", SwingConstants.RIGHT);
        jlWoodType.setPreferredSize(new Dimension(100, 20));

        jcbWoodType = new JComboBox(WoodType.values());
        jcbWoodType.setPreferredSize(new Dimension(120, 20));

        // Quantity
        
        jlQuantity = new JLabel("Quantity:", SwingConstants.RIGHT);
        jlQuantity.setPreferredSize(new Dimension(100, 20));

        SpinnerNumberModel qModel = new SpinnerNumberModel(
                1,
                1,
                20,
                1
        );
        spQuantity = new JSpinner(qModel);
        spQuantity.setPreferredSize(new Dimension(120, 20));
        
        // Apply action listener
        this.txtidNum.addActionListener(this);
        this.jcbWoodType.addActionListener(this);
        this.spQuantity.addChangeListener(this);

        // Set up spring layout and add components
        spLayout = new SpringLayout();
        this.setLayout(spLayout);

        this.add(jlIdNum);
        this.add(txtidNum);

        this.add(jlWoodType);
        this.add(jcbWoodType);

        this.add(jlQuantity);
        this.add(spQuantity);

        //Place constraints on ID Number Label and Field
        spLayout.putConstraint(SpringLayout.WEST, jlIdNum, 5, SpringLayout.WEST, this);
        spLayout.putConstraint(SpringLayout.NORTH, jlIdNum, 5, SpringLayout.NORTH, this);
        spLayout.putConstraint(SpringLayout.WEST, txtidNum, 5, SpringLayout.EAST, jlIdNum);
        spLayout.putConstraint(SpringLayout.NORTH, txtidNum, 5, SpringLayout.NORTH, this);

        //Place constraints on Wood Type
        spLayout.putConstraint(SpringLayout.WEST, jlWoodType, 5, SpringLayout.WEST, this);
        spLayout.putConstraint(SpringLayout.NORTH, jlWoodType, 5, SpringLayout.SOUTH, txtidNum);
        spLayout.putConstraint(SpringLayout.WEST, jcbWoodType, 5, SpringLayout.EAST, jlWoodType);
        spLayout.putConstraint(SpringLayout.NORTH, jcbWoodType, 5, SpringLayout.SOUTH, jlIdNum);

        //Place constraints on Quantity
        spLayout.putConstraint(SpringLayout.WEST, jlQuantity, 5, SpringLayout.WEST, this);
        spLayout.putConstraint(SpringLayout.NORTH, jlQuantity, 5, SpringLayout.SOUTH, jlWoodType);
        spLayout.putConstraint(SpringLayout.WEST, spQuantity, 5, SpringLayout.EAST, jlQuantity);
        spLayout.putConstraint(SpringLayout.NORTH, spQuantity, 5, SpringLayout.SOUTH, jcbWoodType);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validEntries = true;
        // Check all fields have valid inputs
        
        if (txtidNum.getText().length() <= 2) {
            validEntries = false;
            return;
        }
        
        // how can i validate wood type?
        
        if ((Integer) spQuantity.getValue() < 1 || (Integer) spQuantity.getValue() > 20) {
            validEntries = false;
            return;
        }
        
        
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        actionPerformed(null);
    }

}
