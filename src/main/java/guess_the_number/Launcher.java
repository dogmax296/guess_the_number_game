package guess_the_number;

import guess_the_number.component.Game;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class Launcher {
    public static void main(final String[] args) {
        final GameFactory gameFactory = new GameFactory(args);
        final Game game = gameFactory.create();
        game.play();
    }
}
