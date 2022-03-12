/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main;

import uk.ac.tees.b1086175.ROFCApp.Item;

/**
 *
 * @author jake
 */
public interface ChangeItemListener {
    public void newItem(Item nItem);
    public void updateGrid();
    public void deleteItem(Item dItem);
    public void replaceItem(Item oItem, Item nItem);
}
