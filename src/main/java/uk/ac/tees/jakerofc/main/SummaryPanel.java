/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.jakerofc.main;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import uk.ac.tees.jakerofc.Item;
import uk.ac.tees.jakerofc.Order;

/**
 *
 * @author b1086175 | Jake Taylor
 */
public class SummaryPanel extends JPanel{
    private final Order items;
    private JTable table;

    public SummaryPanel() {
        this.items = Order.getInstance();
        table = new JTable();
        table.setModel(new ItemTableModel());
        
        JScrollPane spTable = new JScrollPane(table);
        
        this.add(spTable);
    }
    
    class ItemTableModel extends AbstractTableModel {
        
        private final String[] headers = {"Item Type", "ID Number",
            "Type of Wood", "Item Price", "Quantity", "Total Price"};
        
        public ItemTableModel() {
        }
        
        @Override
        public int getRowCount() {
            return items.size();
        }

        @Override
        public int getColumnCount() {
            return headers.length;
        }
        
        @Override
        public String getColumnName(int column) {
            return headers[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            final Item item = items.get(rowIndex);
            
            switch (columnIndex) {
                case 0:
                    return item.getClass().getSimpleName();
                case 1:
                    return item.getID();
                case 2:
                    return item.getWood();
                case 3:
                    return item.getItemPrice();
                case 4:
                    return item.getQuantity();
                case 5:
                    return item.getTotalPrice();
                default:
                    return null;
            }
        }
        
    }
    
    
}
