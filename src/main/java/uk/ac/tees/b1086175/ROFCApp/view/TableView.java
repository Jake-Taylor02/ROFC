/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.view;

import javax.swing.JPanel;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.Table;
import uk.ac.tees.b1086175.ROFCApp.main.details.TableDetailsPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.panels.ItemPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.panels.TablePanel;

/**
 *
 * @author b1086175
 */
public class TableView extends ItemView{

    public TableView(Item item) {
        super(item);
    }

    @Override
    public JPanel getDetailsPanel() {
        return new TableDetailsPanel(item);
    }

    @Override
    public ItemPanel getEditPanel() {
        return new TablePanel((Table) item);
    }
    
    public static ItemPanel getNewItemPanel() {
        return new TablePanel();
    }
    
}
