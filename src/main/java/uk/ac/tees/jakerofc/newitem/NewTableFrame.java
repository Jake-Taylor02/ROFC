/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.newitem;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import uk.ac.tees.jakerofc.TableBase;

/**
 *
 * @author jake
 */
public class NewTableFrame extends NewItemFrame{
    private JComboBox jcbBase;
    private JSpinner diameter;
    protected ItemPanel mainPanel;
    
    public NewTableFrame() throws HeadlessException {
        super();
        
        initCenter();
        
        this.setVisible(true);
    }
    
    @Override
    protected void initCenter() {
        class TablePanel extends ItemPanel implements ActionListener {

            public TablePanel() {
                super();
                
                // add new components
                JLabel jlTableBase = new JLabel("Table Base:");
                jcbBase = new JComboBox(TableBase.values());
                jcbBase.setPreferredSize(this.txtSize);
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                super.actionPerformed(e);
                
                if (!this.validEntries) return;
                // Do actions related to chair
                
            }
        }
    }
    
}
