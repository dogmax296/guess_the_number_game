package guess_the_number.component.console;

import guess_the_number.component.DataPrinter;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class ConsoleDataPrinter implements DataPrinter {

    @Override
    public void printInfoMessage(final String string) {
        System.out.println(string);
    }

    @Override
    public void printInstructions() {
        printInfoMessage("Please type a number between 0 and 9:");
    }
}
