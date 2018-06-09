package de.bithackaton.ai;

import de.bithackaton.model.SalesItem;

/**
 * bITHackaton2018
 * Author: tsteidle
 * Created: 09.06.18
 */
public class SalesItemNode extends Node {

    private final SalesItem salesItem;

    public SalesItemNode(final SalesItem salesItem, final int x, final int y) {
        super(y, x);
        this.salesItem = salesItem;
    }

    public SalesItem getSalesItem() {
        return salesItem;
    }
}
