/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.main;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
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

    public CenterPanel() {
        this.itemArr = new ArrayList<>();
        
        init();
    }
    
    public CenterPanel(Order g) {
        this.itemArr = g.getItems();
        
        init();
    }
    
    private void init(){
        this.removeAll();
        /*this.setLayout(new GridLayout(3, 3, 5, 5));
        
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
        this.updateUI();*/
        
        this.setLayout(new GridBagLayout());
        int x = 0, y = 0;
        for (Item it : itemArr) {
            GridBagConstraints gbPos = new GridBagConstraints();
            gbPos.gridx = x;
            gbPos.gridy = y;
            
            JLabel jlnew = new JLabel();
            jlnew.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            jlnew.setIcon(it.getImage());
            this.add(jlnew, gbPos);
            
            
            x++;
            if (x >= 3) {
                x = 0;
                y++;
            }
            
        }
    }
    
    private void init2() {
        
    }
    
    public void updateItems() {
        System.out.println("update grid triggered");
        init();
    }
    
}
