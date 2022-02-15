package guess.number.component.console;

import guess.number.component.DataPrinter;
import guess.number.component.Input;

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
            if (number >= 0 && number <= 9){
                return number;
            } else {
                dataPrinter.printErrorMessage("Number " + number + " is wrong!");
                dataPrinter.printInstructions();
            }

        }
    }

}
