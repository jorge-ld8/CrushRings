package board;
import direction.Direction;
import token.*;
import Nodes.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Board<T extends Token, D extends Direction, C extends Cell<T, D>>{
    protected final ArrayList<C> board;

    public Board(){ board = new ArrayList<>(9); }

    public C getCell(int index){return board.get(index-1);}

    public boolean placeTokenAtCell(Container container, C cell){return cell.take(container);}

    public boolean placeTokenAtCell(T token, C cell){ return cell.take(token);}

    public abstract boolean isAPlay();

    public void showBoard(){
        for(C cell: board)
            System.out.println(cell);
    }
}
