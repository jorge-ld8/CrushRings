package Nodes;
import java.util.HashMap;
import java.util.Objects;
import direction.Direction;
import token.*;

//HOLA
/*clase abstracta Tile que representa una casilla abstracta, de la cual si se desea impmlementar
un una nueva forma de casilla solo se debe extender de esta y sobreescribir el metodo draw
*/
public abstract class Cell<T extends Token, D extends Direction> extends Nodo<T> {
    private final Neighbourhood<T, D> n;

    public Cell(Container valor){
        super(valor);
        n = new Neighbourhood<>();
    }

    public Neighbourhood<T, D> getN(){
        return n;
    }

    public HashMap<D, Cell<T, D>> getNeighbours(){
        return n.getNeighbours();
    }

    public void addNeighbour(Cell<T, D> otherNode, D dir){getN().addNeighbour(otherNode, dir);}

    public void genAdjacency(Cell<T, D> otherNode, D direction){
        addNeighbour(otherNode, direction);
        otherNode.addNeighbour(this, direction.opposite());
    }

    public void showNeighbours(){
        HashMap<D, Cell<T, D>> neighbours = getNeighbours();
        System.out.printf("Actual tile: %s... neighbours->%n", getValor());
        for(D d: neighbours.keySet())
            System.out.printf("\t%s: %s%n", d, neighbours.get(d));
    }

    public void take(T token){
        getValor().take(token);
    }

    public void clean(Color color){
        getValor().clean(color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n);
    }

    public boolean equals(Cell<T, D> otherTile){
        return getValor().equals(otherTile.getValor());
    }

    public abstract void draw();
}
