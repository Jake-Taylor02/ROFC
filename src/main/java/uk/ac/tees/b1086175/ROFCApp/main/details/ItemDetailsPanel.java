/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main.details;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uk.ac.tees.b1086175.ROFCApp.Item;

/**
 *
 * @author jake
 */
public abstract class ItemDetailsPanel extends JPanel{
    protected final Item myItem;
    
    protected JLabel itemImage;
    protected JLabel idLabel;
    protected JLabel woodLabel;
    protected JLabel itemPriceLabel;
    protected JLabel quantityLabel;
    protected JLabel totalPriceLabel;

    public ItemDetailsPanel(Item myItem) {
        this.myItem = myItem;
        
        init();
    }
    
    private void init() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        itemImage = new JLabel(myItem.getImage());
        add(itemImage);
        
        idLabel = new JLabel(String.format("Item ID: %s", myItem.getID()));
        add(idLabel);
        
        woodLabel = new JLabel(String.format("Type of Wood: %s", myItem.getWood().toString()));
        add(woodLabel);
        
        itemPriceLabel = new JLabel(String.format("Item Price: £%.2f", (double) myItem.getItemPrice() / 100));
        add(itemPriceLabel);
        
        quantityLabel = new JLabel(String.format("Quantity: %d", myItem.getQuantity()));
        add(quantityLabel);
        
        totalPriceLabel = new JLabel(String.format("Total Price: £%.2f", (double) (myItem.getItemPrice() * myItem.getQuantity()) / 100));
        add(totalPriceLabel);
    }
}
