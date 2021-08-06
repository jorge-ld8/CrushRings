package rule;
import Nodes.*;
import direction.Direction;
import token.*;

/*Interfaz regla que cualquier regla nueva que se quiera añadir debe implementarla*/
public interface Rule<T extends Token, D extends Direction> {
    boolean match(Cell<T, D> currCell);
}
