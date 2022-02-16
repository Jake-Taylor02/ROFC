/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.Panels;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author b1086175
 */
public class LeftPanel extends JPanel{
    JButton jbAddChair;
    JButton jbAddTable;
    JButton jbAddDesk;
    

    public LeftPanel() {
        
        // define left buttons
        jbAddChair = new JButton("Add Chair");
        jbAddChair.setPreferredSize(new Dimension(125, 15));
        jbAddChair.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        jbAddTable = new JButton("Add Table");
        jbAddTable.setPreferredSize(new Dimension(125, 15));
        jbAddTable.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        jbAddDesk = new JButton("Add Desk");
        jbAddDesk.setPreferredSize(new Dimension(125, 15));
        jbAddDesk.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMinimumSize(new Dimension(100, 50));
        
        // add buttons to left panel
        add(jbAddChair);
        add(jbAddTable);
        add(jbAddDesk);
    }
        
    
}
