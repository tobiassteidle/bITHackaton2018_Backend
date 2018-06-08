package de.bithackaton.model;

import org.geojson.Point;

import java.util.List;

/**
 * bITHackaton2018
 * Author: tsteidle
 * Created: 08.06.18
 */
public class ShoppingList {

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }

    private Point currentLocation;

    public List<ShoppingItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingItem> items) {
        this.items = items;
    }

    private List<ShoppingItem> items;
}
