/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main.details;

import javax.swing.JLabel;
import uk.ac.tees.b1086175.ROFCApp.Desk;
import uk.ac.tees.b1086175.ROFCApp.Item;

/**
 *
 * @author jake
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
        
        heightLabel = new JLabel(String.format("Height: %d", 80));
    }
}
