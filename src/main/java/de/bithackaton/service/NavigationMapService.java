package de.bithackaton.service;

import de.bithackaton.model.NavigationMap;
import de.bithackaton.model.ShoppingList;

import java.io.IOException;

public interface NavigationMapService {

	NavigationMap createNavigationMap(final ShoppingList shoppingList) throws IOException;
	
}
