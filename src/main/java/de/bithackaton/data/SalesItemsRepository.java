package de.bithackaton.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.bithackaton.model.SalesItem;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * bITHackaton2018
 * Author: tsteidle
 * Created: 09.06.18
 */
@Repository
public class SalesItemsRepository {

    private List<SalesItem> salesItems;

    @PostConstruct
    public void loadSalesItems() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final InputStream inputStream = this.getClass().getResourceAsStream("/salesItems.json");
        this.salesItems = objectMapper.readValue(inputStream, new TypeReference<List<SalesItem>>(){});
    }

    public SalesItem getSalesItemForName(final String salesItemName) {
    	for(final SalesItem salesItem : this.salesItems) {
    		if(salesItem.getName().equals(salesItemName)) {
    			return salesItem;
    		}
    	}
    	
    	return null;
    }
    
    public List<SalesItem> getSalesItems() {
        return salesItems;
    }
}
