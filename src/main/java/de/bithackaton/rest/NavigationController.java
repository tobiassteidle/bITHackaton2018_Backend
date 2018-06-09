package de.bithackaton.rest;

import de.bithackaton.data.SalesItemsRepository;
import de.bithackaton.model.NavigationMap;
import de.bithackaton.model.SalesItem;
import de.bithackaton.model.ShoppingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static de.bithackaton.data.NavigationTestData.getNavigation;

@RestController
public class NavigationController {

    @Autowired
    private SalesItemsRepository salesItemsRepository;

    @RequestMapping("/salesitems")
    public List<SalesItem> salesitems() {
        return salesItemsRepository.getSalesItems();
    }

    @RequestMapping(value = "/navigate", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    @CrossOrigin
    public NavigationMap navigate(@RequestBody ShoppingList shoppingList) throws Exception {
        System.out.println(shoppingList);
        final NavigationMap navigationMap = getNavigation(shoppingList);
        return navigationMap;
    }
}