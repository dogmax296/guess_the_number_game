package guess_the_number;

import guess.number.component.*;
import guess.number.component.console.ConsoleDataPrinter;
import guess.number.component.console.ConsoleGameOverHandler;
import guess.number.component.console.ConsoleUserInput;
import guess.number.component.swing.GameWindow;
import guess.number.component.сonfig.CommandLineArgumentParser;
import guess.number.model.config.UserInterface;

import static guess.number.component.сonfig.CommandLineArgumentParser.CommandLineArguments;
import static guess.number.model.config.UserInterface.GUI;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class GameFactory {
    private final UserInterface userInterface;

    public GameFactory(final String[] args) {
        final CommandLineArguments commandLineArguments = new CommandLineArgumentParser(args).parse();
        this.userInterface = commandLineArguments.getUserInterface();
    }

    public Game create() {
        final DataPrinter dataPrinter;
        final Input computerInput = new GuessGenerator();
        final Input userInput;
        final GameOverHandler gameOverHandler;

        if (userInterface == GUI) {
            final GameWindow gameWindow = new GameWindow();
            dataPrinter = gameWindow;
            userInput = gameWindow;
            gameOverHandler = gameWindow;
        } else {
            dataPrinter = new ConsoleDataPrinter();
            userInput = new ConsoleUserInput(dataPrinter);
            gameOverHandler = new ConsoleGameOverHandler(dataPrinter);
        }

        return new Game(
                dataPrinter,
                computerInput,
                userInput,
                gameOverHandler
        );
    }
}
