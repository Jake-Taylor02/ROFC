/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.view;

import javax.swing.JPanel;
import uk.ac.tees.b1086175.ROFCApp.Item;
import uk.ac.tees.b1086175.ROFCApp.Table;
import uk.ac.tees.b1086175.ROFCApp.main.details.TableDetailsPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.ItemPanel;
import uk.ac.tees.b1086175.ROFCApp.newitem.TablePanel;

/**
 *
 * @author b1086175
 */
public class TableView implements ItemView{

    @Override
    public JPanel getDetailsPanel(Item item) {
        return new TableDetailsPanel(item);
    }

    @Override
    public ItemPanel getEditPanel(Item item) {
        return new TablePanel((Table) item);
    }
    
    public static ItemPanel getNewItemPanel() {
        return new TablePanel();
    }
    
}
