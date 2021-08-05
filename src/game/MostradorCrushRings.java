package game;
import token.*;
import java.util.Random;

public class MostradorCrushRings extends Mostrador<Token>{
    public static int tiposFicha = 3;
    public MostradorCrushRings(){
        super();
        for(int i=0; i<size(); i++)
            mostrador.add(new TripleContainer(new SmallRing(Color.GREEN)));
        this.fill();
    }

    @Override
    public int size(){return 3;}

    @Override
    public int availableTokens(){
        int cont=0;
        for(Container<Token> token: mostrador){
            if(token.isNotEmpty())
                ++cont;
        }
        return cont;
    }

    @Override
    public void fill(){
        Random random = new Random();
        for(int i=0; i<size(); i++) {
            //Random seed para la cantidad de container
            int qContainer = random.nextInt( 2)+1;
            Token[] containers = new Token[qContainer];
            for(int j=0; j<qContainer; j++) {
                int colorInt = random.nextInt(Color.values().length-1);
                int sizeInt = random.nextInt(tiposFicha);
                Color randColor = Color.values()[colorInt];
                Token finRing;
                if(sizeInt == 1 )
                    finRing = new SmallRing(randColor);
                else if(sizeInt == 2)
                    finRing = new MidRing(randColor);
                else
                    finRing = new BigRing(randColor);
                containers[j] = finRing;
            }
            mostrador.set(i, new TripleContainer(containers));
        }
    }
}
