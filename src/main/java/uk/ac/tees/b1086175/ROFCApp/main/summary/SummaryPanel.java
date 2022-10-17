/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main.summary;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/** Panel containing various summaries of the order.
 *
 * @author b1086175 | Jake Taylor
 */
public class SummaryPanel extends JPanel{
    private JTabbedPane jtp;
    
    private Table_SummaryPanel table;
    private JPanel piechart;

    /**
     * Constructor.
     */
    public SummaryPanel() {
        init();
    }
    
    private void init() {
        jtp = new JTabbedPane();
        table = new Table_SummaryPanel();
        jtp.add("Table", table);
        
        piechart = new ItemRatios_SummaryPanel();
        jtp.add("Item Pie Chart", piechart);
        
        this.add(jtp);
    }
    
}
