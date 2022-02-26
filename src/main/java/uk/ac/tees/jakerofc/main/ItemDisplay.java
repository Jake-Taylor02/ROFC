/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import uk.ac.tees.jakerofc.Item;

/**
 *
 * @author jake
 */
public class ItemDisplay extends JPanel implements MouseListener {
    JLabel jlItem;
    Item myItem;
    boolean empty;

    private List<ChangeItemListener> changeListeners = new ArrayList<>();
    
    public ItemDisplay() {
        empty = true;
        jlItem = new JLabel();
        jlItem.setIcon(Item.defaultImage());
        jlItem.addMouseListener(this);
        this.add(jlItem);
    }
    
    public ItemDisplay(Item myItem) {
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
            JOptionPane.showMessageDialog(this, myItem.getSummary());
        } else if (e.getButton() == 2) {
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
