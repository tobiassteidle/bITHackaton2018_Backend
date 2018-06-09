package de.bithackaton.ai;

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
}
