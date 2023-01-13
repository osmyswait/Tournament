import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public  void testWhenFirstPlayerIsStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 30);
        Player player2 = new Player(2, "Jim", 25);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Tom", "Jim");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public  void testWhenSecondPlayerIsStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 25);
        Player player2 = new Player(2, "Jim", 30);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Tom", "Jim");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public  void testWhenPlayersStrongerIsEqual() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 30);
        Player player2 = new Player(2, "Jim", 30);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Tom", "Jim");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public  void testWhenFirstPlayerIsNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 30);
        Player player2 = new Player(2, "Jim", 30);

        game.register(player2);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Tom", "Jim"));
    }

    @Test
    public  void testWhenSecondPlayerIsNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 30);
        Player player2 = new Player(2, "Jim", 30);

        game.register(player1);



        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Tom", "Jim"));
    }

    @Test
    public  void testWhenPlayersIsNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 30);
        Player player2 = new Player(2, "Jim", 30);
        

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Tom", "Jim"));
    }

}