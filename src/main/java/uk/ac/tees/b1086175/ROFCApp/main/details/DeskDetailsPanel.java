/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main.details;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import uk.ac.tees.b1086175.ROFCApp.Desk;
import uk.ac.tees.b1086175.ROFCApp.Item;

/** Panel to display the attributes of a Desk.
 *
 * @author b1086175 | Jake Taylor
 */
public class DeskDetailsPanel extends ItemDetailsPanel {
    
    /**
     * Represents the Drawers of the Desk.
     */
    protected JLabel drawersLabel;

    /**
     * Represents the Height of the Desk.
     */
    protected JLabel heightLabel,

    /**
     * Represents the Width of the Desk.
     */
    widthLabel,

    /**
     * Represents the Depth of the Desk.
     */
    depthLabel;
    
    /**
     * Constructor requiring the Item which is being displayed.
     * @param myItem
     */
    public DeskDetailsPanel(Item myItem) {
        super(myItem);
        
        init();
    }
    
    private void init() {
        Desk myDesk;
        try {
            myDesk = (Desk) myItem;
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(this,
                    "Could not display summary. Item counld not be cast to Desk.");
            return;
        }
        
        drawersLabel = new JLabel(String.format("Draws: %d", myDesk.getDraws()));
        add(drawersLabel);

        heightLabel = new JLabel(String.format("Height: %d", Desk.HEIGHT));
        add(heightLabel);

        widthLabel = new JLabel(String.format("Width: %d", myDesk.getWidth()));
        add(widthLabel);

        depthLabel = new JLabel(String.format("Depth: %d", myDesk.getDepth()));
        add(depthLabel);
    }
}
