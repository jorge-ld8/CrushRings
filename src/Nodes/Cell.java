package Nodes;
import java.util.ArrayList;
import direction.Direction;
import functionalInterfaces.*;
import token.*;
import java.util.Set;

//HOLA
/*clase abstracta Tile que representa una casilla abstracta, de la cual si se desea impmlementar
un una nueva forma de casilla solo se debe extender de esta y sobreescribir el metodo draw
*/
//NOTA: abstraer take so it can take any container
public abstract class Cell<T extends Token, D extends Direction> extends Node<Container<T>, D> implements Drawable, Cleanable {
    public Cell(Container<T> value){
        super(value);
    }

    public void genAdjacency(Cell<T, D> otherNode, D direction) {
        getN().addNeighbour(otherNode, direction);
        otherNode.getN().addNeighbour(this, direction.opposite());
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

    public boolean matchLineal(D dir, Color color){
        for(D direction: getNeighbours()){
            Cell<T, D> currNeighbour = getNeighbour(direction);
            if(dir == direction && currNeighbour.equals(this, color))
                return currNeighbour.matchLineal(dir, color);
            else if(dir == direction)
                return false;
        }
        return true;
    }

    public boolean sameVal(){return getValue().sameVal();}

    public void clean(){
        getValue().clean();
    }

    public void clean(Color color){ getValue().clean(color);}

    public Cell<T, D> getNeighbour(D dir){return (Cell<T, D>) getN().get(dir);}

    public Set<D> getNeighbours(){return getN().getDirections();}

    public ArrayList<T> getTokens(){return getValue().getTokens();}

    public boolean equals(Cell<T, D> otherCell, Color currColor){
        return getValue().equals(otherCell.getValue(), currColor);
    }
}
