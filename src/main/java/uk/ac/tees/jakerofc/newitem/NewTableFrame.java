/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.newitem;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import uk.ac.tees.jakerofc.*;

/**
 *
 * @author jake
 */
public class NewTableFrame extends NewItemFrame{
    private JComboBox jcbBase;
    private JSpinner jspDiameter;
    protected ItemPanel mainPanel;
    
    public NewTableFrame() throws HeadlessException {
        super();
        
        initCenter();
        
        this.setVisible(true);
    }
    
    @Override
    protected void initCenter() {
        class TablePanel extends ItemPanel implements ActionListener {

            public TablePanel() {
                super();
                
                // Table Base Label
                JLabel jlTableBase = new JLabel("Table Base:", SwingConstants.RIGHT);
                jlTableBase.setPreferredSize(this.lblSize);
                this.add(jlTableBase);
                spLayout.putConstraint(SpringLayout.WEST, jlTableBase, 5, SpringLayout.WEST, this);
                spLayout.putConstraint(SpringLayout.NORTH, jlTableBase, 5, SpringLayout.SOUTH, jlQuantity);
                
                // Table Base Combo Box
                jcbBase = new JComboBox(TableBase.values());
                jcbBase.setPreferredSize(this.txtSize);
                jcbBase.addActionListener(this);
                this.add(jcbBase);
                spLayout.putConstraint(SpringLayout.WEST, jcbBase, 5, SpringLayout.EAST, jlTableBase);
                spLayout.putConstraint(SpringLayout.NORTH, jcbBase, 5, SpringLayout.SOUTH, jlQuantity);
                
                // Diameter Label
                JLabel jlDiameter = new JLabel("Diameter:", SwingConstants.RIGHT);
                jlDiameter.setPreferredSize(this.lblSize);
                this.add(jlDiameter);
                spLayout.putConstraint(SpringLayout.WEST, jlDiameter, 5, SpringLayout.WEST, this);
                spLayout.putConstraint(SpringLayout.NORTH, jlDiameter, 5, SpringLayout.SOUTH, jcbBase);
                
                // Diameter Spinner
                SpinnerNumberModel dModel = new SpinnerNumberModel(
                50,// initial
                50,// minimum
                200,// maximum
                1// increment
                );
                jspDiameter = new JSpinner(dModel);
                jspDiameter.addChangeListener(this);
                this.add(jspDiameter);
                spLayout.putConstraint(SpringLayout.WEST, jspDiameter, 5, SpringLayout.EAST, jlDiameter);
                spLayout.putConstraint(SpringLayout.NORTH, jspDiameter, 5, SpringLayout.SOUTH, jcbBase);
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                super.actionPerformed(e);

                if (!this.validEntries) return;
                // Do actions related to chair
                
                newItem = new Table(
                        this.txtidNum.getText(),// ID Number
                        (WoodType) jcbWoodType.getSelectedItem(),// Type of Wood
                        (Integer)this.spQuantity.getValue(),// Quantity
                        (TableBase) jcbBase.getSelectedItem(),// TableBase
                        (Integer)jspDiameter.getValue()// Diameter
                );
                jpFooter.setTotal(newItem.getItemPrice() * newItem.getQuantity());
            }
        }
        mainPanel = new TablePanel();
        this.add(mainPanel, BorderLayout.CENTER);
    }
}
