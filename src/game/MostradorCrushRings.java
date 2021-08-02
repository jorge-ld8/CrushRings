package game;

import direction.Octagonal;
import token.*;

import java.util.ArrayList;
import java.util.Random;

public class MostradorCrushRings extends Mostrador<Token>{
    public MostradorCrushRings(){
        super();
        mostrador.add(new TripleContainer(new SmallRing(Color.GREEN)));
        mostrador.add(new TripleContainer(new SmallRing(Color.GREEN)));
        mostrador.add(new TripleContainer(new SmallRing(Color.GREEN)));
        this.fill();
    }

    @Override
    public int size(){
        int cont=0;
        for(Container token: mostrador){
            if(token.isNotEmpty()) ++cont;
        }
        return cont;
    }

    @Override
    public void fill(){
        Random random = new Random();
        for(int i=0; i<mostrador.size(); i++) {
            //Random seed para la cantidad de container
            int qContainer = random.nextInt( 2)+1;
            Token[] containers = new Token[qContainer];
            for(int j=0; j<qContainer; j++) {
                int colorInt = random.nextInt(Color.values().length-1);
                int sizeInt = random.nextInt(Size.values().length);
                Color randColor = Color.values()[colorInt];
                Size randSize = Size.values()[sizeInt];
                Token finRing;
                if(randSize == Size.SMALL)
                    finRing = new SmallRing(randColor);
                else if(randSize == Size.MEDIUM)
                    finRing = new MidRing(randColor);
                else
                    finRing = new BigRing(randColor);
                containers[j] = finRing;
            }
            mostrador.set(i, new TripleContainer(containers));
        }
    }
}
