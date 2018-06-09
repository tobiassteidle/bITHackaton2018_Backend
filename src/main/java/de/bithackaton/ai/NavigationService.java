package de.bithackaton.ai;

import de.bithackaton.model.NavigationMap;
import de.bithackaton.model.SalesItem;
import org.geojson.LngLatAlt;
import org.geojson.Point;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * bITHackaton2018
 * Author: tsteidle
 * Created: 09.06.18
 */
@Service
public class NavigationService {

    private static final String NAVIGATION_MAP = "/navigation_map.bmp";

    private int image_rows;
    private int image_columns;
    private int [][] navigationMapBlockingArray;

    @PostConstruct
    public void initialize() throws IOException {
        final BufferedImage image = ImageIO.read(getClass().getResourceAsStream(NAVIGATION_MAP));
        this.image_rows = image.getHeight();
        this.image_columns = image.getWidth();
        this.navigationMapBlockingArray = MapUtils.imageToBlockingArray(getClass().getResourceAsStream(NAVIGATION_MAP));
    }

    public NavigationMap buildNavigationMap(final Point currentPosition, final List<SalesItem> salesItems) {
        final List<SalesItemNode> navigateList = new ArrayList<>();

        // Start with currentPostion
        LngLatAlt lngLatAlt = currentPosition.getCoordinates();
        Node currentPostion = new Node((int)lngLatAlt.getLongitude(), (int)lngLatAlt.getLatitude());

        while(!salesItems.isEmpty()) {
            final SalesItemNode currentNode = getClosestSalesItemNode(currentPosition, salesItems);
            if(currentNode != null) {
                salesItems.remove(currentNode.getSalesItem());
                navigateList.add(currentNode);

                currentPostion = new Node(currentNode.getRow(), currentNode.getCol());
            }
        }

        return null;
    }

    private SalesItemNode getClosestSalesItemNode(final Point currentPosition, final List<SalesItem> salesItems) {
        final LngLatAlt lngLatAlt = currentPosition.getCoordinates();
        final Node currentPostion = new Node((int)lngLatAlt.getLongitude(), (int)lngLatAlt.getLatitude());

        int shortest_path = 999999;
        SalesItemNode resultNode = null;

        for(final SalesItem salesItem : salesItems) {
            final LngLatAlt itemLngLatAlt = salesItem.getPoint().getCoordinates();
            final SalesItemNode targetNode = new SalesItemNode(salesItem, (int)itemLngLatAlt.getLatitude(), (int)itemLngLatAlt.getLongitude());

            final AStar aStar = new AStar(this.image_rows, image_columns, currentPostion, targetNode, 10, 140);
            aStar.setBlocks(this.navigationMapBlockingArray);
            final List<Node> path = aStar.findPath();
            if(path.size() < shortest_path) {
                shortest_path = path.size();
                resultNode = targetNode;
            }
        }

        return resultNode;
    }


}
