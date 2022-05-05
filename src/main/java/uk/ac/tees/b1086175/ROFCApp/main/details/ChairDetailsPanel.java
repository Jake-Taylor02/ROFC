/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main.details;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import uk.ac.tees.b1086175.ROFCApp.Chair;
import uk.ac.tees.b1086175.ROFCApp.Item;

/** Panel to display the attributes of a Chair.
 * 
 * @author b1086175 | Jake Taylor
 */
public class ChairDetailsPanel extends ItemDetailsPanel {

    /**
     * Represents the Armrests of the Item.
     */
    protected JLabel armrestLabel;
    
    /**
     * Constructor requiring the Item which is being displayed.
     * @param myItem
     */
    public ChairDetailsPanel(Item myItem) {
        super(myItem);
        
        init();
    }
    
    private void init() {
        Chair myChair;
        try {
            myChair = (Chair) myItem;
        } catch (ClassCastException e) {
            JOptionPane.showInternalMessageDialog(this,
                    "Could not display summary. Item counld not be cast to Chair.");
            return;
        }
        
        armrestLabel = new JLabel(String.format("Armrests: %s",
                    myChair.isArmrests() ? "Yes" : "No"
        ));
        add(armrestLabel);
    }
    
}
