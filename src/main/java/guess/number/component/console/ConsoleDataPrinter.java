package guess.number.component.console;

import guess.number.component.DataPrinter;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class ConsoleDataPrinter implements DataPrinter {

    @Override
    public void printErrorMessage(final String string) {
        System.err.println(string);
    }

    @Override
    public void printInfoMessage(final String string) {
        System.out.println(string);
    }

    @Override
    public void printInstructions() {
        printInfoMessage("Please type a number between 0 and 9:");
    }
}
