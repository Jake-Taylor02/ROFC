package uk.ac.tees.b1086175.ROFCApp.main;

import uk.ac.tees.b1086175.ROFCApp.*;
import java.awt.HeadlessException;
import javax.swing.*;
import uk.ac.tees.b1086175.ROFCApp.view.OrderView;

/** TODO
 * - 
 * - JUnitTest
 * - Should i have grid lines?
 * - is OrderView the right way to do it?
 *
 * @author b1086175 | Jake Taylor
 */
public class ROFCapp extends JFrame {
    private MainPanel mainPanel;
    private static final Order myOrder = Order.getInstance();
    private static ROFCapp myGUI;
    
    
    public static void main(String[] args) {
        // Test items
        myOrder.addItem(new Chair(
                "CH001",// Item ID
                WoodType.OAK,// Type of Wood
                1,// Quantity
                true// Armrest
        ));
        myOrder.addItem(new Chair("CH002", WoodType.OAK, 2, false));
        
        myOrder.addItem(new Table(
                "TA001",// Item ID
                WoodType.OAK,// Type of Wood
                4,// Quantity
                TableBase.WOODEN,// Table Base 
                60// Diameter
        ));
        myOrder.addItem(new Table("TA002", WoodType.WALNUT, 2, TableBase.CHROME, 100));
        
        myOrder.addItem(new Desk(
                "DE001",// Item ID
                WoodType.WALNUT,// Type of Wood 
                1,// Quantity
                100,// Width
                75,// Depth
                3// Draws
        ));
        myOrder.addItem(new Desk("DE002", WoodType.OAK, 1, 150, 75, 0));
        
        
        
        
        OrderView.getInstance().populate();
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myGUI = new ROFCapp();
            }
        });
    }

    public ROFCapp() throws HeadlessException {
        init();
    }
    
    private void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ROFC");
        
        mainPanel = new MainPanel();
        add(mainPanel);
        
        this.pack();
        this.setVisible(true);
    }

    
    
    
}
