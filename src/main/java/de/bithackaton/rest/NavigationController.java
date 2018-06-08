package de.bithackaton.rest;

import static tec.units.indriya.quantity.Quantities.getQuantity;
import static tec.units.indriya.unit.Units.GRAM;
import static tec.units.indriya.unit.Units.LITRE;
import static tec.units.indriya.unit.MetricPrefix.MILLI;

import java.util.ArrayList;
import java.util.List;

import de.bithackaton.model.NavigationMap;
import de.bithackaton.model.ShoppingItem;
import de.bithackaton.model.ShoppingList;
import org.geojson.Point;
import org.springframework.web.bind.annotation.*;

import javax.measure.Quantity;

@RestController
public class NavigationController {

    @RequestMapping(value = "/navigate", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    @CrossOrigin
    public NavigationMap navigate(@RequestBody ShoppingList shoppingList) throws Exception {
        final NavigationMap navigationMap = new NavigationMap();
        navigationMap.setImageBase64("DUMMY");

        final List<ShoppingItem> itemList = new ArrayList<>();
        itemList.add(createItem("Butter", "Echt Bayrisch", getQuantity(100, GRAM)));
        itemList.add(createItem("Waschmittel", "Wäscht Weiss",getQuantity(250, MILLI(LITRE))));
        final ShoppingList list = new ShoppingList();
        list.setItems(itemList);
        list.setCurrentLocation(new Point(1, 2));
        navigationMap.setShoppingList(list);
        return navigationMap;
    }

    private ShoppingItem createItem(String name, String description, Quantity quantity) {
        final ShoppingItem shoppingItem = new ShoppingItem();
        shoppingItem.setName(name);
        shoppingItem.setDescription(description);
        shoppingItem.setQuantity(quantity);
        return shoppingItem;
    }

}