package token;
import java.util.Random;

public enum Color {
    BLUE,
    YELLOW,
    GREEN,
    RED,
    PURPLE,
    CYAN,
    WHITE,
    EMPTY;

    public static Color getRandom(){
        Random random = new Random();
        int colorInt = random.nextInt(values().length-1);
        return values()[colorInt];
    }

    public String getColorRepresentation(){
        return switch(this){
            case BLUE -> ColorConstants.TEXT_BLUE;
            case YELLOW -> ColorConstants.TEXT_YELLOW;
            case RED -> ColorConstants.TEXT_RED;
            case GREEN -> ColorConstants.TEXT_GREEN;
            case PURPLE -> ColorConstants.TEXT_PURPLE;
            case CYAN -> ColorConstants.TEXT_CYAN;
            case WHITE -> ColorConstants.TEXT_WHITE;
            case EMPTY -> ColorConstants.TEXT_BLACK;
        };
    }
}
