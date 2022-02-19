/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    
    protected JPanel jpFooter;
    
    SpringLayout spLayout;
    JPanel jpForm;
    
    public NewItemFrame() throws HeadlessException {
        this.setTitle("Add New <item>");// show furniture type?
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setLayout(new BorderLayout());
        
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
        
        // Set up spring layout and add components
        spLayout = new SpringLayout();
        jpForm = new JPanel();
        jpForm.setLayout(spLayout);
        
        jpForm.add(jlIdNum);
        jpForm.add(txtidNum);
        
        jpForm.add(jlWoodType);
        jpForm.add(jcbWoodType);
        
        jpForm.add(jlQuantity);
        jpForm.add(spQuantity);
        
        
        //Place constraints on ID Number Label and Field
        spLayout.putConstraint(SpringLayout.WEST, jlIdNum, 5, SpringLayout.WEST, jpForm);
        spLayout.putConstraint(SpringLayout.NORTH, jlIdNum, 5, SpringLayout.NORTH, jpForm);
        spLayout.putConstraint(SpringLayout.WEST, txtidNum, 5, SpringLayout.EAST, jlIdNum);
        spLayout.putConstraint(SpringLayout.NORTH, txtidNum, 5, SpringLayout.NORTH, jpForm);
        
        //Place constraints on Wood Type
        spLayout.putConstraint(SpringLayout.WEST, jlWoodType, 5, SpringLayout.WEST, jpForm);
        spLayout.putConstraint(SpringLayout.NORTH, jlWoodType, 5, SpringLayout.SOUTH, txtidNum);
        spLayout.putConstraint(SpringLayout.WEST, jcbWoodType, 5, SpringLayout.EAST, jlWoodType);
        spLayout.putConstraint(SpringLayout.NORTH, jcbWoodType, 5, SpringLayout.SOUTH, jlIdNum);
        
        //Place constraints on Quantity
        spLayout.putConstraint(SpringLayout.WEST, jlQuantity, 5, SpringLayout.WEST, jpForm);
        spLayout.putConstraint(SpringLayout.NORTH, jlQuantity, 5, SpringLayout.SOUTH, jlWoodType);
        spLayout.putConstraint(SpringLayout.WEST, spQuantity, 5, SpringLayout.EAST, jlQuantity);
        spLayout.putConstraint(SpringLayout.NORTH, spQuantity, 5, SpringLayout.SOUTH, jcbWoodType);
        
        
        // Add Footer buttons - need to add listeners
        initFooter();
        
        //this.setLayout(new BorderLayout());
        this.add(jpForm, BorderLayout.CENTER);// add in subclass?
        this.setSize(400, 400);
        this.setVisible(true);// should be in subclass
    }
    
    private void initFooter() {
        class FooterPanel extends JPanel implements ActionListener {
            JButton jbCancel;
            JButton jbSave;

            public FooterPanel() {
                jbCancel = new JButton("Cancel");
                jbCancel.addActionListener(this);
                
                jbSave = new JButton("Save");
                jbSave.addActionListener(this);
                
                this.setLayout(new FlowLayout(FlowLayout.RIGHT));
                
                this.add(jbCancel);
                this.add(jbSave);
                
                
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jbCancel) {
                    System.out.println("Cancel has been pressed");
                } else if (e.getSource() == jbSave) {
                    System.out.println("Save has been pressed");
                } else {
                    System.out.println("Error - Action performed but no source.");
                }
            }
        }
        jpFooter = new FooterPanel();
        this.add(jpFooter, BorderLayout.SOUTH);
    }
    
}
