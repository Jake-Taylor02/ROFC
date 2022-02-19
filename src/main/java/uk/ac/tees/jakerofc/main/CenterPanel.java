/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.main;


import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import uk.ac.tees.jakerofc.*;
import uk.ac.tees.jakerofc.Item;
import uk.ac.tees.jakerofc.Order;

/**
 *
 * @author jake
 */
public class CenterPanel extends JPanel {
    private List<Item> itemArr;
    
    
    JLabel[] labels;

    public CenterPanel(Order g) {
        this.itemArr = g.getItems();
        
        //RefreshGrid();
        init();
    }
    
    private void init(){
        this.setLayout(new GridLayout(3, 3, 5, 5));
        
        labels = new JLabel[9];
        for (int i = 0; i < 9; i++) {
            
            // create the new label
            labels[i] = new JLabel();
            labels[i].setBorder(BorderFactory.createLineBorder(Color.BLUE));
            
            // if the grid actually contains an item, set the image
            if (i < itemArr.size()) {
                labels[i].setIcon(itemArr.get(i).getImage());
            } else {
                labels[i].setIcon(Item.defaultImage());
            }
            this.add(labels[i]);
            
        }
        
        
    }
    
    /*private void RefreshGrid() {
    //this.removeAll();
    
    newGrid = new JPanel();
    newGrid.setLayout(new GridLayout(3, 3, 5, 5));
    
    for (int i = 0; i < 9; i++) {
    
    // create the new label
    JLabel jlNew = new JLabel();
    jlNew.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    
    // if the grid actually contains an item, set the image
    if (i < itemArr.size()) {
    jlNew.setIcon(itemArr.get(i).getImage());
    } else {
    jlNew.setIcon(Item.defaultImage());
    }
    newGrid.add(jlNew);
    
    }
    
    this.add(newGrid);
    this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }*/
    
}
