/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.Panels;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import uk.ac.tees.jakerofc.ROFCapp;

/**
 *
 * @author jake
 */
public class BottomPanel extends Box implements ActionListener {
    JButton jlTotal;
    JButton jbSummary;
    
    public BottomPanel() {
        super(BoxLayout.X_AXIS);
        
        jlTotal = new JButton("Total");
        jlTotal.addActionListener(this);
        
        jbSummary = new JButton("Show Summary");
        jbSummary.addActionListener(this);
        
        this.add(jlTotal);
        this.add(Box.createHorizontalGlue());
        this.add(jbSummary);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jlTotal) {
            JOptionPane.showMessageDialog(this, String.format("Total: £%.2f",
                    (double) ROFCapp.itemArr.calcTotal() / 100));
            
        } else if (e.getSource() == jbSummary) {
            JOptionPane.showMessageDialog(this, ROFCapp.itemArr.orderSummary());
            System.out.println(ROFCapp.itemArr.orderSummary());
        }
    }
    
}
