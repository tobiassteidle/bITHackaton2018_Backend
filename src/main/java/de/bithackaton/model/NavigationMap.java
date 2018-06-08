package de.bithackaton.model;

import java.util.List;

/**
 * bITHackaton2018
 * Created: 08.06.18
 * @author tsteidle
 * @author keilw
 */
public class NavigationMap {

    private String imageBase64;
    private ShoppingList shoppingList;

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }
}
