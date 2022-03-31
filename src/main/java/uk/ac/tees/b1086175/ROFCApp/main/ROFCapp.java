package uk.ac.tees.b1086175.ROFCApp.main;

import java.util.ArrayList;
import java.util.List;
import uk.ac.tees.b1086175.ROFCApp.*;
import javax.swing.*;

/**
 *
 * @author b1086175 | Jake Taylor
 */
public class ROFCapp extends JFrame {
    private static MainPanel mainPanel;
    private static final Order myOrder = Order.getInstance();
    private static JFrame myGUI;
    
    
    public static void main(String[] args) {
        // Test items
        cliFurnitureTest();
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() {
        myGUI = new JFrame();

        myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGUI.setTitle("ROFC");

        mainPanel = new MainPanel();
        myGUI.add(mainPanel);

        myGUI.pack();
        myGUI.setVisible(true);
    }
    
    private static void cliFurnitureTest() {
        List<Item> testList = new ArrayList<>();
        
        testList.add(new Chair(
                "CH001",// Item ID
                WoodType.OAK,// Type of Wood
                1,// Quantity
                true// Armrest
        ));
        testList.add(new Chair("CH002", WoodType.OAK, 2, false));
        
        testList.add(new Table(
                "TA001",// Item ID
                WoodType.OAK,// Type of Wood
                4,// Quantity
                TableBase.WOODEN,// Table Base 
                60// Diameter
        ));
        testList.add(new Table("TA002", WoodType.WALNUT, 2, TableBase.CHROME, 100));
        
        testList.add(new Desk(
                "DE001",// Item ID
                WoodType.WALNUT,// Type of Wood 
                1,// Quantity
                100,// Width
                75,// Depth
                3// Draws
        ));
        testList.add(new Desk("DE002", WoodType.OAK, 1, 150, 75, 0));
        
        // print stuff....
        for (Item it : testList) {
            System.out.println(it.toString());
        }
    }

}
