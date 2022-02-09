package guess_the_number.component.console;

import guess_the_number.component.DataPrinter;
import guess_the_number.component.Input;

import java.util.Scanner;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class ConsoleUserInput implements Input {

    private final DataPrinter dataPrinter;

    public ConsoleUserInput(final DataPrinter dataPrinter) {
        this.dataPrinter = dataPrinter;
    }

    @Override
    public int guess() {
        while (true) {
            int number = new Scanner(System.in).nextInt();
            if (number < 0) {
                dataPrinter.printInfoMessage("number < " + number + ". Try again:");
            } else if (number > 9) {
                dataPrinter.printInfoMessage("number > " + number + ". Try again:");
            } else {
                return number;
            }
        }
    }

}
