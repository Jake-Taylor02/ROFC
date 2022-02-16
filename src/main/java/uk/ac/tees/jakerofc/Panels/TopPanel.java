/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.Panels;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author b1086175
 */
public class TopPanel extends JPanel {
    JButton jbSave;
    JButton jbClear;
    JButton jbLoad;
    JLabel jlFile;

    public TopPanel() {
        // define top buttons and label
        jbSave = new JButton("Save");
        jbClear = new JButton("Clear");
        jbLoad = new JButton("Load");
        jlFile = new JLabel("File:");
        
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Color.LIGHT_GRAY);
        
        //add components to panel
        add(jbSave);
        add(jbClear);
        add(jbLoad);
        add(jlFile);
    }
    
}
