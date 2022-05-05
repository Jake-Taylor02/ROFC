/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main.details;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.Table;

/** Panel to display the attributes of a Table.
 *
 * @author b1086175 | Jake Taylor
 */
public class TableDetailsPanel extends ItemDetailsPanel {
    
    /**
     * Represents the Base of the Table.
     */
    protected JLabel tableBaseLabel;

    /**
     * Represents in Diameter of the Table.
     */
    protected JLabel diameterLabel;
    
    /**
     * Constructor requiring the Item which is being displayed.
     * @param myItem
     */
    public TableDetailsPanel(Item myItem) {
        super(myItem);
        
        init();
    }
    
    private void init() {
        try {
            Table myTable = (Table) myItem;
            
            tableBaseLabel = new JLabel(String.format("Table Base: %s", myTable.getBase().toString()));
            add(tableBaseLabel);
            
            diameterLabel = new JLabel(String.format("Diameter: %d", myTable.getDiameter()));
            add(diameterLabel);
        } catch (ClassCastException e) {
            JOptionPane.showInternalMessageDialog(this,
                    "Could not display summary. Item counld not be cast to Table.");
        }
    }
}
