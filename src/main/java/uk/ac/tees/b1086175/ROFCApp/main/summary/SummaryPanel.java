/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main.summary;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.Order;

/**
 *
 * @author b1086175 | Jake Taylor
 */
public class SummaryPanel extends JPanel{
    private JTabbedPane jtp;
    
    private Table_SummaryPanel table;
    private JPanel piechart;

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
