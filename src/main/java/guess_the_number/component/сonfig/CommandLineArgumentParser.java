package guess_the_number.component.сonfig;

import guess_the_number.model.config.UserInterface;

import static guess_the_number.model.config.UserInterface.CONSOLE;
import static guess_the_number.model.config.UserInterface.GUI;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class CommandLineArgumentParser {

    final String[] args;

    public CommandLineArgumentParser(final String[] args) {
        this.args = args;
    }

    public CommandLineArguments parse() {
        UserInterface userInterface = null;

        for (final String arg : args) {
            if (CONSOLE.name().equalsIgnoreCase(arg) || GUI.name().equalsIgnoreCase(arg)) {
                if (userInterface == null) {
                    userInterface = UserInterface.valueOf(arg.toUpperCase());
                }
            } else {
                System.err.printf(
                        "Unsupported command line argument: '%s'%n",
                        arg);
            }
        }

        if(userInterface == null){
            userInterface = CONSOLE;
        }

        return new CommandLineArguments(userInterface);
    }

    public static class CommandLineArguments {
        private final UserInterface userInterface;

        public CommandLineArguments(final UserInterface userInterface) {
            this.userInterface = userInterface;
        }

        public UserInterface getUserInterface() {
            return userInterface;
        }
    }
}
