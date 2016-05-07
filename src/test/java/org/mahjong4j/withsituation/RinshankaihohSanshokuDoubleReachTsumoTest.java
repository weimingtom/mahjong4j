package org.mahjong4j.withsituation;

import org.junit.Before;
import org.junit.Test;
import org.mahjong4j.GeneralSituation;
import org.mahjong4j.Player;
import org.mahjong4j.PersonalSituation;
import org.mahjong4j.hands.Kantsu;
import org.mahjong4j.hands.MahjongHands;
import org.mahjong4j.tile.MahjongTile;
import org.mahjong4j.yaku.normals.MahjongYakuEnum;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;
import static org.mahjong4j.Score.SCORE12000;
import static org.mahjong4j.tile.MahjongTile.*;
import static org.mahjong4j.yaku.normals.MahjongYakuEnum.*;

/**
 * @author yu1ro
 */
public class RinshankaihohSanshokuDoubleReachTsumoTest {
    private Player player;

    @Before
    public void setUp() throws Exception {
        int[] tiles = {
            0, 0, 0, 0, 0, 0, 1, 1, 1,
            0, 0, 0, 0, 0, 0, 1, 1, 1,
            0, 0, 2, 0, 0, 0, 1, 1, 1,
            0, 0, 0, 0,
            0, 0, 0
        };
        MahjongTile last = M9;
        MahjongHands hands = new MahjongHands(tiles, last, new Kantsu(false, TON));
        List<MahjongTile> dora = new ArrayList<>(1);
        dora.add(CHN);

        List<MahjongTile> uradora = new ArrayList<>(1);
        uradora.add(M2);
        GeneralSituation general;
        general = new GeneralSituation(false, false, SHA, dora, uradora);
        PersonalSituation personal;
        personal = new PersonalSituation(false, true, false, true, true, false, true, NAN);

        player = new Player(hands, general, personal);
        player.calculate();
    }

    @Test
    public void testGetNormalYakuListSize() throws Exception {
        List<MahjongYakuEnum> actual = player.getNormalYakuList();

        assertEquals(5, actual.size());
    }

    @Test
    public void testGetNormalYakuListItem() throws Exception {
        List<MahjongYakuEnum> actual = player.getNormalYakuList();

        assertThat(actual, hasItems(RINSHANKAIHOH, SANSHOKUDOHJUN, REACH, DOUBLE_REACH, TSUMO));
    }

    @Test
    public void testGetHan() throws Exception {
        assertEquals(6, player.getHan());
    }

    @Test
    public void testGetFu() throws Exception {
        assertEquals(54, player.getFu());
    }

    @Test
    public void testGetScore() throws Exception {
        assertEquals(SCORE12000, player.getScore());
    }
}