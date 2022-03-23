/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main;

import uk.ac.tees.b1086175.ROFCApp.newitem.EditItemFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.main.details.ChairDetailsPanel;
import uk.ac.tees.b1086175.ROFCApp.main.details.DeskDetailsPanel;
import uk.ac.tees.b1086175.ROFCApp.main.details.ItemDetailsPanel;
import uk.ac.tees.b1086175.ROFCApp.main.details.TableDetailsPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.panels.ChairPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.panels.DeskPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.panels.TablePanel;

/**
 *  JPanel that visually represents a single Item in CenterPanel.
 *  
 * @see CenterPanel
 * @author jake
 */
public class ItemDisplay extends JPanel implements MouseListener {
    private JLabel jlItem;
    private Item myItem;
    private CenterPanel parentCont;
    private boolean empty;

    private List<ChangeItemListener> changeListeners = new ArrayList<>();
    
    /**
     * Constructor for when a grid cell should be empty.
     * icon is set to default image
     * @param owner Reference to parent container
     */
    public ItemDisplay(CenterPanel owner) {
        this.parentCont = owner;
        empty = true;
        jlItem = new JLabel();
        jlItem.setIcon(Item.defaultImage());
        jlItem.addMouseListener(this);
        this.add(jlItem);
    }
    
    /**
     * 
     * @param owner Reference to parent container
     * @param myItem Reference to the Item which the JPanel represents
     */
    public ItemDisplay(CenterPanel owner, Item myItem) {
        this.parentCont = owner;
        empty = false;
        
        this.myItem = myItem;
        jlItem = new JLabel();
        jlItem.setIcon(myItem.getImage());
        jlItem.addMouseListener(this);
        this.add(jlItem);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked");
        
        if (empty) {
            JOptionPane.showMessageDialog(this, "This Cell Is Empty");
            return;
        }
        
        if (e.getButton() == 1) {
            // Show item details
            ItemDetailsPanel summaryPanel = null;
            switch (myItem.getClass().getSimpleName()) {
                case "Chair":
                    summaryPanel = new ChairDetailsPanel(myItem);
                    break;
                case "Table":
                    summaryPanel = new TableDetailsPanel(myItem);
                    break;
                case "Desk":
                    summaryPanel = new DeskDetailsPanel(myItem);
            }
            
            if (summaryPanel != null) {
                JOptionPane.showMessageDialog(this, summaryPanel);
            } else {
                System.out.println("Error - could not open details panel");
                JOptionPane.showMessageDialog(this, "Error - could not open details panel");
            }
            
        } else if (e.getButton() == 2) {
            // Edit Item
            EditItemFrame edit;
            System.out.println("button 3 clicked");
            System.out.println(myItem.getClass().getSimpleName());
            
            if (myItem.getClass().getSimpleName().equals("Chair")) {
                edit = new EditItemFrame(new ChairPanel(myItem), myItem);
                edit.addChangeItemListener(parentCont);
            } else
            if (myItem.getClass().getSimpleName().equals("Table")) {
                edit = new EditItemFrame(new TablePanel(myItem), myItem);
                edit.addChangeItemListener(parentCont);
            } else
            if (myItem.getClass().getSimpleName().equals("Desk")) {
                edit = new EditItemFrame(new DeskPanel(myItem), myItem);
                edit.addChangeItemListener(parentCont);
            }
        } else if (e.getButton() == 3) {
            
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
        System.out.println("mouse ");
    }
    
    public void addChangeItemListener(ChangeItemListener e) {
        changeListeners.add(e);
    }
    
}
