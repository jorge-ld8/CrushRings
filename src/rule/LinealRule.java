package rule;
import Nodes.*;
import direction.*;
import token.*;
import java.util.HashMap;
import java.util.ArrayList;
import game.*;

public class LinealRule<T extends Token, D extends Direction> implements Rule<T, D>{
    //helper method to match(Tile<T, D> t)
    private boolean matchlineal(Cell<T, D> tile, D direction) {
        HashMap<D, Cell<T, D>> map = tile.getNeighbours();
        for(D d: map.keySet()){
            Cell<T, D> currTile = map.get(d);
            if(d == direction && tile.equals(currTile)) return matchlineal(currTile, d);
            else if(d == direction) return false;
        }
        return true;
    }

    //helper method to match(Tile<T, D> t)
    private boolean matchtriple(Cell<T, D> t){
        return t.getValor().sameVal();
    }

    public boolean match(Cell<T, D> t, Color color, Marcador<T, D> actualMarcador) {
        boolean retbool = false;
        //match triple en la misma casilla
        if(matchtriple(t)) return true;
        //iteracion por los vecinos
        HashMap<D, Cell<T, D>> map = t.getNeighbours();
        for(D d : map.keySet()){
            Cell<T, D> currTile = map.get(d);
            if(t.equals(currTile)){
                 boolean linea = matchlineal(currTile, d) && matchlineal(t, d.opposite());
                 if(linea){
                     System.out.println(d);
                     retbool = true;
                     actualMarcador.increment();
                     actualMarcador.update(t, color, d);
                     actualMarcador.update(t, color, d.opposite());
                 }
            }
        }
        if(retbool)
            t.clean(color);
        return retbool;
    }
}

