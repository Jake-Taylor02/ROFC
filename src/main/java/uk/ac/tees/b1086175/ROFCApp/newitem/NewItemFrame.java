/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.newitem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.main.ChangeItemListener;
import uk.ac.tees.b1086175.ROFCApp.newitem.NewItemFrame.*;

/**
 * JFrame allowing user to add and edit individual items.
 * @author b1086175 | Jake Taylor
 */
public class NewItemFrame extends JFrame {
    
    /**
     * The bottom panel holding the Save and Cancel buttons.
     */
    public JPanel jpFooter;

    /**
     * Panel holding the fields for inputting item attributes.
     */
    protected ItemPanel jpCentre;

    /**
     * The item to be saved.
     */
    protected Item newItem;
    
    private final boolean editMode;
    
    private final List<ChangeItemListener> changeListeners = new ArrayList<>();
    
    /**
     * Constructor used when creating a new Item.
     * @param panel
     */
    public NewItemFrame(ItemPanel panel) {
        editMode = false;
        jpCentre = panel;
        init();
    }
    
    /**
     * Constructor used when editing an existing element.
     * @param panel
     * @param newItem
     */
    public NewItemFrame(ItemPanel panel, Item newItem) {
        editMode = true;
        jpCentre = panel;
        this.newItem = newItem;
        init();
    }
    
    private void init() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
    
        // Center Panel with components
        this.add(jpCentre, BorderLayout.CENTER);
        
        // Add Footer buttons
        initFooter();
        
        
        this.setSize(400, 400);
        this.setVisible(true);// should be in subclass
        
        if (!editMode) {
            this.setTitle("New " + jpCentre.getTitle());
        } else {
            this.setTitle("Edit " + jpCentre.getTitle());
            this.jpCentre.setItem(newItem);
        }
    }
    
    private void initFooter() {
        jpFooter = new FooterPanel();
        this.add(jpFooter, BorderLayout.SOUTH);
    }
    
    /**
     * Panel to hold Save and Cancel functions.
     */
    class FooterPanel extends JPanel implements ActionListener, TotalUpdate {
            private JLabel jlTotal;
            private JButton jbCancel;
            private JButton jbSave;
            
            public FooterPanel() {
                init();
            }
            
            private void init() {
                jlTotal = new JLabel("Total: ");
                
                
                jbCancel = new JButton("Cancel");
                jbCancel.addActionListener(this);
                
                jbSave = new JButton("Save");
                jbSave.addActionListener(this);
                
                this.setLayout(new FlowLayout(FlowLayout.RIGHT));
                
                this.add(jlTotal);
                this.add(jbCancel);
                this.add(jbSave);
                
                jpCentre.addTotalUpdate(this);
            }
            
            public void setTotal(int value) {
                jlTotal.setText(String.format("Total: £%.2f", (double) value /100));
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                newItem = jpCentre.getNewItem();
                
                if (e.getSource() == jbCancel) {
                    dispose();// Shut the frame
                    return;
                }
                
                if (newItem == null) {
                    JOptionPane.showMessageDialog(this, "Cannot Save Item - Item Fields are not valid");
                    return;
                }
                
                if (e.getSource() == jbSave) {
                    
                    if (editMode) {
                        for (ChangeItemListener l : changeListeners) {
                            l.updateGrid();
                        }
                    } else {
                        for (ChangeItemListener l : changeListeners) {
                            l.newItem(newItem);
                        }
                    }

                    
                    dispose();// Shut the frame
                } else {
                    System.out.println("Error - Action performed but no source.");
                }
            }

            @Override
            public void newTotal(int total) {
                jlTotal.setText(String.format("Total: £%.2f", (double) total /100));
            }
            
        }
    
    /**
     *
     * @param e
     */
    public void addChangeItemListener(ChangeItemListener e) {
        changeListeners.add(e);
    }
    
}
