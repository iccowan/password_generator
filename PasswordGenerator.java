import java.util.Random;
import java.util.Collections;
import java.util.Arrays;

public class PasswordGenerator {
    private static char[] alphabet = "qzwxecrvtbynumi<o>p/[?{];};laksjdhfg1029384756!)@(#*$&%QMWNEBRVTCYXUZIAOSPDLFKGH".toCharArray();

    public static void shuffle() {
        Random r = new Random();

        for (int i = 0; i < alphabet.length; i++) {
            int randomPosition = r.nextInt(alphabet.length);
            char temp = alphabet[i];
            alphabet[i] = alphabet[randomPosition];
            alphabet[randomPosition] = temp;
        }
    }

    public static String randomCharacter() {
        // Shuffle the array of characters
        shuffle();

        Random r = new Random();
        return Character.toString(alphabet[r.nextInt(alphabet.length)]);
    }

    public static String generatePassword(int length) {
        String password = "";
        for(int i = 0; i < length; i++) {
            password += randomCharacter();
        }

        return password;
    }
}