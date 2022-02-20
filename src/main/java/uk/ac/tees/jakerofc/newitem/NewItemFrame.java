/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.newitem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uk.ac.tees.jakerofc.Item;

/**
 * change center panel to
 * @author Jake
 */
public abstract class NewItemFrame extends JFrame {
    
    //protected ItemPanel jpForm;
    protected FooterPanel jpFooter;
    protected Item newItem;
    
    public NewItemFrame() throws HeadlessException {
        this.setTitle("Add New Item");// to be overwritten by subclass
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
    
        // Center Panel with components
        //initCenter();
        
        // Add Footer buttons
        initFooter();
        
        this.setSize(400, 400);
        this.setVisible(true);// should be in subclass
    }
    
    protected abstract void initCenter();
        //jpForm = new ItemPanel();
        //this.add(jpForm, BorderLayout.CENTER);
    
    
    private void initFooter() {
        jpFooter = new FooterPanel(this);
        this.add(jpFooter, BorderLayout.SOUTH);
    }
    
}
