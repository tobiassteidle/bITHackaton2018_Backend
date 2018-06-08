package de.bithackaton.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import de.bithackaton.model.NavigationMap;
import de.bithackaton.model.ShoppingItem;
import de.bithackaton.model.ShoppingList;
import org.geojson.Point;
import org.springframework.web.bind.annotation.*;

@RestController
public class NavigationController {

    @RequestMapping(value = "/navigate", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    @CrossOrigin
    public NavigationMap navigate(@RequestBody ShoppingList shoppingList) throws Exception {
        final NavigationMap navigationMap = new NavigationMap();
        navigationMap.setImageBase64("DUMMY");

        final List<ShoppingItem> itemList = new ArrayList<>();
        itemList.add(createItem("Butter", "Ziemlich Fettig"));
        itemList.add(createItem("Waschmittel", "Sehr giftig"));
        navigationMap.setShoppingItems(itemList);
        return navigationMap;
    }

    private ShoppingItem createItem(String name, String description) {
        final ShoppingItem shoppingItem = new ShoppingItem();
        shoppingItem.setName(name);
        shoppingItem.setDescription(description);
        return shoppingItem;
    }

}