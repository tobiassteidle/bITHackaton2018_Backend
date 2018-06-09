package de.bithackaton.ai;

import de.bithackaton.model.SalesItem;
import org.geojson.LngLatAlt;
import org.geojson.Point;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
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
    private static final BasicStroke BASIC_STROKE = new BasicStroke(1);

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

    public String buildNavigationMap(final Point currentPosition, final List<SalesItem> salesItems) throws IOException {
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

        lngLatAlt = currentPosition.getCoordinates();
        Node targetPosition = new Node((int)lngLatAlt.getLongitude(), (int)lngLatAlt.getLatitude());

        final List<Node> completeNavigationNodes = new ArrayList<>();
        for(final SalesItemNode itemNode : navigateList) {
            final List<Node> nodes = pointToPointNavigation(targetPosition, itemNode);
            targetPosition = itemNode;
            completeNavigationNodes.addAll(nodes);
        }

        final BufferedImage image = ImageIO.read(getClass().getResourceAsStream(NAVIGATION_MAP));
        final Graphics2D graphics2D = image.createGraphics();
        graphics2D.setColor(Color.RED);
        graphics2D.setStroke(BASIC_STROKE);
        for(final Node node : completeNavigationNodes) {
            graphics2D.fillRect(node.getCol(), image.getHeight() - node.getRow(), 1, 1);
        }

      //  ImageIO.write(image, "bmp", new File("/Users/tsteidle/Documents/Entwicklung/bITHackaton2018/src/test/resources/grid_map.bmp"));

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "bmp", bos );
        final byte [] data = bos.toByteArray();
        return Base64Utils.encodeToString(data);
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

    private List<Node> pointToPointNavigation(final Node currentPosition, SalesItemNode target) {
        final AStar aStar = new AStar(this.image_rows, image_columns, currentPosition, target, 10, 140);
        aStar.setBlocks(this.navigationMapBlockingArray);
        return aStar.findPath();
    }
}
