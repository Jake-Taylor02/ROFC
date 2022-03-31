/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.newitem.panels;

import uk.ac.tees.b1086175.ROFCApp.newitem.panels.ItemPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.Table;
import uk.ac.tees.b1086175.ROFCApp.TableBase;
import uk.ac.tees.b1086175.ROFCApp.WoodType;

/**
 *
 * @author jake
 */
public class TablePanel extends ItemPanel implements ActionListener {
    private JComboBox jcbBase;
    private JSpinner jspDiameter;
    
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
        jspDiameter.setPreferredSize(this.txtSize);
        jspDiameter.addChangeListener(this);
        this.add(jspDiameter);
        spLayout.putConstraint(SpringLayout.WEST, jspDiameter, 5, SpringLayout.EAST, jlDiameter);
        spLayout.putConstraint(SpringLayout.NORTH, jspDiameter, 5, SpringLayout.SOUTH, jcbBase);
    }
    
    public TablePanel(Item table) {
        this();
        
        setItem(table);
    }
    
    @Override
    public void setItem(Item existingTable) {
        super.setItem(existingTable);
        
        Table myTable;
        try {
            myTable = (Table) existingTable;
        } catch (Exception ex) {
            System.out.println("couldn't parse item to table");
            return;
        }
        
        jcbBase.setSelectedItem(myTable.getBase());
        jspDiameter.setValue(myTable.getDiameter());
        this.updateTotal();
    }

    @Override
    protected boolean initialiseItem() {
        // Do actions related to chair
        // refactor with try-catch.
        newItem = new Table(
                this.txtidNum.getText(),// ID Number
                (WoodType) jcbWoodType.getSelectedItem(),// Type of Wood
                (Integer) this.spQuantity.getValue(),// Quantity
                (TableBase) jcbBase.getSelectedItem(),// TableBase
                (Integer) jspDiameter.getValue()// Diameter
        );
        return true;
    }

    @Override
    protected boolean validInputs() {
        if (!super.validInputs()) return false;

        // do i need to validate cbox or jspinner values?
        
        return true; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        if (e.getSource() == jcbBase) {
            ((Table) newItem).setBase((TableBase)jcbBase.getSelectedItem());
        }
        
        updateTotal();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        super.stateChanged(e);
        
        if (e.getSource() == jspDiameter) {
            ((Table) newItem).setDiameter((int) jspDiameter.getValue());
        }
        
        updateTotal();
    }
    
    

    @Override
    public String getTitle() {
        return "Table";
    }
}
