/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main.details;

import javax.swing.JLabel;
import uk.ac.tees.b1086175.ROFCApp.Desk;
import uk.ac.tees.b1086175.ROFCApp.Item;

/** Panel to display the attributes of a Desk.
 *
 * @author b1086175 | Jake Taylor
 */
public class DeskDetailsPanel extends ItemDetailsPanel {
    protected Desk myDesk;
    
    protected JLabel drawsLabel;
    protected JLabel heightLabel, widthLabel, depthLabel;
    
    public DeskDetailsPanel(Item myItem) {
        super(myItem);
        
        myDesk = (Desk) myItem;
        
        init();
    }
    
    private void init() {
        drawsLabel = new JLabel(String.format("Draws: %d", myDesk.getDraws()));
        add(drawsLabel);
        
        heightLabel = new JLabel(String.format("Height: %d", Desk.HEIGHT));
        add(heightLabel);
        
        widthLabel = new JLabel(String.format("Width: %d", myDesk.getWidth()));
        add(widthLabel);
        
        depthLabel = new JLabel(String.format("Depth: %d", myDesk.getDepth()));
        add(depthLabel);
    }
}
