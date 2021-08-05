package board;
import direction.Direction;
import functionalInterfaces.Drawable;
import token.*;
import Nodes.*;
import java.util.ArrayList;

public abstract class Board<T extends Token, D extends Direction, C extends Cell<T, D>> implements Drawable{
    protected final ArrayList<C> board;

    public Board(){ board = new ArrayList<>(9); }

    public C getCell(int index){
        if(index<1 || index > board.size())
            throw new IllegalArgumentException(String.format("INDEX %d  no corresponde a una casilla valida del tablero", index));
        return board.get(index-1);
    }

    public boolean placeTokenAtCell(Container<T> container, C cell){return cell.take(container);}

    public boolean isAPlay(Container<T> container) { //BFS busqueda en profundidad, para recorrer el grafo
        Cell<T, D> currCell = getCell(1);
        ArrayList<Cell<T, D>> explored = new ArrayList<>();
        explored.add(currCell);
        ArrayList<Cell<T, D>> queue = new ArrayList<>();
        queue.add(currCell);
        while (queue.size() > 0) {
            currCell = queue.remove(0);
            if (currCell.isPlayable(container))
                return true;
            for (D dir : currCell.getNeighbours()) {
                Cell<T, D> nextCell = currCell.getNeighbour(dir);
                if (!explored.contains(nextCell)) {
                    queue.add(nextCell);
                    explored.add(nextCell);
                }
            }
        }
        return false;
    }
}
