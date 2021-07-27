package Nodes;
import direction.Octagonal;
import game.Marcador;
import token.*;
import rule.*;
import java.util.ArrayList;

public class TileTest {
    public static void main(String[] args){
        //Instantiate to concrete tiles
        RoundTile<Ring, Octagonal> myTile1 = new RoundTile<>(new TripleContainer());
        RoundTile<Ring, Octagonal> myTile2 = new RoundTile<>(new TripleContainer());
        RoundTile<Ring, Octagonal> myTile3 = new RoundTile<>(new TripleContainer()); //esquina superior derecha
        RoundTile<Ring, Octagonal> myTile4 = new RoundTile<>(new TripleContainer());
        RoundTile<Ring, Octagonal> myTile5 = new RoundTile<>(new TripleContainer()); //medio
        RoundTile<Ring, Octagonal> myTile6 = new RoundTile<>(new TripleContainer());
        RoundTile<Ring, Octagonal> myTile7 = new RoundTile<>(new TripleContainer()); //esquina inferior izquierda
        RoundTile<Ring, Octagonal> myTile8 = new RoundTile<>(new TripleContainer());
        RoundTile<Ring, Octagonal> myTile9 = new RoundTile<>(new TripleContainer()); //esquina inferior derecha


        ArrayList<RoundTile<Ring, Octagonal>> tiles = new ArrayList<>();
        tiles.add(myTile1);
        tiles.add(myTile2);
        tiles.add(myTile3);
        tiles.add(myTile4);
        tiles.add(myTile5);
        tiles.add(myTile6);
        tiles.add(myTile7);
        tiles.add(myTile8);
        tiles.add(myTile9);

        myTile1.genAdjacency(myTile2, Octagonal.RIGHT);
        myTile1.genAdjacency(myTile4, Octagonal.DOWN);
        myTile1.genAdjacency(myTile5, Octagonal.DOWN_RIGHT);

        myTile2.genAdjacency(myTile5, Octagonal.DOWN);
        myTile2.genAdjacency(myTile3, Octagonal.RIGHT);

        myTile3.genAdjacency(myTile6, Octagonal.DOWN);
        myTile3.genAdjacency(myTile5, Octagonal.DOWN_LEFT);

        myTile4.genAdjacency(myTile7, Octagonal.DOWN);
        myTile4.genAdjacency(myTile5, Octagonal.RIGHT);

        myTile6.genAdjacency(myTile5, Octagonal.LEFT);
        myTile6.genAdjacency(myTile9, Octagonal.DOWN);

        myTile7.genAdjacency(myTile8, Octagonal.RIGHT);
        myTile7.genAdjacency(myTile5, Octagonal.UP_RIGHT);

        myTile8.genAdjacency(myTile9, Octagonal.RIGHT);
        myTile8.genAdjacency(myTile5, Octagonal.UP);

        myTile9.genAdjacency(myTile5, Octagonal.UP_LEFT);

        CrushRingsRule myRule = new CrushRingsRule();
        MarcadorCrushRings myMarcador = new MarcadorCrushRings();
        Ring testRing = new Ring(Color.GREEN, Size.MEDIUM);
        myMarcador.showCont();
        myTile3.take(testRing);
        myTile4.take(new Ring(Color.GREEN, Size.MEDIUM));
        myTile5.take(new Ring(Color.GREEN, Size.BIG));
        myTile9.take(new Ring(Color.GREEN, Size.SMALL));
        myTile6.take(new Ring(Color.GREEN, Size.MEDIUM));
        System.out.println(myRule.match(myTile6, Color.GREEN, myMarcador)? "HAY MATCH": "NO HAY MATCH");
        myMarcador.showCont();
    }
}

class CrushRingsRule extends LinealRule<Ring, Octagonal>{}
class MarcadorCrushRings extends Marcador<Ring, Octagonal>{}