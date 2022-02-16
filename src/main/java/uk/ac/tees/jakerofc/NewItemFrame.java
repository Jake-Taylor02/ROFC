/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author Jake
 */
public class NewItemFrame extends JFrame {
    protected JTextField txtidNum;
    protected JComboBox jcbWoodType;
    protected JSpinner spQuantity;
    
    SpringLayout spLayout;
    JPanel jpForm;
    
    public NewItemFrame() throws HeadlessException {
        this.setTitle("Add New <item>");// show furniture type?
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        this.setLayout(new BorderLayout());
        
        // Add Superclass components
        JLabel jlIdNum = new JLabel("ID Number:", SwingConstants.RIGHT);
        jlIdNum.setPreferredSize(new Dimension(100, 20));
        
        txtidNum = new JTextField();
        txtidNum.setPreferredSize(new Dimension(120, 20));
        
        JLabel jlWoodType = new JLabel("Type of Wood:", SwingConstants.RIGHT);
        jlWoodType.setPreferredSize(new Dimension(100, 20));
        
        jcbWoodType = new JComboBox(WoodType.values());
        jcbWoodType.setPreferredSize(new Dimension(120, 20));
        
        JLabel jlQuantity = new JLabel("Quantity:", SwingConstants.RIGHT);
        jlQuantity.setPreferredSize(new Dimension(100, 20));
        
        SpinnerNumberModel qModel = new SpinnerNumberModel(
            1,
            1,
            20,
            1
        );
        spQuantity = new JSpinner(qModel);
        spQuantity.setPreferredSize(new Dimension(120, 20));
        
        spLayout = new SpringLayout();
        jpForm = new JPanel();
        jpForm.setLayout(spLayout);
        
        jpForm.add(jlIdNum);
        jpForm.add(txtidNum);
        
        jpForm.add(jlWoodType);
        jpForm.add(jcbWoodType);
        
        jpForm.add(jlQuantity);
        jpForm.add(spQuantity);
        
        
        //Place constraints on components
        spLayout.putConstraint(SpringLayout.WEST, jlIdNum, 5, SpringLayout.WEST, jpForm);
        spLayout.putConstraint(SpringLayout.NORTH, jlIdNum, 5, SpringLayout.NORTH, jpForm);
        spLayout.putConstraint(SpringLayout.WEST, txtidNum, 5, SpringLayout.EAST, jlIdNum);
        spLayout.putConstraint(SpringLayout.NORTH, txtidNum, 5, SpringLayout.NORTH, jpForm);
        
        spLayout.putConstraint(SpringLayout.WEST, jlWoodType, 5, SpringLayout.WEST, jpForm);
        spLayout.putConstraint(SpringLayout.NORTH, jlWoodType, 5, SpringLayout.SOUTH, txtidNum);
        spLayout.putConstraint(SpringLayout.WEST, jcbWoodType, 5, SpringLayout.EAST, jlWoodType);
        spLayout.putConstraint(SpringLayout.NORTH, jcbWoodType, 5, SpringLayout.SOUTH, jlIdNum);
        
        spLayout.putConstraint(SpringLayout.WEST, jlQuantity, 5, SpringLayout.WEST, jpForm);
        spLayout.putConstraint(SpringLayout.NORTH, jlQuantity, 5, SpringLayout.SOUTH, jlWoodType);
        spLayout.putConstraint(SpringLayout.WEST, spQuantity, 5, SpringLayout.EAST, jlQuantity);
        spLayout.putConstraint(SpringLayout.NORTH, spQuantity, 5, SpringLayout.SOUTH, jcbWoodType);
        
        
        // Add Footer buttons - need to add listeners
        JButton jbCancel = new JButton("Cancel");
        JButton jbSave = new JButton("Save");
        
        JPanel jpFooter = new JPanel();
        jpFooter.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        jpFooter.add(jbCancel);
        jpFooter.add(jbSave);
        
        this.add(jpFooter, BorderLayout.SOUTH);
        
        //this.setLayout(new BorderLayout());
        this.add(jpForm, BorderLayout.CENTER);// add in subclass?
        this.setSize(400, 400);
        this.setVisible(true);// should be in subclass
    }
    
}
