package de.bithackaton.rest;

import java.util.concurrent.atomic.AtomicLong;

import de.bithackaton.model.NavigationMap;
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
        return navigationMap;
    }

}