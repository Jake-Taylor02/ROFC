/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main;

import java.awt.Color;
import uk.ac.tees.b1086175.ROFCApp.newitem.ItemPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.Order;
import uk.ac.tees.b1086175.ROFCApp.newitem.NewItemFrame;
/**
 *  JPanel that visually represents a single Item in Main_CentrePanel.
 *  
 * @see Main_CentrePanel
 * @author b1086175 | Jake Taylor
 */
public class ItemDisplay extends JPanel implements MouseListener {
    private JLabel jlItem;
    private Item myItem;
    private final Main_CentrePanel parentCont;
    private final boolean empty;

    private final List<ChangeItemListener> changeListeners = new ArrayList<>();
    
    /**
     * Constructor for when a grid cell should be empty.
     * icon is set to default image
     * @param owner Reference to parent container
     */
    public ItemDisplay(Main_CentrePanel owner) {
        this.parentCont = owner;
        empty = true;
        init();
    }
    
    /**
     * Constructor for when the grid cell is occupied with an item.
     * @param owner Reference to parent container
     * @param myItem Reference to the Item which the JPanel represents
     */
    public ItemDisplay(Main_CentrePanel owner, Item myItem) {
        this.parentCont = owner;
        this.myItem = myItem;
        empty = false;
        init();
    }
    
    private void init() {
        jlItem = new JLabel();
        if (!empty) jlItem.setIcon(new ImageIcon(myItem.getImage().getPath()));
        
        this.addMouseListener(this);
        this.add(jlItem);
        
        if (!empty) {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            JLabel jlID = new JLabel(myItem.getClass().getSimpleName() + ": " + myItem.getID());
            this.add(jlID);
            
            this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked");
        
        if (empty) {
            JOptionPane.showMessageDialog(this, "This Cell Is Empty");
            return;
        }
        
        if (e.getButton() == MouseEvent.BUTTON1) {
            // Show item details
            JPanel summaryPanel = Order.getInstance()
                    .myViews.getView(myItem)
                    .getDetailsPanel(myItem);
            
            if (summaryPanel != null) {
                JOptionPane.showMessageDialog(this, summaryPanel, myItem.getID() + " Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Error - could not open details panel");
                JOptionPane.showMessageDialog(this, "Error - could not open details panel");
            }
            
        } else if (e.getButton() == MouseEvent.BUTTON2) {
            // Edit Item
            System.out.println("button 2 clicked");
            System.out.println(myItem.getClass().getSimpleName());
            
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ItemPanel editPanel  = Order.getInstance()
                            .myViews.getView(myItem)
                            .getEditPanel(myItem);
                    NewItemFrame edit = new NewItemFrame(editPanel, myItem);
                    edit.addChangeItemListener(parentCont);
                }
            });
 
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            
            // Remove the item
            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + myItem.getID());
            if (answer == 0) {
                for (ChangeItemListener listener : changeListeners) {
                    listener.deleteItem(myItem);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    /** Adds a subscriber to be notified when there is a change to this item.
     *
     * @param e the subscriber
     */
    public void addChangeItemListener(ChangeItemListener e) {
        changeListeners.add(e);
    }
    
}
