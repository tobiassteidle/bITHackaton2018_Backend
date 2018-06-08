package de.bithackaton.model;

import java.util.List;

/**
 * bITHackaton2018
 * Author: tsteidle
 * Created: 08.06.18
 */
public class NavigationMap {

    private String imageBase64;
    private List<ShoppingItem> shoppingItems;

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public List<ShoppingItem> getShoppingItems() {
        return shoppingItems;
    }

    public void setShoppingItems(List<ShoppingItem> shoppingItems) {
        this.shoppingItems = shoppingItems;
    }
}
