package de.bithackaton.model;

import org.geojson.Point;

/**
 * bITHackaton2018
 * Author: tsteidle
 * Created: 09.06.18
 */
public class SalesItem {

    private String name;
    private String description;
    private Point point;

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

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
