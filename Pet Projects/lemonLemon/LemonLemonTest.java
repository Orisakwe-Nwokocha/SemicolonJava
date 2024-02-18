package lemonLemon;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LemonLemonTest {

    @Test
    public void testThatLemonLemonGameCanHavePlayers() {
        LemonLemon game = new LemonLemon(39);

        assertEquals(39, game.getPlayers().length);
    }

    @Test
    public void given39Players_whenPlayer27IsCalled_thenGameReturnsPlayer27() {
        LemonLemon game = new LemonLemon(39);
        assertEquals(39, game.getPlayers().length);

        Player player = game.getPlayer(27);
        assertNotNull(player);
        assertEquals(27, player.getId());
    }

    @Test
    public void testThatPlayerCanBeEliminated() {
        LemonLemon game = new LemonLemon(39);
        assertEquals(39, game.getPlayers().length);

        Player player = game.getPlayer(27);
        game.eliminatePlayer(player.getId());

        System.out.println(Arrays.toString(game.getPlayers()));

        assertTrue(player.isElimanted());
    }

    @Test
    public void testThatGameCanGenerate2RandomPlayerNumbers() {
        LemonLemon game = new LemonLemon(39);


        Player player = game.getPlayer(27);
        game.eliminatePlayer(player.getId());

        assertTrue(player.isElimanted());
    }
}
