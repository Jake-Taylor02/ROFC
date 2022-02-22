/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.newitem;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uk.ac.tees.jakerofc.main.ChangeItemListener;
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
            
            private List<ChangeItemListener> changeListeners = new ArrayList<>();

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
                // ! Maybe should move this to parent, Internal Class ?
                if (e.getSource() == jbCancel) {
                    System.out.println("Cancel has been pressed");
                    parent.dispose();// Shut the frame
                } else if (e.getSource() == jbSave) {
                    System.out.println("Save has been pressed");
                    parent.dispose();// Shut the frame
                    
                    for (ChangeItemListener l : changeListeners) {
                        l.newItem(parent.newItem);
                    }
                } else {
                    System.out.println("Error - Action performed but no source.");
                }
            }
        }
