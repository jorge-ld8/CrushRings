package game;

import direction.Octagonal;
import token.*;

import java.util.ArrayList;
import java.util.Random;

public class MostradorCrushRings extends Mostrador<Ring>{
    public MostradorCrushRings(int size){
        super(size);
        mostrador.add(new TripleContainer<>(new Ring(Color.GREEN, Size.SMALL)));
        mostrador.add(new TripleContainer<>(new Ring(Color.GREEN, Size.SMALL)));
        mostrador.add(new TripleContainer<>(new Ring(Color.GREEN, Size.SMALL)));
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
            Ring[] containers = new Ring[qContainer];
            for(int j=0; j<qContainer; j++) {
                int colorInt = random.nextInt(Color.values().length);
                int sizeInt = random.nextInt(Size.values().length);
                Color randColor = Color.values()[colorInt];
                Size randSize = Size.values()[sizeInt];
                containers[j] = new Ring(randColor, randSize);
            }
            mostrador.set(i, new TripleContainer<>(containers));
        }
    }
}
