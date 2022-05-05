/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.newitem;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.WoodType;

/** Provides the necessary input fields for an Item.
 *
 * @author b1086175 | Jake Taylor
 */
public abstract class ItemPanel extends JPanel implements ActionListener, ChangeListener {

    /**
     * Layout to arrange the components.
     */
    protected SpringLayout spLayout;

    /**
     * Text Field for the user to input the ID Number.
     */
    protected JTextField txtidNum;

    /**
     * Drop-down to select the Type of Wood.
     */
    protected JComboBox jcbWoodType;

    /**
     * Spinner to select the quantity.
     */
    protected JSpinner spQuantity;

    /**
     * Label indicating the quality field.
     */
    protected JLabel jlQuantity;
    
    /**
     * Default size of all JLabels.
     */
    protected final Dimension lblSize;

    /**
     * Default size of input fields.
     */
    protected final Dimension fieldSize;
    
    /**
     * The item created from the user input.
     */
    protected Item newItem;
    
    /**
     * Subscribers to be notified when the total changes.
     */
    protected List<TotalUpdate> uListeners = new ArrayList<>();

    /**
     * Constructor.
     */
    public ItemPanel() {
        // Set standard Dimensions of components
        lblSize = new Dimension(100, 20);
        fieldSize = new Dimension(120, 20);
        
        init();
    }
    
    private void init() {

        // ID Number
        JLabel jlIdNum = new JLabel("ID Number:", SwingConstants.RIGHT);
        jlIdNum.setPreferredSize(lblSize);

        txtidNum = new JTextField();
        txtidNum.setPreferredSize(fieldSize);

        // Wood type
        JLabel jlWoodType = new JLabel("Type of Wood:", SwingConstants.RIGHT);
        jlWoodType.setPreferredSize(lblSize);

        jcbWoodType = new JComboBox(WoodType.values());
        jcbWoodType.setPreferredSize(fieldSize);

        // Quantity
        jlQuantity = new JLabel("Quantity:", SwingConstants.RIGHT);
        jlQuantity.setPreferredSize(lblSize);

        SpinnerNumberModel qModel = new SpinnerNumberModel(
                1,
                1,
                100,
                1
        );
        spQuantity = new JSpinner(qModel);
        spQuantity.setPreferredSize(fieldSize);

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
    
    /** Returns the title of the panel.
     * This is based on the item type and if it is a new or existing item.
     * @return Title
     */
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
    
    /** Returns if the input fields contain valid data
     *
     * @return
     */
    protected boolean validInputs() {
        if (txtidNum.getText().length() <= 2) return false;
        
        if (newItem == null) {
            initialiseItem();
        }
        
        return true;
    }
    
    /** Initialises the item.
     *
     * @return
     */
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
    
    /**
     * Returns the new item.
     * @return Item
     */
    public Item getNewItem() {
        return newItem;
    }
    
    /**
     * Adds a subscriber to be notified when the total changes.
     * @param e
     */
    public void addTotalUpdate(TotalUpdate e) {
        uListeners.add(e);
    }
    
    /**
     * Notify subscribers of the total changing.
     */
    protected void updateTotal() {
        if (newItem == null) return;
        
        int data = newItem.getItemPrice() * newItem.getQuantity();
        for (TotalUpdate r : uListeners) {
            r.newTotal(data);
        }
    }
}
