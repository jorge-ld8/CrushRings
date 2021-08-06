package game;

import direction.*;
import token.*;
import Nodes.*;

public class MarcadorCrushRings<T extends Token, D extends Direction> extends Marcador<T, D> {
    private void updateInDir(Cell<T, D> cell, Color color, D direction) {
        for (D d : cell.getNeighbours()) {
            if (d == direction) {
                Cell<T, D> currTile = cell.getNeighbour(d);
                increment(currTile.getColor(color));
                updateInDir(currTile, color, d);
                currTile.clean(color);
            }
        }
    }

    public void update(Cell<T, D> cell){
        if(cell.sameVal())
            cell.clean();
        for(Token token: cell.getTokens()){
            Color currColor = token.getColor();
            for(D d: cell.getNeighbours()) {
                Cell<T, D> currCell = cell.getNeighbour(d);
                if (currCell.matchLineal(d, currColor) && currCell.matchLineal(d.opposite(), currColor)) {
                    increment(cell.getColor(currColor));
                    updateInDir(cell, currColor, d);
                    updateInDir(cell, currColor, d.opposite());
                    combo();
                    cell.clean(currColor);
                }
            }
        }
    }
}