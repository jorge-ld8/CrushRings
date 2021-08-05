package game;

import direction.Octagonal;
import token.*;
import Nodes.*;

public class MarcadorCrushRings extends Marcador<Token, Octagonal> {
    public void update(Cell<Token, Octagonal> cell, Color color, Octagonal direction) {
        for (Octagonal d : cell.getNeighbours()) {
            if (d == direction) {
                Cell<Token, Octagonal> currTile = cell.getNeighbour(d);
                increment(currTile.getColor(color));
                update(currTile, color, d);
                currTile.clean(color);
            }
        }
    }
}