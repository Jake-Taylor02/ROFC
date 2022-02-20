/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import uk.ac.tees.jakerofc.newitem.*;

/**
 *
 * @author b1086175
 */
public class LeftPanel extends JPanel {
    

    public LeftPanel() {
        
        // define Add Chair button
        class ChairButton extends JButton implements ActionListener {

            public ChairButton() {
                this.setText("Add Chair");
                this.setAlignmentX(Component.CENTER_ALIGNMENT);
                
                this.addActionListener(this);
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Chair has been pressed!");
                new NewChairFrame();
            }
            
        }
        ChairButton jbAddChair = new ChairButton();
        
        // Add Table Button
        class TableButton extends JButton implements ActionListener {

            public TableButton() {
                this.setText("Add Table");
                this.setAlignmentX(Component.CENTER_ALIGNMENT);
                
                this.addActionListener(this);
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Table has been pressed!");
            }
            
        }
        TableButton jbAddTable = new TableButton();
        
        // Add Desk Button
        class DeskButton extends JButton implements ActionListener {

            public DeskButton() {
                this.setText("Add Desk");
                this.setAlignmentX(Component.CENTER_ALIGNMENT);
                
                this.addActionListener(this);
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Desk has been pressed!");
            }
            
        }
        DeskButton jbAddDesk = new DeskButton();
        
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        // add buttons to left panel
        add(jbAddChair);
        add(jbAddTable);
        add(jbAddDesk);
    }
}
