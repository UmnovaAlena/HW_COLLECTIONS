import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenFirstPlayerWin() {
        Player petya = new Player(1, "Петя", 150);
        Player vasya = new Player(2, "Вася", 100);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        int expected = 1;
        int actual = game.round("Петя", "Вася");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Player petya = new Player(1, "Петя", 120);
        Player vasya = new Player(2, "Вася", 140);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        int expected = 2;
        int actual = game.round("Петя", "Вася");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenPlayerNoWin() {
        Player petya = new Player(1, "Петя", 200);
        Player vasya = new Player(2, "Вася", 200);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        int expected = 0;
        int actual = game.round("Петя", "Вася");

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testWhenFirstPlayerNotExist() {
        Player vasya = new Player(1, "Вася", 100);
        Player petya = new Player(2, "Петя", 120);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Саша", "Вася")
        );

    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player vasya = new Player(1, "Вася", 100);
        Player petya = new Player(2, "Петя", 120);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Петя", "Юра")
        );

    }

}
