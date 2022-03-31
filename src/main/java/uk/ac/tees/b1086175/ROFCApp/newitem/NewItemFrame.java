/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.newitem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
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
 * change center panel to
 * @author b1086175 | Jake Taylor
 */
public class NewItemFrame extends JFrame {
    
    //protected ItemPanel jpForm;
    public JPanel jpFooter;
    protected ItemPanel jpCenter;
    protected Item newItem;
    private boolean editMode;
    
    private List<ChangeItemListener> changeListeners = new ArrayList<>();
    
    public NewItemFrame(ItemPanel panel) throws HeadlessException {
        editMode = false;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
    
        // Center Panel with components
        jpCenter = panel;
        this.add(jpCenter, BorderLayout.CENTER);
        
        // Add Footer buttons
        initFooter();
        
        this.setTitle("New " + jpCenter.getTitle());
        this.setSize(400, 400);
        this.setVisible(true);// should be in subclass
    }

    public NewItemFrame(ItemPanel jpCenter, Item newItem) {
        this(jpCenter);
        
        editMode = true;
        this.newItem = newItem;
        
        this.setTitle("Edit " + jpCenter.getTitle());
        
        this.jpCenter.setItem(newItem);
    }
    
    
    
    private void initFooter() {
        
        jpFooter = new FooterPanel();
        this.add(jpFooter, BorderLayout.SOUTH);
    }
    
    class FooterPanel extends JPanel implements ActionListener, TotalUpdate {
            private JLabel jlTotal;
            private JButton jbCancel;
            private JButton jbSave;
            
            public FooterPanel() {
                jlTotal = new JLabel("Total: ");
                
                
                jbCancel = new JButton("Cancel");
                jbCancel.addActionListener(this);
                
                jbSave = new JButton("Save");
                jbSave.addActionListener(this);
                
                this.setLayout(new FlowLayout(FlowLayout.RIGHT));
                
                this.add(jlTotal);
                this.add(jbCancel);
                this.add(jbSave);
                
                jpCenter.addTotalUpdate(this);
            }
            
            public void setTotal(int value) {
                jlTotal.setText(String.format("Total: £%.2f", (double) value /100));
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                newItem = jpCenter.getNewItem();
                
                if (e.getSource() == jbCancel) {
                    System.out.println("Cancel has been pressed");
                    dispose();// Shut the frame
                    return;
                }
                
                if (newItem == null) {
                    System.out.println("newItem is null");
                    JOptionPane.showMessageDialog(this, "Cannot Save Item - Item Fields are not valid");
                    return;
                }
                
                if (e.getSource() == jbSave) {
                    System.out.println("Save has been pressed");
                    
                    //Refresh the item
                    
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
    
    public void addChangeItemListener(ChangeItemListener e) {
        changeListeners.add(e);
    }
    
}
