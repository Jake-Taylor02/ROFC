/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import uk.ac.tees.b1086175.ROFCApp.Order;

/**
 *
 * @author b1086175
 */
public class TopPanel extends JPanel implements ActionListener {
    private ChangeItemListener cListener;
    JButton jbSave;
    JButton jbClear;
    JButton jbLoad;
    JLabel jlFile;

    public TopPanel() {
        init();
    }

    // Constructor with ChangeItemListener??
    
    private void init() {
         // define top buttons and label
        jbSave = new JButton("Save");
        jbClear = new JButton("Clear");
        jbLoad = new JButton("Load");
        jlFile = new JLabel("File:");
        
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Color.LIGHT_GRAY);
        
        jbSave.addActionListener(this);
        jbClear.addActionListener(this);
        jbLoad.addActionListener(this);
        
        //add components to panel
        add(jbSave);
        add(jbClear);
        add(jbLoad);
        add(jlFile);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Order myOrder = Order.getInstance();
        
        if (e.getSource() == jbClear) {
            //clear order List
            myOrder.clear();
            
            //update grid
            cListener.updateGrid();
            
            jlFile.setText("File:");
        }
        
        JFileChooser jfc = new JFileChooser();
        if (e.getSource() == jbSave) {
            int result = jfc.showSaveDialog(this);
            
            if (result != JFileChooser.APPROVE_OPTION) return;
            
            myOrder.save(jfc.getSelectedFile());
            
            jlFile.setText("File:" + myOrder.getPath().getPath());
        } else if (e.getSource() == jbLoad) {
            int saveResult = jfc.showOpenDialog(this);
            
            if (saveResult != JFileChooser.APPROVE_OPTION) return;
            
            boolean result = myOrder.load(jfc.getSelectedFile());
            
            if (!result) {
                JOptionPane.showMessageDialog(this, "Order could not be loaded, File may be invalid.");
            }
            
            jlFile.setText("File:" + myOrder.getPath().getPath());
            
            cListener.updateGrid();
        }
    }
    
    public void setChangeItemListener(ChangeItemListener cil) {
        cListener = cil;
    }
    
    
    
}
