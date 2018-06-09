package de.bithackaton.service;

import de.bithackaton.model.NavigationMap;
import de.bithackaton.model.ShoppingList;

public interface NavigationMapService {

	NavigationMap createNavigationMap(final ShoppingList shoppingList);
	
}
