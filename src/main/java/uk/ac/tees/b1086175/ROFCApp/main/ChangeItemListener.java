/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uk.ac.tees.b1086175.ROFCApp.main;

import uk.ac.tees.b1086175.ROFCApp.Item;

/** Observer interface to notify subscribers of a change in the order.
 *
 * @author b1086175 | Jake Taylor
 */
public interface ChangeItemListener {

    /** A new item being added to the order.
     *
     * @param nItem the new item
     */
    public void newItem(Item nItem);

    /** The visual representation of the order needs to be updated
     *
     */
    public void updateGrid();

    /** Delete the specified item from the order
     *
     * @param dItem the item to be deleted
     */
    public void deleteItem(Item dItem);
}
