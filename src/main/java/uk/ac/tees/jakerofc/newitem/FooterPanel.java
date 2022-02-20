/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.newitem;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uk.ac.tees.jakerofc.main.ROFCapp;

/**
 *
 * @author jake
 */
public class FooterPanel extends JPanel implements ActionListener {
            private JLabel jlTotal;
            private JButton jbCancel;
            private JButton jbSave;
            
            private NewItemFrame parent;

            public FooterPanel(NewItemFrame parent) {
                this.parent = parent;
                jlTotal = new JLabel("Total: ");
                
                
                jbCancel = new JButton("Cancel");
                jbCancel.addActionListener(this);
                
                jbSave = new JButton("Save");
                jbSave.addActionListener(this);
                
                this.setLayout(new FlowLayout(FlowLayout.RIGHT));
                
                this.add(jlTotal);
                this.add(jbCancel);
                this.add(jbSave);
            }
            
            public void setTotal(int value) {
                jlTotal.setText(String.format("Total: £%.2f", (double) value /100));
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jbCancel) {
                    System.out.println("Cancel has been pressed");
                    parent.dispose();
                } else if (e.getSource() == jbSave) {
                    System.out.println("Save has been pressed");
                    ROFCapp.itemArr.addItem(parent.newItem);
                    parent.dispose();
                } else {
                    System.out.println("Error - Action performed but no source.");
                }
            }
        }
