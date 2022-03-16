/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main.details;

import javax.swing.JLabel;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.Table;

/**
 *
 * @author jake
 */
public class TableDetailsPanel extends ItemDetailsPanel {
    protected Table myTable;
    
    protected JLabel tableBaseLabel;
    protected JLabel diameterLabel;
    
    public TableDetailsPanel(Item myItem) {
        super(myItem);
        
        myTable = (Table) myItem;
        
        init();
    }
    
    private void init() {
        tableBaseLabel = new JLabel(String.format("Table Base: %s", myTable.getBase().toString()));
        add(tableBaseLabel);
        
        diameterLabel = new JLabel(String.format("Diameter: %d", myTable.getDiameter()));
        add(diameterLabel);
    }
}
