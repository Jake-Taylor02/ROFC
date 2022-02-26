/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edititem;

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
import uk.ac.tees.jakerofc.newitem.ItemPanel;
import uk.ac.tees.jakerofc.newitem.NewItemFrame;
import uk.ac.tees.jakerofc.newitem.TotalUpdate;

/**
 *
 * @author jake
 */
public class EditItemFrame extends JFrame{
    private ItemPanel jpCenter;
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
        
        this.setTitle(jpCenter.getTitle());// to be overwritten by subclass
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
