package org.mahjong4j.hands;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mahjong4j.tile.MahjongTile.*;

/**
 * @author yu1ro
 */
public class MahjongHandsChitoitsuTest {
    private MahjongHands actual;

    @Before
    public void setUp() throws Exception {
        int[] tiles = {
            2, 2, 0, 2, 2, 0, 2, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 2, 0, 0, 0, 0, 0, 0,
            0, 0, 2, 0,
            0, 0, 0
        };

        actual = new MahjongHands(tiles, SHA);
    }

    @Test
    public void testGetMentsuCompList() throws Exception {
        List<MahjongMentsu> expectedList = new ArrayList<>(7);
        expectedList.add(new Toitsu(M4));
        expectedList.add(new Toitsu(SHA));
        expectedList.add(new Toitsu(M2));
        expectedList.add(new Toitsu(M1));
        expectedList.add(new Toitsu(M7));
        expectedList.add(new Toitsu(S3));
        expectedList.add(new Toitsu(M5));

        MentsuComp expected = new MentsuComp(expectedList, SHA);

        assertEquals(1, actual.getMentsuCompList().size());
        assertEquals(expected, actual.getMentsuCompList().get(0));
    }

    @Test
    public void testGetCanWin() throws Exception {
        assertTrue(actual.getCanWin());
    }

    @Test
    public void testGetLast() throws Exception {
        assertEquals(SHA, actual.getLast());
    }

    @Test
    public void testGetHandsComp() throws Exception {
        int[] expected = {
            2, 2, 0, 2, 2, 0, 2, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 2, 0, 0, 0, 0, 0, 0,
            0, 0, 2, 0,
            0, 0, 0
        };

        assertArrayEquals(expected, actual.getHandsComp());
    }
}