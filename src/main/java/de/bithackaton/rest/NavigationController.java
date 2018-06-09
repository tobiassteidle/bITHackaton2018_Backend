package de.bithackaton.rest;

import de.bithackaton.model.NavigationMap;
import de.bithackaton.model.ShoppingList;
import org.springframework.web.bind.annotation.*;

import static de.bithackaton.data.NavigationTestData.getNavigation;

@RestController
public class NavigationController {

    @RequestMapping(value = "/navigate", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    @CrossOrigin
    public NavigationMap navigate(@RequestBody ShoppingList shoppingList) throws Exception {
        System.out.println(shoppingList);
        final NavigationMap navigationMap = getNavigation(shoppingList);
        return navigationMap;
    }
}