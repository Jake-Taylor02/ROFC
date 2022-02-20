/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.main;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.*;
import uk.ac.tees.jakerofc.Chair;
import uk.ac.tees.jakerofc.Desk;
import uk.ac.tees.jakerofc.newitem.*;
import uk.ac.tees.jakerofc.Order;
import uk.ac.tees.jakerofc.Table;
import uk.ac.tees.jakerofc.TableBase;
import uk.ac.tees.jakerofc.WoodType;

/**
 *  * set image, use static in subclasses for image?
 * @author b1086175
 */
public class ROFCapp extends JFrame {
    public static Order itemArr = new Order();
    
    public static void main(String[] args) {
        
        // test items
        itemArr.addItem(new Chair("001", WoodType.OAK, 1, true));
        itemArr.addItem(new Desk("002", WoodType.WALNUT, 1, 100, 75, 3));
        itemArr.addItem(new Desk("003", WoodType.WALNUT, 1, 100, 75, 3));
        itemArr.addItem(new Chair("004", WoodType.OAK, 2, true));
        itemArr.addItem(new Table("005", WoodType.OAK, 1, TableBase.WOODEN, 60));
        
        new ROFCapp();
        
        
    }

    public ROFCapp() throws HeadlessException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ROFC");
        this.setLayout(new BorderLayout(5, 5));
        
        // define top panel and add it to frame
        JPanel jpTop = new TopPanel();
        this.add(jpTop, BorderLayout.NORTH);

        // define left panel and add it to frame
        JPanel jpLeft = new LeftPanel();
        this.add(jpLeft, BorderLayout.WEST);
        
        
        // Define center grid and add it to frame
        JPanel jpCenter = new CenterPanel(itemArr);
        JScrollPane jsp = new JScrollPane(jpCenter);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(jsp, BorderLayout.CENTER);
        
        
        
        // Define bottom Panel
        BottomPanel jpBottom = new BottomPanel();
        this.add(jpBottom, BorderLayout.SOUTH);
        
        this.pack();
        this.setVisible(true);
    }
    
   
    
    
}
