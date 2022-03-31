/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.newitem.NewItemFrame;
import uk.ac.tees.b1086175.ROFCApp.newitem.panels.*;
import uk.ac.tees.b1086175.ROFCApp.view.OrderView;

/**
 *  JPanel that visually represents a single Item in CenterPanel.
 *  
 * @see CenterPanel
 * @author jake
 */
public class ItemDisplay extends JPanel implements MouseListener {
    private JLabel jlItem;
    private Item myItem;
    private final CenterPanel parentCont;
    private final boolean empty;

    private final List<ChangeItemListener> changeListeners = new ArrayList<>();
    
    /**
     * Constructor for when a grid cell should be empty.
     * icon is set to default image
     * @param owner Reference to parent container
     */
    public ItemDisplay(CenterPanel owner) {
        this.parentCont = owner;
        empty = true;
        init();
    }
    
    /**
     * 
     * @param owner Reference to parent container
     * @param myItem Reference to the Item which the JPanel represents
     */
    public ItemDisplay(CenterPanel owner, Item myItem) {
        this.parentCont = owner;
        this.myItem = myItem;
        empty = false;
        init();
    }
    
    private void init() {
        jlItem = new JLabel();
        if (!empty) jlItem.setIcon(myItem.getImage());
        
        this.addMouseListener(this);
        this.add(jlItem);
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
            JPanel summaryPanel = OrderView.getView(myItem).getDetailsPanel();
            
            if (summaryPanel != null) {
                JOptionPane.showMessageDialog(this, summaryPanel);
            } else {
                System.out.println("Error - could not open details panel");
                JOptionPane.showMessageDialog(this, "Error - could not open details panel");
            }
            
        } else if (e.getButton() == MouseEvent.BUTTON2) {
            // Edit Item
            NewItemFrame edit;
            ItemPanel editPanel;
            System.out.println("button 3 clicked");
            System.out.println(myItem.getClass().getSimpleName());
            
            editPanel = OrderView.getView(myItem).getEditPanel();
            
            edit = new NewItemFrame(editPanel, myItem);
            edit.addChangeItemListener(parentCont);
 
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
        System.out.println("Mouse pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouse entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouse exited");
    }
    
    public void addChangeItemListener(ChangeItemListener e) {
        changeListeners.add(e);
    }
    
}
