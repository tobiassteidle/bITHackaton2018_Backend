package de.bithackaton.image;

import de.bithackaton.ai.AStar;
import de.bithackaton.ai.MapUtils;
import de.bithackaton.ai.Node;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;

/**
 * bITHackaton2018
 * Author: tsteidle
 * Created: 09.06.18
 */
public class ImageTest {

    private static final BasicStroke BASIC_STROKE = new BasicStroke(1);
    private static final Color GRID_COLOR = Color.RED;
    private static final int GRID_SIZE = 1;

    @Test
    @Ignore
    public void prepareImage() throws Exception {
        final BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/navigation_map.bmp"));
        final int[][] blocksArray = MapUtils.imageToBlockingArray(getClass().getResourceAsStream("/navigation_map.bmp"));

        final Node initialNode = new Node(2, 2);
        final Node finalNode = new Node(0, 158);

        final AStar aStar = new AStar(image.getHeight(), image.getWidth(), initialNode, finalNode, 10, 140);
        aStar.setBlocks(blocksArray);
        final List<Node> path = aStar.findPath();

        final Graphics2D graphics2D = image.createGraphics();
        graphics2D.setColor(Color.RED);
        graphics2D.setStroke(BASIC_STROKE);
        for(final Node node : path) {
            graphics2D.fillRect(node.getCol(), image.getHeight() - node.getRow(), 1, 1);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "bmp", bos );
        byte [] data = bos.toByteArray();
        System.out.println(Base64Utils.encodeToString(data));

        // FIXME das sollte ein relativer Pfad sein, so bekomme ich natuerlich eine NPE
        ImageIO.write(image, "bmp", new File("/Users/tsteidle/Documents/Entwicklung/bITHackaton2018/src/test/resources/grid_map.bmp"));
    }
}
