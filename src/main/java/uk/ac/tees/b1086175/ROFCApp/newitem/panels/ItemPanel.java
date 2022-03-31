/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.newitem.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.WoodType;
import uk.ac.tees.b1086175.ROFCApp.newitem.TotalUpdate;

/** 
 *
 * @author b1086175 | Jake Taylor
 */
public abstract class ItemPanel extends JPanel implements ActionListener, ChangeListener {
    protected SpringLayout spLayout;
    protected JTextField txtidNum;
    protected JComboBox jcbWoodType;
    protected JSpinner spQuantity;
    protected JLabel jlQuantity;
    
    protected final Dimension lblSize;
    protected final Dimension txtSize;
    
    
    protected Item newItem;
    
    protected List<TotalUpdate> uListeners = new ArrayList<>();

    public ItemPanel() {
        // Set standard Dimensions of components
        lblSize = new Dimension(100, 20);
        txtSize = new Dimension(120, 20);
        
        // ID Number
        JLabel jlIdNum = new JLabel("ID Number:", SwingConstants.RIGHT);
        jlIdNum.setPreferredSize(lblSize);

        txtidNum = new JTextField();
        txtidNum.setPreferredSize(txtSize);

        // Wood type
        JLabel jlWoodType = new JLabel("Type of Wood:", SwingConstants.RIGHT);
        jlWoodType.setPreferredSize(lblSize);

        jcbWoodType = new JComboBox(WoodType.values());
        jcbWoodType.setPreferredSize(txtSize);

        // Quantity
        
        jlQuantity = new JLabel("Quantity:", SwingConstants.RIGHT);
        jlQuantity.setPreferredSize(lblSize);

        SpinnerNumberModel qModel = new SpinnerNumberModel(
                1,
                1,
                20,
                1
        );
        spQuantity = new JSpinner(qModel);
        spQuantity.setPreferredSize(txtSize);
        
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
    
    public abstract String getTitle();
    
    /** Set a new item and display new field data
     * 
     * @param existingItem 
     */
    public void setItem(Item existingItem) {
        newItem = existingItem;
        
        txtidNum.setText(newItem.getID());
        jcbWoodType.setSelectedItem(newItem.getWood());
        spQuantity.setValue(newItem.getQuantity());
    }
    
    protected boolean validInputs() {
        if (txtidNum.getText().length() <= 2) return false;
        
        // how can i validate wood type?
        
        if ((Integer) spQuantity.getValue() < 1 || (Integer) spQuantity.getValue() > 20) return false;// redundant because spinner restricts input?
        
        if (newItem == null) {
            initialiseItem();
        }
        
        return true;
    }
    
    protected abstract boolean initialiseItem();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!validInputs()) return;
        
        if (e.getSource() == txtidNum) {
            newItem.setID(txtidNum.getText());
        } else if (e.getSource() == jcbWoodType) {
            newItem.setWood((WoodType) jcbWoodType.getSelectedItem()); // possible exception?
        }
        updateTotal();

    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        if (!validInputs()) return;
        
        if (e.getSource() == spQuantity) {
            newItem.setQuantity((int) spQuantity.getValue());
        }
        updateTotal();
    }
    
    public Item getNewItem() {
        return newItem;
    }
    
    public void addTotalUpdate(TotalUpdate e) {
        uListeners.add(e);
    }
    
    protected void updateTotal() {
        if (newItem == null) return;
        
        int data = newItem.getItemPrice() * newItem.getQuantity();
        for (TotalUpdate r : uListeners) {
            r.newTotal(data);
        }
    }
}
