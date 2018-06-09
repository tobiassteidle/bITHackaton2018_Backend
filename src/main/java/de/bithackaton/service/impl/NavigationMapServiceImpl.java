package de.bithackaton.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.bithackaton.ai.NavigationService;
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

	@Autowired
	private NavigationService navigationService;
	
	@Override
	public NavigationMap createNavigationMap(final ShoppingList shoppingList) throws IOException {
		if(shoppingList != null) {
			final List<SalesItem> salesItems = new ArrayList<>();
			final String[] items = shoppingList.getItems().split(",");		
			
			for(final String item : items) {
				final SalesItem salesItem = this.salesItemsRepository.getSalesItemForName(item);
				
				if(salesItem != null) {
					salesItems.add(salesItem);
				}
			}

			//TODO: MapService von Tobias einbauen!
			final NavigationMap navigationMap = this.navigationService.buildNavigationMap(shoppingList.getCurrentLocation() ,salesItems);
			return navigationMap;
		}
		
		return null;
	}

}
