package board;
import direction.Direction;
import token.*;
import Nodes.*;
import java.util.ArrayList;

public abstract class Board<T extends Token, D extends Direction, C extends Cell<T, D>>{
    protected final ArrayList<C> board;

    public Board(){ board = new ArrayList<>(9); }

    public C getCell(int index){return board.get(index-1);}

    public boolean placeTokenAtCell(Container<T> container, C cell){return cell.take(container);}

    public boolean isAPlay(Container<T> container){ //BFS busqueda en profundidad, para recorrer el grafo
        Cell<T, D> currCell = getCell(1);
        ArrayList<Cell<T,D>> explored = new ArrayList<>();
        explored.add(currCell);
        ArrayList<Cell<T,D>> queue = new ArrayList<>();
        queue.add(currCell);
        while(queue.size()>0){
            currCell = queue.remove(0);
            if(currCell.isPlayable(container))
                return true;
            for(D dir: currCell.getNeighbours()){
                Cell<T, D> nextCell = currCell.getNeighbour(dir);
                if(!explored.contains(nextCell)){
                    queue.add(nextCell);
                    explored.add(nextCell);
                }
            }
        }
        return false;
    }

    public void showBoard() {
        int i = 1;
        for (C cell : board) {
            System.out.printf("Casilla %d ", i++);
            System.out.println(cell);
        }
    }
}
