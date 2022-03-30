package uk.ac.tees.b1086175.ROFCApp.main;

import uk.ac.tees.b1086175.ROFCApp.*;
import java.awt.HeadlessException;
import javax.swing.*;

/** TODO
 * - Item class uses ImageIcon, should use File or Path instead.
 * - JUnitTest
 * - Should i have grid lines?
 * - is OrderView the right way to do it?
 *
 * @author b1086175 | Jake Taylor
 */
public class ROFCapp extends JFrame {
    private MainPanel mainPanel;
    private static final Order itemArr = Order.getInstance();
    
    public static void main(String[] args) {
        // Test items
        itemArr.addItem(new Chair("001", WoodType.OAK, 1, true));
        itemArr.addItem(new Desk("002", WoodType.WALNUT, 1, 100, 75, 3));
        itemArr.addItem(new Desk("003", WoodType.WALNUT, 1, 100, 75, 3));
        itemArr.addItem(new Chair("004", WoodType.OAK, 2, true));
        itemArr.addItem(new Table("005", WoodType.OAK, 1, TableBase.WOODEN, 60));
        
        new ROFCapp();
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
