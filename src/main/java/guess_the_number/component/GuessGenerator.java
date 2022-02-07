package guess_the_number.component;

import java.util.Random;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class GuessGenerator implements Input {
    @Override
    public int guess() {
        Random random =  new Random();
        return random.nextInt(10);
    }
}
