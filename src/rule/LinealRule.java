package rule;
import Nodes.*;
import direction.*;
import token.*;
import game.*;

public class LinealRule<T extends Token, D extends Direction> implements Rule<T, D>{
    //helper method to match(Cell<T, D> cell)
    private boolean matchlineal(Cell<T, D> cell, D direction, Color color) {
        for(D d: cell.getNeighbours()){
            if(d == direction) {
                Cell<T, D> currTile = cell.getNeighbour(d);
                if (cell.equals(currTile, color)) return matchlineal(currTile, d, color);
                else return false;
            }
        }
        return true;
    }

    //helper method to match(Cell<T, D> t)
    private boolean matchtriple(Cell<T, D> t){ return t.sameVal();}

  /*  public boolean match(Cell<T, D> cell, Marcador<T, D> actualMarcador) {
        boolean retbool, finalbool = false;

        if(matchtriple(cell)){
            cell.clean();
            return true;
        }

        for(T token: cell.getTokens()) {
            Color currColor = token.getColor();
            retbool=false;
            for (D d : cell.getNeighbours()) {
                boolean isLinealMatch = matchlineal(cell, d, currColor) && matchlineal(cell, d.opposite(), currColor);
                if (isLinealMatch) {
                    retbool = true;
                    finalbool = true;
                    actualMarcador.increment(cell.getColor(currColor));
                    actualMarcador.update(cell, currColor, d);
                    actualMarcador.update(cell, currColor, d.opposite());
                    actualMarcador.combo();
                }
            }
            if (retbool)
                cell.clean(currColor); //si hubo match limpiar los colores de la casilla puesta
        }
        if(!finalbool)
            actualMarcador.resetCombo();
        return finalbool;
    }
*/
    public boolean match(Cell<T, D> cell){
        if(matchtriple(cell))
            return true;
        for(T token: cell.getTokens()){
            Color currColor = token.getColor();
            for(D d: cell.getNeighbours()){
                if(cell.matchLineal(d, currColor) && cell.matchLineal(d.opposite(), currColor))
                    return true;
            }
        }
        return false;
    }
}

/*
public boolean match(Cell<T, D> cell){
    ArrayList<Color> colorsList = cell.getColors();
    for(Color color: colorsList){
        ver si hay match por cada color
        HashMap<D, Cell<T, D>> map = cell.getNeighbours():
        for(D d: map.keySet()){
            Cell<T D> neighbourCell = map.get(d);
            if(cell.equals(neighbourCell){
                boolean isLinealMatch = matchlineal(neighbourCell, d) && matchlineal(cell, d.opposite);
                if(isLinealMatch) return true;
            }
        }
    }
    return false;
}
 */


