package rule;
import Nodes.*;
import direction.Direction;
import game.Marcador;
import token.*;

/*Interfaz regla que cualquier regla nueva que se quiera añadir debe implementarla*/
public interface Rule<T extends Token, D extends Direction> {
    boolean match(Cell<T, D> currTile, Color color, Marcador<T, D> actualMarcador); //clase abstracta match que se encargara de retornar si hay match o no
}
