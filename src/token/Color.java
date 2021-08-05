package token;
import java.util.Random;

public enum Color {
    BLUE,
    YELLOW,
    GREEN,
    RED,
    PURPLE,
    PINK,
    WHITE,
    EMPTY;

    public static Color getRandom(){
        Random random = new Random();
        int colorInt = random.nextInt(values().length-1);
        return values()[colorInt];
    }
}
