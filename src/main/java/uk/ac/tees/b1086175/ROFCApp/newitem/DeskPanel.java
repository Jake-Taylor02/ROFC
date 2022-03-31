/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.newitem;

import uk.ac.tees.b1086175.ROFCApp.newitem.ItemPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import uk.ac.tees.b1086175.ROFCApp.Desk;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.WoodType;

/**
 *
 * @author jake
 */
public class DeskPanel extends ItemPanel implements ActionListener {
    private JSpinner jsDraws, jsWidth, jsDepth;
    
    public DeskPanel() {
        super();

        // Draws Label
        JLabel jlDraws = new JLabel("Draws:", SwingConstants.RIGHT);
        jlDraws.setPreferredSize(this.lblSize);
        this.add(jlDraws);
        spLayout.putConstraint(SpringLayout.WEST, jlDraws, 5, SpringLayout.WEST, this);
        spLayout.putConstraint(SpringLayout.NORTH, jlDraws, 5, SpringLayout.SOUTH, jlQuantity);

        // Draws Spinner
        SpinnerNumberModel drawModel = new SpinnerNumberModel(
                1,// initial
                1,// minimum
                4,// maximum
                1// increment
        );
        jsDraws = new JSpinner(drawModel);
        jsDraws.setPreferredSize(this.txtSize);
        jsDraws.addChangeListener(this);
        this.add(jsDraws);
        spLayout.putConstraint(SpringLayout.WEST, jsDraws, 5, SpringLayout.EAST, jlDraws);
        spLayout.putConstraint(SpringLayout.NORTH, jsDraws, 5, SpringLayout.SOUTH, jlQuantity);

        // Width Label
        JLabel jlWidth = new JLabel("Width:", SwingConstants.RIGHT);
        jlWidth.setPreferredSize(this.lblSize);
        this.add(jlWidth);
        spLayout.putConstraint(SpringLayout.WEST, jlWidth, 5, SpringLayout.WEST, this);
        spLayout.putConstraint(SpringLayout.NORTH, jlWidth, 5, SpringLayout.SOUTH, jsDraws);

        // Width Spinner - setting minimum to 50???
        SpinnerNumberModel widthModel = new SpinnerNumberModel(
                50,// initial
                50,// minimum
                200,// maximum
                1// increment
        );
        jsWidth = new JSpinner(widthModel);
        jsWidth.setPreferredSize(this.txtSize);
        jsWidth.addChangeListener(this);
        this.add(jsWidth);
        spLayout.putConstraint(SpringLayout.WEST, jsWidth, 5, SpringLayout.EAST, jlWidth);
        spLayout.putConstraint(SpringLayout.NORTH, jsWidth, 5, SpringLayout.SOUTH, jsDraws);

        // Depth Label
        JLabel jlDepth = new JLabel("Depth:", SwingConstants.RIGHT);
        jlDepth.setPreferredSize(this.lblSize);
        this.add(jlDepth);
        spLayout.putConstraint(SpringLayout.WEST, jlDepth, 5, SpringLayout.WEST, this);
        spLayout.putConstraint(SpringLayout.NORTH, jlDepth, 5, SpringLayout.SOUTH, jsWidth);

        // Depth Spinner
        // Can re-use width spinner model
        SpinnerNumberModel depthModel = new SpinnerNumberModel(
                50,// initial
                50,// minimum
                200,// maximum
                1// increment
        );
        jsDepth = new JSpinner(depthModel);
        jsDepth.setPreferredSize(this.txtSize);
        jsDepth.addChangeListener(this);
        this.add(jsDepth);
        spLayout.putConstraint(SpringLayout.WEST, jsDepth, 5, SpringLayout.EAST, jlDepth);
        spLayout.putConstraint(SpringLayout.NORTH, jsDepth, 5, SpringLayout.SOUTH, jsWidth);
    }
    
    public DeskPanel(Item desk) {
        this();
        
        setItem(desk);
    }
    
    @Override
    public void setItem(Item existingDesk) {
        super.setItem(existingDesk);
        
        Desk myDesk;
        try {
            myDesk = (Desk) existingDesk;
        } catch (Exception ex) {
            System.out.println("couldn't parse item to desk");
            return;
        }
        
        jsWidth.setValue(myDesk.getWidth());
        jsDepth.setValue(myDesk.getDepth());
        jsDraws.setValue(myDesk.getDraws());
        this.updateTotal();
    }

    @Override
    protected boolean initialiseItem() {
        newItem = new Desk(
                this.txtidNum.getText(),// ID Number
                (WoodType) jcbWoodType.getSelectedItem(),// Type of Wood
                (Integer) this.spQuantity.getValue(),// Quantity
                (Integer) jsWidth.getValue(),// Width
                (Integer) jsDepth.getValue(),// Depth
                (Integer) jsDraws.getValue()// Draws
        );
        return true;
    }

    @Override
    protected boolean validInputs() {
        if (!super.validInputs()) return false;
        
        // do i need to validate jspinners?
        
        return true;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        super.stateChanged(e);
        
        if (e.getSource() == jsDraws) {
            ((Desk) newItem).setDraws((int) jsDraws.getValue());
        } else if (e.getSource() == jsWidth) {
            ((Desk) newItem).setWidth((int) jsWidth.getValue());
        } else if (e.getSource() == jsDepth) {
            ((Desk) newItem).setDepth((int) jsDepth.getValue());
        }
        
        updateTotal();
    }
    
    

    @Override
    public String getTitle() {
        return "Desk";
    }
}
