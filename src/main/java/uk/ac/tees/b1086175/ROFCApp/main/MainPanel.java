/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main;

import uk.ac.tees.b1086175.ROFCApp.main.summary.SummaryPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import uk.ac.tees.b1086175.ROFCApp.Order;

/**
 *
 * @author b1086175 | Jake Taylor
 */
public class MainPanel extends JPanel{
    private final Order itemArr = Order.getInstance();
    
    private CenterPanel jpCenter;
    private TopPanel jpTop;
    private JPanel jpLeft;
    private BottomPanel jpBottom;

    public MainPanel() {
        init();
    }
    
    private void init() {
        this.setLayout(new BorderLayout(5, 5));
        
        jpTop = new TopPanel();
        this.add(jpTop, BorderLayout.NORTH);
        
        jpCenter = new CenterPanel();
        JScrollPane jsp = new JScrollPane(jpCenter);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(jsp, BorderLayout.CENTER);
        
        jpTop.addChangeItemListener(jpCenter);
        
        jpLeft = new LeftPanel(jpCenter);
        this.add(jpLeft, BorderLayout.WEST);
        
        jpBottom = new BottomPanel();
        this.add(jpBottom, BorderLayout.SOUTH);
    }
            
    class BottomPanel extends Box implements ActionListener {

        private JButton jlTotal;
        private JButton jbSummary;

        public BottomPanel() {
            super(BoxLayout.X_AXIS);

            init();
        }
        
        private void init() {
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
                JOptionPane.showMessageDialog(this, new SummaryPanel(),
                    "Order Summary", JOptionPane.INFORMATION_MESSAGE);
                
                System.out.println(itemArr.orderSummary());
            }
        }
    } 
    
}
