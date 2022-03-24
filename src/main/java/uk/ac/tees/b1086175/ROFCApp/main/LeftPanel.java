/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main;

import uk.ac.tees.b1086175.ROFCApp.newitem.panels.DeskPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.panels.ChairPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.NewItemFrame;
import uk.ac.tees.b1086175.ROFCApp.newitem.panels.TablePanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/** Move to main internal?
 *
 * @author b1086175
 */
public class LeftPanel extends JPanel {
    private final CenterPanel grid;
    NewItemFrame newIF;

    public LeftPanel(CenterPanel grid) {
        this.grid = grid;
        
        init();
    }
    
    private void init() {
        // define Add Chair button
        ChairButton jbAddChair = new ChairButton();
        
        // Add Table Button
        TableButton jbAddTable = new TableButton();
        
        // Add Desk Button
        DeskButton jbAddDesk = new DeskButton();
        
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        // add buttons to left panel
        add(jbAddChair);
        add(jbAddTable);
        add(jbAddDesk);
    }
    
    class ChairButton extends JButton implements ActionListener {

        public ChairButton() {
            chairInit();
        }
        
        private void chairInit() {
            this.setText("Add Chair");
            this.setAlignmentX(Component.CENTER_ALIGNMENT);

            this.addActionListener(this);
        }
        // !!!! change these to one actipon listener, and use Orderview method

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Add Chair has been pressed!");
            newIF = new NewItemFrame(new ChairPanel());
            newIF.addChangeItemListener(grid);
        }

    }
    
    class TableButton extends JButton implements ActionListener {

            public TableButton() {
                tableInit();
            }
            
            private void tableInit() {
                this.setText("Add Table");
                this.setAlignmentX(Component.CENTER_ALIGNMENT);
                
                this.addActionListener(this);
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Table has been pressed!");
                newIF = new NewItemFrame(new TablePanel());
                newIF.addChangeItemListener(grid);
            }
            
        }
    
    class DeskButton extends JButton implements ActionListener {

            public DeskButton() {
                initDesk();
            }
            
            private void initDesk() {
                this.setText("Add Desk");
                this.setAlignmentX(Component.CENTER_ALIGNMENT);
                
                this.addActionListener(this);
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Desk has been pressed!");
                newIF = new NewItemFrame(new DeskPanel());
                newIF.addChangeItemListener(grid);
            }
            
        }
}
