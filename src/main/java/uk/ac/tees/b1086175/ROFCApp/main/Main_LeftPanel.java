/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main;

import uk.ac.tees.b1086175.ROFCApp.newitem.DeskPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.ChairPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.NewItemFrame;
import uk.ac.tees.b1086175.ROFCApp.newitem.TablePanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import uk.ac.tees.b1086175.ROFCApp.newitem.ItemPanel;

/** Panel holding the buttons for adding new items.
 *
 * @author b1086175 | Jake Taylor
 */
public class Main_LeftPanel extends JPanel {
    private final Main_CentrePanel grid;
    NewItemFrame newIF;

    /**
     * Constructor requiring a reference the the grid holding the order.
     * @param grid
     */
    public Main_LeftPanel(Main_CentrePanel grid) {
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
    
    private void openNewItemGUI(ItemPanel itemPanel) {
        newIF = new NewItemFrame(itemPanel);
        newIF.addChangeItemListener(grid);
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

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Add Chair has been pressed!");
            
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    openNewItemGUI(new ChairPanel());
                }
                
            });
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

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    openNewItemGUI(new TablePanel());
                }
            });
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

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    openNewItemGUI(new DeskPanel());
                }
            });
        }

    }
}
