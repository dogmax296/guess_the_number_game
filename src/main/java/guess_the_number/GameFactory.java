package guess_the_number;

import guess_the_number.component.DataPrinter;
import guess_the_number.component.Game;
import guess_the_number.component.GameOverHandler;
import guess_the_number.component.Input;
import guess_the_number.component.console.ConsoleDataPrinter;
import guess_the_number.component.console.ConsoleGameOverHandler;
import guess_the_number.component.console.ConsoleUserInput;
import guess_the_number.component.gui.GameWindow;
import guess_the_number.component.сonfig.CommandLineArgumentParser;
import guess_the_number.model.config.UserInterface;

import static guess_the_number.component.сonfig.CommandLineArgumentParser.*;
import static guess_the_number.model.config.UserInterface.GUI;

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

    public Game create(){
        final DataPrinter dataPrinter;
        final Input userInput;
        final GameOverHandler gameOverHandler;

        if(userInterface == GUI){
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
                userInput,
                gameOverHandler
        );
    }
}
