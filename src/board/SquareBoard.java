package board;

import Nodes.Cell;
import Nodes.RoundTile;
import direction.Octagonal;
import token.Color;
import token.Ring;
import token.Size;
import token.TripleContainer;

import java.util.ArrayList;

public class SquareBoard extends Board<Ring, Octagonal, RoundTile<Ring, Octagonal>> {
    public SquareBoard(){
        //tiles of the board
        super();
        final RoundTile<Ring, Octagonal> myTile1 = new RoundTile<>(new TripleContainer());
        final RoundTile<Ring, Octagonal> myTile2 = new RoundTile<>(new TripleContainer());
        final RoundTile<Ring, Octagonal> myTile3 = new RoundTile<>(new TripleContainer()); //esquina superior derecha
        final RoundTile<Ring, Octagonal> myTile4 = new RoundTile<>(new TripleContainer());
        final RoundTile<Ring, Octagonal> myTile5 = new RoundTile<>(new TripleContainer()); //medio
        final RoundTile<Ring, Octagonal> myTile6 = new RoundTile<>(new TripleContainer());
        final RoundTile<Ring, Octagonal> myTile7 = new RoundTile<>(new TripleContainer()); //esquina inferior izquierda
        final RoundTile<Ring, Octagonal> myTile8 = new RoundTile<>(new TripleContainer());
        final RoundTile<Ring, Octagonal> myTile9 = new RoundTile<>(new TripleContainer()); //esquina inferior derecha

        board.add(myTile1);
        board.add(myTile2);
        board.add(myTile3);
        board.add(myTile4);
        board.add(myTile5);
        board.add(myTile6);
        board.add(myTile7);
        board.add(myTile8);
        board.add(myTile9);
    }

    @Override
    public boolean isAPlay(){
        return true;
    }
}
