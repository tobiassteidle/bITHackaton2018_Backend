package de.bithackaton.model;

/**
 * bITHackaton2018
 * Created: 08.06.18
 * @author tsteidle
 * @author keilw
 */
public class NavigationMap {

    private String imageBase64;
    private ShoppingCart shoppingList;

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingList;
    }

    public void setShoppingCart(ShoppingCart shoppingList) {
        this.shoppingList = shoppingList;
    }
}
