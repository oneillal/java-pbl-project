// Instantiable class to generate random number to be used by Computer in Morra game
import java.util.Random;

public class NoGenerator {

	private static final int MIN = 1;
        private static final int MAX = 10;

	// Generates a random number from 1 to 10
	public static int gen() {
                Random rn = new Random();

                return MIN + rn.nextInt(MAX - MIN + 1);
        }



}
