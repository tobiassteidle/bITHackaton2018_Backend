package de.bithackaton.model;

import org.geojson.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * bITHackaton2018
 * @author keilw
 * Created: 09.06.18
 */
public class ShoppingCart {

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }

    private Point currentLocation;

    public List<SalesItem> getItems() {
        return items;
    }

    public void setItems(List<SalesItem> items) {
        this.items = items;
    }

    private List<SalesItem> items;

    public void addItem(SalesItem salesItem) {
        if(this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(salesItem);
    }
}
