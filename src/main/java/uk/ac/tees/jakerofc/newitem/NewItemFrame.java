/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.newitem;

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
import javax.swing.JPanel;
import uk.ac.tees.jakerofc.Item;
import uk.ac.tees.jakerofc.main.ChangeItemListener;
import uk.ac.tees.jakerofc.newitem.NewItemFrame.*;

/**
 * change center panel to
 * @author Jake
 */
public class NewItemFrame extends JFrame {
    
    //protected ItemPanel jpForm;
    public JPanel jpFooter;
    private ItemPanel jpCenter;
    protected Item newItem;
    
    private List<ChangeItemListener> changeListeners = new ArrayList<>();
    
    public NewItemFrame(ItemPanel panel) throws HeadlessException {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
    
        // Center Panel with components
        jpCenter = panel;
        this.add(jpCenter, BorderLayout.CENTER);
        
        // Add Footer buttons
        initFooter();
        
        this.setTitle(jpCenter.getTitle());// to be overwritten by subclass
        this.setSize(400, 400);
        this.setVisible(true);// should be in subclass
    }
    
    private void initFooter() {
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
                
                if (newItem == null) {
                    System.out.println("newItem is null");
                    return;
                }
                
                if (e.getSource() == jbCancel) {
                    System.out.println("Cancel has been pressed");
                    dispose();// Shut the frame
                } else if (e.getSource() == jbSave) {
                    System.out.println("Save has been pressed");

                    for (ChangeItemListener l : changeListeners) {
                        l.newItem(newItem);
                    }
                    dispose();// Shut the frame
                } else {
                    System.out.println("Error - Action performed but no source.");
                }
            }
            
            /*public void addChangeItemListener(ChangeItemListener e) {
            changeListeners.add(e);
            }*/

            @Override
            public void newTotal(int total) {
                jlTotal.setText(String.format("Total: £%.2f", (double) total /100));
            }
            
        }
        jpFooter = new FooterPanel();
        this.add(jpFooter, BorderLayout.SOUTH);
    }
    
    public void addChangeItemListener(ChangeItemListener e) {
        changeListeners.add(e);
    }
    
}
