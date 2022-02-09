package guess_the_number.component.gui;

import guess_the_number.component.DataPrinter;
import guess_the_number.component.GameOverHandler;
import guess_the_number.component.Input;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class GameWindow implements DataPrinter, Input, GameOverHandler {
    @Override
    public void printInstructions() {

    }

    @Override
    public void printInfoMessage(final String s) {

    }

    @Override
    public void gameOver() {

    }

    @Override
    public int guess() {
        return 0;
    }
}
