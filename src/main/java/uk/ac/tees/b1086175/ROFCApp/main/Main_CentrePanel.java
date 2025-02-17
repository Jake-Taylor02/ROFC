/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main;

import java.awt.GridLayout;
import javax.swing.JPanel;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.Order;

/** Panel to hold Grid for displaying the Order.
 *
 * @author b1086175 | Jake Taylor
 */
public class Main_CentrePanel extends JPanel implements ChangeItemListener {
    private final Order myOrder;
    private ItemDisplay[] iPanels;

    /**
     *  Constructor.
     */
    public Main_CentrePanel() {
        this.myOrder = Order.getInstance();
        
        init();
    }
    
    private void init(){
        this.removeAll();
        this.setLayout(new GridLayout(3, 3, 5, 5));
        
        iPanels = new ItemDisplay[9];
        
        for (int i = 0; i < 9; i++) {
            
            if (i >= myOrder.size()) {
                iPanels[i] = new ItemDisplay(this);
            } else {
                iPanels[i] = new ItemDisplay(this, myOrder.get(i));
            }
            iPanels[i].addChangeItemListener(this);


            this.add(iPanels[i]);
        }
        
        this.updateUI();
    }

    @Override
    public void newItem(Item nItem) {
        myOrder.addItem(nItem);
        updateGrid();
    }

    @Override
    public void updateGrid() {
        init();
    }

    @Override
    public void deleteItem(Item dItem) {
        myOrder.removeItem(dItem);
        updateGrid();
    }
    
 
    
}
