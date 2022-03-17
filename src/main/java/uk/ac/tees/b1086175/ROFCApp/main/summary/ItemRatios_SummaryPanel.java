/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main.summary;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.Order;

/**
 *
 * @author b1086175
 */
public class ItemRatios_SummaryPanel extends JPanel{
    private final Order myOrder = Order.getInstance();
    
    private JFreeChart pieChart;

    public ItemRatios_SummaryPanel() {
        init();
    }
    
    private void init() {
        pieChart = createItemRatioChart(getDataset());
        this.add(new ChartPanel(pieChart));
    }
    
    private PieDataset getDataset() {
        DefaultPieDataset data = new DefaultPieDataset();
        
        data.setValue("Chairs", getItemCount("Chair"));
        data.setValue("Table", getItemCount("Table"));
        data.setValue("Desk", getItemCount("Desk"));
        
        return data;
    }
    
    private JFreeChart createItemRatioChart(PieDataset dataset) {
        JFreeChart myChart = ChartFactory.createPieChart("Items", dataset, true, true, false);
        
        return myChart;
    }
    
    
    private int getItemCount(String simpleName) {
        int result = 0;
        for (int i = 0; i < myOrder.size(); i++) {
            Item myItem = myOrder.get(i);
            
            if (myItem.getClass().getSimpleName().equals(simpleName)) {
                result += myItem.getQuantity();
            }
        }
        return result;
    }
}
