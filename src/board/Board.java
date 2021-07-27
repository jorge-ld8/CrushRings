package board;
import direction.Direction;
import token.*;
import Nodes.*;

import java.util.ArrayList;

public abstract class Board<T extends Token, D extends Direction, C extends Cell<T, D>>{
    protected final ArrayList<C> board;

    public Board(){ board = new ArrayList<>(); }

    public void placeTokenAtTile(T token, C cell){
        cell.take(token);
    }

    public abstract boolean isAPlay();
}
