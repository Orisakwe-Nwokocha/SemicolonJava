package lemonLemon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LemonLemonTest {
    private LemonLemon game;

    @BeforeEach
    public void startWithThis() {
        game = new LemonLemon(39);
    }

    @Test
    public void testThatLemonLemonGameCanHavePlayers() {
        assertEquals(39, game.getPlayers().length);
    }

    @Test
    public void given39Players_whenPlayer27IsCalled_thenGameReturnsPlayer27() {
        assertEquals(39, game.getPlayers().length);
        Player player = game.getPlayer(27);

        assertNotNull(player);
        assertEquals(27, player.getId());
    }

    @Test
    public void testThatPlayerCanBeEliminated() {
        assertEquals(39, game.getPlayers().length);

        Player player = game.getPlayer(27);
        game.eliminatePlayer(player.getId());

        System.out.println(Arrays.toString(game.getPlayers()));

        assertTrue(player.isEliminated());
    }

    @Test
    public void testThatGameCanGenerate2RandomPlayerNumbers() {
        Player player = game.getPlayer(27);
        game.eliminatePlayer(player.getId());

        assertTrue(player.isEliminated());
    }

    @Test
    public void testThatGameCanGenerate2RandomActivePlayers() {
        int actual = game.generateTwoLemonNumbers().size();

        assertEquals(2, actual);
    }

    @Test
    public void testThatGameThrowsExceptionWhenActivePlayersIsLessThan4() {
        game = new LemonLemon(4);
        game.eliminatePlayer(1);

        assertThrows(IllegalStateException.class, ()-> game.generateTwoLemonNumbers());
    }

    @Test
    public void testThatPlayer1CanPlayTheGame() {
        Player playerOne = game.getPlayer(1);

        assertFalse(game.getPlayer(34).isEliminated());

        playerOne.play(game, 34);

        assertTrue(game.getPlayer(34).isEliminated());
    }

    @Test
    public void testThatGameCanDetermineWinners() {
        game = new LemonLemon(6);
        Player playerOne = game.getPlayer(1);

        playerOne.play(game, 2);
        playerOne.play(game, 6);
        playerOne.play(game, 5);
        playerOne.play(game, 3);

        Player[] expectedWinners = {game.getPlayer(1), game.getPlayer(4)};
        Player[] actualWinners = game.getWinners();

        assertArrayEquals(expectedWinners, actualWinners);
        System.out.println(game.getEliminatedPlayers());
    }
}
