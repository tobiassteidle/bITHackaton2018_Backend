package de.bithackaton;

import de.bithackaton.ai.AStar;
import de.bithackaton.ai.MapUtils;
import de.bithackaton.ai.Node;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * bITHackaton2018
 * Author: tsteidle
 * Created: 09.06.18
 */
public class AStarTest {

    /*
        Testmap:
        5 * * * * * *
        4 * X * * * *
        3 * X X X X *
        2 S X * * * *
        1 * X * * * *
        0 * X * * * E
          0 1 2 3 4 5

        Start S (2, 0)
        Ende  E (0, 5)

        Geblock (X)
        Begehbar (*)
     */
    private static final String[][] NAVIGATION_MAP = {
            new String[] {"*", "*", "*", "*", "*", "*"},
            new String[] {"*", "X", "*", "*", "*", "*"},
            new String[] {"*", "X", "X", "X", "X", "*"},
            new String[] {"*", "X", "*", "*", "*", "*"},
            new String[] {"*", "X", "*", "*", "*", "*"},
            new String[] {"*", "X", "*", "*", "*", "*"}
    };


    @Test
    public void testMapBuilder() {
        final int [][] blocksArray = MapUtils.createBlockingArray(NAVIGATION_MAP);

        assertBlock(blocksArray[0], 4, 1);
        assertBlock(blocksArray[1], 3, 1);
        assertBlock(blocksArray[2], 3, 2);
        assertBlock(blocksArray[3], 3, 3);
        assertBlock(blocksArray[4], 3, 4);
        assertBlock(blocksArray[5], 2, 1);
        assertBlock(blocksArray[6], 1, 1);
        assertBlock(blocksArray[7], 0, 1);
    }

    @Test
    public void testAStar() {
        final int rows = 6;
        final int columns = 6;

        final Node initialNode = new Node(2, 0);
        final Node finalNode = new Node(0, 5);

        final AStar aStar = new AStar(rows, columns, initialNode, finalNode);
        final int[][] blocksArray = MapUtils.createBlockingArray(NAVIGATION_MAP);
        aStar.setBlocks(blocksArray);
        final List<Node> path = aStar.findPath();

        Assert.assertEquals(11, path.size());
        assertNode(path.get(0), 2, 0);
        assertNode(path.get(1), 3, 0);
        assertNode(path.get(2), 4, 0);
        assertNode(path.get(3), 5, 1);
        assertNode(path.get(4), 5, 2);
        assertNode(path.get(5), 5, 3);
        assertNode(path.get(6), 4, 4);
        assertNode(path.get(7), 3, 5);
        assertNode(path.get(8), 2, 5);
        assertNode(path.get(9), 1, 5);
        assertNode(path.get(10), 0, 5);
    }

    private void assertNode(final Node node, final int row, final int column) {
        Assert.assertEquals(row, node.getRow());
        Assert.assertEquals(column, node.getCol());
    }

    private void assertBlock(final int [] block, final int row, final int column) {
        Assert.assertEquals(row, block[0]);
        Assert.assertEquals(column, block[1]);
    }
}
