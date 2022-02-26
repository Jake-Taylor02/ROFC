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
public class CenterPanel extends JPanel implements ChangeItemListener {
    private Order itemArr;
    
    
    ItemDisplay[] iPanels;

    public CenterPanel(Order myOrder) {
        this.itemArr = myOrder;
        
        init();
    }
    
    private void init(){
        this.removeAll();
        this.setLayout(new GridLayout(3, 3, 5, 5));
        
        iPanels = new ItemDisplay[9];
        for (int i = 0; i < 9; i++) {
            
            if (i >= itemArr.size()) {
                iPanels[i] = new ItemDisplay();
            } else {
                iPanels[i] = new ItemDisplay(itemArr.get(i));
            }
            iPanels[i].addChangeItemListener(this);


            this.add(iPanels[i]);
        }
        this.updateUI();
        
        
    }

    @Override
    public void newItem(Item nItem) {
        System.out.println("CenterPanel.newItem()");
        itemArr.addItem(nItem);
        updateGrid();
    }

    @Override
    public void updateGrid() {
        System.out.println("CenterPanel.updateGrid()");
        init();
    }

    @Override
    public void deleteItem(Item dItem) {
        itemArr.getItems().remove(dItem);
        updateGrid();
    }
    
}
