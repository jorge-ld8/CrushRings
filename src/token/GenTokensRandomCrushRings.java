package token;
import java.util.Random;

public class GenTokensRandomCrushRings implements RandomTokensGenerator{
    public Token getRandom() {
        Random random = new Random();
        int sizeInt = random.nextInt(3);
        Color randColor = Color.getRandom();
        Token randToken;
        if (sizeInt == 1)
            randToken = new SmallRing(randColor);
        else if (sizeInt == 2)
            randToken = new MidRing(randColor);
        else
            randToken= new BigRing(randColor);
        return randToken;
    }
}

