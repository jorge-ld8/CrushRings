package Nodes;
import java.util.ArrayList;
import java.util.HashMap;
import direction.Direction;
import token.*;
import java.util.Set;

//HOLA
/*clase abstracta Tile que representa una casilla abstracta, de la cual si se desea impmlementar
un una nueva forma de casilla solo se debe extender de esta y sobreescribir el metodo draw
*/
//NOTA: abstraer take so it can take any container
public abstract class Cell<T extends Token, D extends Direction>{
    private final Container<T> value;
    private final Neighbourhood<T, D> n;

    public Cell(Container<T> value){
        this.value = value;
        n = new Neighbourhood<>();
    }

    public Container<T> getValue(){return value;}

    public void genAdjacency(Cell<T, D> otherNode, D direction) {
        n.addNeighbour(otherNode, direction);
        otherNode.n.addNeighbour(this, direction.opposite());
    }

    public boolean take(Container<T> container) {
        return getValue().take(container);
    }

    public boolean isPlayable(Container<T> container){
        return getValue().isPlayable(container);
    }

    public int getColor(Color color){
        int cont=0;
        for(T token: getTokens()) {
            Color currColor = token.getColor();
            if(currColor == color)
                cont++;
        }
        return cont;
    }

    public boolean sameVal(){return getValue().sameVal();}

    public void clean(){
        getValue().clean();
    }

    public void clean(Color color){ getValue().clean(color);}

    public Cell<T, D> getNeighbour(D dir){return n.get(dir);}

    public Set<D> getNeighbours(){return n.getDirections();}

    public ArrayList<T> getTokens(){return getValue().getTokens();}

    public boolean equals(Cell<T, D> otherCell, Color currColor){
        return getValue().equals(otherCell.getValue(), currColor);
    }

    public abstract void draw();
}
