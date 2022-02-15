package guess.number.component;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class Game {
    private final DataPrinter dataPrinter;
    private final Input computerInput;
    private final Input userInput;
    private final GameOverHandler gameOverHandler;

    public Game(final DataPrinter dataPrinter, final Input computerInput, final Input userInput, final GameOverHandler gameOverHandler) {
        this.dataPrinter = dataPrinter;
        this.computerInput = computerInput;
        this.userInput = userInput;
        this.gameOverHandler = gameOverHandler;

    }

    public void play(){
        dataPrinter.printInstructions();
        int computerNumber = computerInput.guess();
        while (true){
            int userNumber = userInput.guess();
            if(computerNumber > userNumber){
                dataPrinter.printInfoMessage("number > " + userNumber + ". Try again:");
            } else if(computerNumber < userNumber){
                dataPrinter.printInfoMessage("number < " + userNumber + ". Try again:");
            } else {
                dataPrinter.printInfoMessage("Congratulations, you guessed the number!");
                break;
            }
        }
        gameOverHandler.gameOver();
    }

}
