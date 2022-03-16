/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main.details;

import javax.swing.JLabel;
import uk.ac.tees.b1086175.ROFCApp.Chair;
import uk.ac.tees.b1086175.ROFCApp.Item;

/**
 *
 * @author jake
 */
public class ChairDetailsPanel extends ItemDetailsPanel {
    protected Chair myChair;
    protected JLabel armrestLabel;
    
    public ChairDetailsPanel(Item myItem) {
        super(myItem);
        
        myChair = (Chair) myItem;// Exception?
        
        init();
    }
    
    private void init() {
        armrestLabel = new JLabel(String.format("Armrests: %s", 
                myChair.isArmrests() ? "Yes" : "No"
        ));
        add(armrestLabel);
    }
    
}
