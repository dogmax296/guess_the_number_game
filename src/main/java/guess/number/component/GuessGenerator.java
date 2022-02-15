package guess.number.component;

import java.util.Random;

/**
 * @author dogmax296
 * @link https://github.com/dogmax296
 */
public class GuessGenerator implements Input {
    @Override
    public int guess() {
        return new Random().nextInt(10);
    }
}
