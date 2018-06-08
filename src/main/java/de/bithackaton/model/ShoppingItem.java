package de.bithackaton.model;

import tec.units.indriya.format.QuantityFormat;

import javax.measure.Quantity;

/**
 * bITHackaton2018
 * Author: tsteidle
 * Created: 08.06.18
 */
public class ShoppingItem {

    private String name;
    private String description;
    private Quantity quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return QuantityFormat.getInstance().format(quantity);
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ShoppingItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity='" + getQuantity() + '\'' +
                '}';
    }
}
