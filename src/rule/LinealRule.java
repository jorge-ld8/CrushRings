package rule;
import Nodes.*;
import direction.*;
import token.*;

public class LinealRule<T extends Token, D extends Direction> implements Rule<T, D>{
    //helper method to match(Cell<T, D> t)
    private boolean matchtriple(Cell<T, D> t){ return t.sameVal();}

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

