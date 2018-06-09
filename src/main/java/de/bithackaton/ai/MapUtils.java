package de.bithackaton.ai;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * bITHackaton2018
 * Author: tsteidle
 * Created: 09.06.18
 */
public class MapUtils {

    private final static String BLOCK = "X";

    public static int[][] createBlockingArray(final String[][] map) {
        final List<int[]> resultList = new ArrayList<>();

        for(int row = 0; row < map.length; row++) {
            for(int column = 0; column < map[row].length; column++) {
                if(BLOCK.compareToIgnoreCase(map[row][column]) == 0) {
                    resultList.add(new int[] {map.length - row - 1, column});
                }
            }
        }

        return resultList.toArray(new int[map.length][map.length]);
    }

    public static int[][] imageToBlockingArray(final InputStream inputStream) throws IOException {
        final BufferedImage image = ImageIO.read(inputStream);
        final String [][] asciiMap = new String[image.getHeight()][image.getWidth()];

        for(int x = 0; x < image.getWidth(); x++) {
            for(int y = 0; y < image.getHeight(); y++) {
                final int color = image.getRGB(x, y);
                asciiMap[y][x] = color == -1 ? "*" : "X";
            }
        }

        return createBlockingArray(asciiMap);
    }

    public void printMap(final InputStream inputStream) throws IOException {
        final BufferedImage image = ImageIO.read(inputStream);
        final String [][] asciiMap = new String[image.getHeight()][image.getWidth()];

        for(int x = 0; x < image.getWidth(); x++) {
            for(int y = 0; y < image.getHeight(); y++) {
                final int color = image.getRGB(x, y);
                asciiMap[y][x] = color == -1 ? "*" : "X";
            }
        }

        for(int x = 0; x < asciiMap.length; x++) {
            for(int y = 0; y < asciiMap[x].length; y++) {

                System.out.print(asciiMap[x][y]);
            }
            System.out.println("\n");
        }

    }

}
