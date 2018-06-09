package de.bithackaton.data;

import static tec.units.indriya.quantity.Quantities.getQuantity;
import static tec.units.indriya.unit.Units.GRAM;
import static tec.units.indriya.unit.Units.LITRE;
import static tec.units.indriya.unit.MetricPrefix.MILLI;

import de.bithackaton.model.NavigationMap;
import de.bithackaton.model.ShoppingItem;
import de.bithackaton.model.ShoppingCart;

import javax.measure.Quantity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.bithackaton.model.ShoppingList;

/**
 * bITHackaton2018
 * @author keilw
 * Created: 09.06.18
 */
public abstract class NavigationTestData {
    private static final Map<String, ShoppingItem> ITEM_REPOSITORY = new HashMap<>();

    static {
        ITEM_REPOSITORY.put("Butter",
                createItem("Butter", "Echt Bayrisch", getQuantity(250, GRAM)));
        ITEM_REPOSITORY.put("Waschmittel",
                createItem("Waschmittel", "Wäscht Weiss",getQuantity(500, MILLI(LITRE))));
    }

    public static NavigationMap getNavigation(ShoppingList list) {
        final NavigationMap navigationMap = new NavigationMap();
        navigationMap.setImageBase64("DUMMY");
        String[] listItems = list.getItems().split(",");
        final List<ShoppingItem> itemList = new ArrayList<>();
        for (String item: listItems
             ) {
            itemList.add(ITEM_REPOSITORY.get(item));
        }
        final ShoppingCart cart = new ShoppingCart();
        cart.setItems(itemList);
        cart.setCurrentLocation(list.getCurrentLocation());
        navigationMap.setShoppingCart(cart);
        return navigationMap;
}

    private static ShoppingItem createItem(String name, String description, Quantity quantity) {
        final ShoppingItem shoppingItem = new ShoppingItem();
        shoppingItem.setName(name);
        shoppingItem.setDescription(description);
        shoppingItem.setQuantity(quantity);
        return shoppingItem;
    }
}
