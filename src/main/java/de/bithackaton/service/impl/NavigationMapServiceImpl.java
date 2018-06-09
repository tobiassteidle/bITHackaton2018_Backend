package de.bithackaton.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.bithackaton.data.SalesItemsRepository;
import de.bithackaton.model.NavigationMap;
import de.bithackaton.model.SalesItem;
import de.bithackaton.model.ShoppingCart;
import de.bithackaton.model.ShoppingList;
import de.bithackaton.service.NavigationMapService;

@Service
public class NavigationMapServiceImpl implements NavigationMapService {

	@Autowired
	private SalesItemsRepository salesItemsRepository;
	
	@Override
	public NavigationMap createNavigationMap(final ShoppingList shoppingList) {
		if(shoppingList != null) {
			final NavigationMap navigationMap = new NavigationMap();
			final ShoppingCart shoppingCart = new ShoppingCart();
			final List<SalesItem> salesItems = new ArrayList<>();
			
			shoppingCart.setItems(salesItems);
			shoppingCart.setCurrentLocation(shoppingCart.getCurrentLocation());
			navigationMap.setShoppingCart(shoppingCart);
			
			final String[] items = shoppingList.getItems().split(",");		
			
			for(final String item : items) {
				final SalesItem salesItem = this.salesItemsRepository.getSalesItemForName(item);
				salesItems.add(salesItem);
			}

			//TODO: MapService von Tobias einbauen!
			
			return navigationMap;
		}
		
		return null;
	}

}
