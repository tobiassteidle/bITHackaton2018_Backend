package de.bithackaton.model;

import tec.units.indriya.format.QuantityFormat;

import javax.measure.Quantity;

/**
 * bITHackaton2018
 * Author: tsteidle
 * Created: 08.06.18
 */
public class ShoppingItem extends SalesItem {

    private Quantity quantity;

    public String getQuantity() {
        return QuantityFormat.getInstance().format(quantity);
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ShoppingItem{" +
                "name='" + this.getName() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                ", quantity='" + getQuantity() + '\'' +
                '}';
    }
}
