package Nodes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import direction.Direction;
import token.*;

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

    public Neighbourhood<T, D> getN(){
        return n;
    }

    public HashMap<D, Cell<T, D>> getNeighbours(){
        return n.getNeighbours();
    }

    public void addNeighbour(Cell<T, D> otherNode, D dir){getN().addNeighbour(otherNode, dir);}

    public void genAdjacency(Cell<T, D> otherNode, D direction) {
        addNeighbour(otherNode, direction);
        otherNode.addNeighbour(this, direction.opposite());
    }

    //Overloading of method take so a variable of type container can be passed as an argument
    public boolean take(Container<T> container) {
        return getValue().take(container);
    }

    public boolean isPlayable(Container<T> container){
        return getValue().isPlayable(container);
    }

    public void clean(){
        getValue().clean();
    }

    public boolean sameVal(){return getValue().sameVal();}

    public void clean(Color color){
        getValue().clean(color);
    }

    public ArrayList<Color> getColors(){ return getValue().getColors();}

    public boolean equals(Cell<T, D> otherTile){
        return getValue().equals(otherTile.getValue());
    }

    public abstract void draw();
}
