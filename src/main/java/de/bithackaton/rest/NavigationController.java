package de.bithackaton.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.bithackaton.data.SalesItemsRepository;
import de.bithackaton.model.NavigationMap;
import de.bithackaton.model.SalesItem;
import de.bithackaton.model.ShoppingList;
import de.bithackaton.service.NavigationMapService;

@RestController
public class NavigationController {

    @Autowired
    private SalesItemsRepository salesItemsRepository;

    @Autowired
    private NavigationMapService navigationMapService;
    
    @RequestMapping("/salesitems")
    public List<SalesItem> salesitems() {
        return salesItemsRepository.getSalesItems();
    }

    @RequestMapping(value = "/navigate", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    @CrossOrigin
    public NavigationMap navigate(@RequestBody ShoppingList shoppingList) throws Exception {
        final NavigationMap navigationMap = this.navigationMapService.createNavigationMap(shoppingList);
        return navigationMap;
    }
}