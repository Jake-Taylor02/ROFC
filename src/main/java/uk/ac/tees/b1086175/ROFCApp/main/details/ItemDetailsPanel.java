/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main.details;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uk.ac.tees.b1086175.ROFCApp.Item;

/** Panel to display the attributes of an Item.
 * 
 * @author b1086175 | Jake Taylor
 */
public abstract class ItemDetailsPanel extends JPanel{

    /**
     * The Item which is represented.
     */
    protected final Item myItem;
    
    /**
     * Contains the Image of the item.
     */
    protected JLabel itemImage;

    /**
     * Represents the ID Number of the Item.
     */
    protected JLabel idLabel;

    /**
     * Represents the Wood Type of the Item.
     */
    protected JLabel woodLabel;

    /**
     * Represents the Price of the Item.
     */
    protected JLabel itemPriceLabel;

    /**
     * Represents the Quantity of the Item.
     */
    protected JLabel quantityLabel;

    /**
     * Represents the Total Price of the Item.
     */
    protected JLabel totalPriceLabel;

    /**
     * Constructor requiring the Item which is being displayed.
     * @param myItem
     */
    public ItemDetailsPanel(Item myItem) {
        this.myItem = myItem;
        
        init();
    }
    
    /**
     * Initialising all of the components of this panel.
     */
    private void init() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        itemImage = new JLabel(new ImageIcon(myItem.getImage().getPath()));
        add(itemImage);
        
        idLabel = new JLabel(String.format("Item ID: %s", myItem.getID()));
        add(idLabel);
        
        woodLabel = new JLabel(String.format("Type of Wood: %s", myItem.getWood().toString()));
        add(woodLabel);
        
        itemPriceLabel = new JLabel(String.format("Item Price: £%.2f", (double) myItem.getItemPrice() / 100));
        add(itemPriceLabel);
        
        quantityLabel = new JLabel(String.format("Quantity: %d", myItem.getQuantity()));
        add(quantityLabel);
        
        if (myItem.getQuantity() > 1) {
            totalPriceLabel = new JLabel(String.format("Total Price: £%.2f", (double) (myItem.getTotalPrice()) / 100));
            add(totalPriceLabel);
        }
    }
}
