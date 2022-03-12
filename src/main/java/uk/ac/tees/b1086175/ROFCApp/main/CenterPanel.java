/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main;


import java.awt.GridLayout;
import javax.swing.JPanel;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.Order;

/** Panel to hold Grid for displaying Order
 *
 * @author b1086175 | Jake Taylor
 */
public class CenterPanel extends JPanel implements ChangeItemListener {
    private Order myOrder;
    private ItemDisplay[] iPanels;

    public CenterPanel() {
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
        System.out.println("CenterPanel.newItem()");
        myOrder.addItem(nItem);
        updateGrid();
    }

    @Override
    public void updateGrid() {
        System.out.println("CenterPanel.updateGrid()");
        init();
    }

    @Override
    public void deleteItem(Item dItem) {
        myOrder.removeItem(dItem);
        updateGrid();
    }
    /** Find and replaces specific item in Order
     * 
     * @param oItem
     * @param nItem 
     */
    @Override
    public void replaceItem(Item oItem, Item nItem) {
        
        for (int i = 0; i < myOrder.size(); i++) {
            if (myOrder.get(i) == oItem) {
                myOrder.replaceItem(i, nItem);
            }
        }
        updateGrid();
    }
    
}
