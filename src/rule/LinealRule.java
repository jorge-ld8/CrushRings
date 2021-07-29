package rule;
import Nodes.*;
import direction.*;
import token.*;
import java.util.HashMap;
import java.util.ArrayList;
import game.*;

public class LinealRule<T extends Token, D extends Direction> implements Rule<T, D>{
    //helper method to match(Cell<T, D> cell)
    private boolean matchlineal(Cell<T, D> cell, D direction) {
        HashMap<D, Cell<T, D>> map = cell.getNeighbours();
        for(D d: map.keySet()){
            Cell<T, D> currTile = map.get(d);
            if(d == direction && cell.equals(currTile)) return matchlineal(currTile, d);
            else if(d == direction) return false;
        }
        return true;
    }

    //helper method to match(Cell<T, D> t)
    private boolean matchtriple(Cell<T, D> t){
        return t.getValor().sameVal();
    }

    public boolean match(Cell<T, D> cell, Marcador<T, D> actualMarcador) {
        boolean retbool = false;

        if(matchtriple(cell)){
            cell.clean();
            return true;
        }
        ArrayList<Color> colorsList = cell.getColors();
        for(Color color: colorsList) {
            System.out.println(color);
            HashMap<D, Cell<T, D>> map = cell.getNeighbours(); //iteracion por los vecinos
            for (D d : map.keySet()) {
                Cell<T, D> currCell = map.get(d);
                if (cell.equals(currCell)) {
                    boolean isLinealMatch = matchlineal(currCell, d) && matchlineal(cell, d.opposite());
                    if (isLinealMatch) {
                        retbool = true;
                        actualMarcador.increment();
                        actualMarcador.update(cell, color, d);
                        actualMarcador.update(cell, color, d.opposite());
                    }
                }
            }
            if (retbool) cell.clean(color); //si hubo match limpiar los colores de la casilla puesta
        }
        return retbool;
    }
}

