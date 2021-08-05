package game;
import token.*;
import java.util.Random;

public class MostradorCrushRings extends Mostrador<Token>{
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
            int qContainer = random.nextInt( 2)+1; //Random seed para la cantidad de container
            Token[] containers = new Token[qContainer];
            for(int j=0; j<qContainer; j++) {
                RandomTokensGenerator RandTokenGen = new GenTokensRandomCrushRings();
                containers[j] = RandTokenGen.getRandom();
            }
            mostrador.set(i, new TripleContainer(containers));
        }
    }
}
