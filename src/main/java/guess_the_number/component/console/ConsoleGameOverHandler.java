package guess_the_number.component.console;

import guess_the_number.component.DataPrinter;
import guess_the_number.component.GameOverHandler;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class ConsoleGameOverHandler implements GameOverHandler {
    private final DataPrinter dataPrinter;

    public ConsoleGameOverHandler(final DataPrinter dataPrinter) {
        this.dataPrinter = dataPrinter;
    }

    @Override
    public void gameOver() {
        dataPrinter.printInfoMessage("GAME OVER!");
    }
}
