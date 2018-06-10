package de.bithackaton.model;

import tech.units.indriya.format.SimpleQuantityFormat;

import javax.measure.Quantity;

/**
 * bITHackaton2018
 * Created: 08.06.18
 * @author tsteidle
 * @author keilw
 */
public class PackagedItem extends SalesItem {

    private Quantity quantity;

    public String getQuantity() {
        return SimpleQuantityFormat.getInstance().format(quantity);
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PackagedItem{" +
                "name='" + this.getName() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                ", quantity='" + getQuantity() + '\'' +
                '}';
    }
}
