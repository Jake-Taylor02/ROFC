/*
 * TODO
    Summary order
    Does summary have to show more then Item attributes
    correct access modifiers
    clean up callbacks
 */
package uk.ac.tees.b1086175.ROFCApp.main;

import uk.ac.tees.b1086175.ROFCApp.*;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author b1086175 | Jake Taylor
 */
public class ROFCapp extends JFrame {
    private Order itemArr = Order.getInstance();
    
    CenterPanel jpCenter;
    
    public static void main(String[] args) {
        new ROFCapp();
    }

    public ROFCapp() throws HeadlessException {
        // Test items
        itemArr.addItem(new Chair("001", WoodType.OAK, 1, true));
        itemArr.addItem(new Desk("002", WoodType.WALNUT, 1, 100, 75, 3));
        itemArr.addItem(new Desk("003", WoodType.WALNUT, 1, 100, 75, 3));
        itemArr.addItem(new Chair("004", WoodType.OAK, 2, true));
        itemArr.addItem(new Table("005", WoodType.OAK, 1, TableBase.WOODEN, 60));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ROFC");
        this.setLayout(new BorderLayout(5, 5));
        
        // define top panel and add it to frame
        TopPanel jpTop = new TopPanel();
        this.add(jpTop, BorderLayout.NORTH);
        
        // Define center grid and add it to frame
        jpCenter = new CenterPanel();
        JScrollPane jsp = new JScrollPane(jpCenter);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(jsp, BorderLayout.CENTER);
        
        jpTop.setChangeItemListener(jpCenter);
        
        // define left panel and add it to frame
        JPanel jpLeft = new LeftPanel(jpCenter);
        this.add(jpLeft, BorderLayout.WEST);
        
        
        
        
        
        // Define bottom Panel
        initBottom();
        
        this.pack();
        this.setVisible(true);
    }
    
    private void initBottom() {
        class BottomPanel extends Box implements ActionListener {
            JButton jlTotal;
            JButton jbSummary;
            
            public BottomPanel() {
                super(BoxLayout.X_AXIS);
                
                jlTotal = new JButton("Total");
                jlTotal.addActionListener(this);
        
                jbSummary = new JButton("Show Summary");
                jbSummary.addActionListener(this);
        
                this.add(jlTotal);
                this.add(Box.createHorizontalGlue());
                this.add(jbSummary);
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jlTotal) {
                    
                    JOptionPane.showMessageDialog(this, String.format("Total: £%.2f",
                    (double) itemArr.calcTotal() / 100));
            
                } else if (e.getSource() == jbSummary) {
                    JOptionPane.showMessageDialog(this, new SummaryPanel(), "Order Summary", JOptionPane.INFORMATION_MESSAGE);
                    //JOptionPane.showMessageDialog(this, itemArr.orderSummary());
                    System.out.println(itemArr.orderSummary());
                }
            }
            
        }
        BottomPanel jpBottom = new BottomPanel();
        this.add(jpBottom, BorderLayout.SOUTH);
    }

   
    
    
}
