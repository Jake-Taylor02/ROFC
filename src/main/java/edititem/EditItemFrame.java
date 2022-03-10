/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edititem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uk.ac.tees.jakerofc.*;
import uk.ac.tees.jakerofc.main.*;
import uk.ac.tees.jakerofc.newitem.*;

/**
 * Frame allowing the user to access and modify items.
 *  Shown when user middle-clicks on an item.
 * @author b1086175 | Jake Taylor
 */
public class EditItemFrame extends JFrame{
    private final ItemPanel jpCenter;
    private JPanel jpFooter;
    protected Item myItem, newItem;
    
    private List<ChangeItemListener> changeListeners = new ArrayList<>();
    
    public EditItemFrame(ItemPanel panel, Item item) {
        this.myItem = item;
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        jpCenter = panel;
        this.add(jpCenter, BorderLayout.CENTER);
        
        // should add footer
        initFoot();
        
        this.setTitle("Edit " + jpCenter.getTitle());
        this.setSize(400, 400);
        this.setVisible(true);// should be in subclass
    }
    
    private void initFoot() {
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
                    return;
                }

                if (e.getSource() == jbSave) {
                    System.out.println("Save has been pressed");
                    for (ChangeItemListener cil : changeListeners) {
                        cil.replaceItem(myItem, newItem);
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
        jpFooter = new FooterPanel();
        this.add(jpFooter, BorderLayout.SOUTH);
    }
    
    public void addChangeItemListener(ChangeItemListener e) {
        changeListeners.add(e);
    }
}
