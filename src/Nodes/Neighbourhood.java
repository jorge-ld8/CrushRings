package Nodes;
import java.util.HashMap;
import java.util.Set;
import direction.Direction;

/*Clase concreta Neighbourhood que representa las adyacencias de un nodo con demas nodos
* Recibe dos tipos T de cualquier tipo de ficha y D de cualquier gama de direcciones*/

public class Neighbourhood<D extends Direction, V>{
    private final HashMap<D, V> neighbours;

    public Neighbourhood(){neighbours = new HashMap<>();}

    public V get(D dir){return neighbours.get(dir);}

    public Set<D> getDirections(){return neighbours.keySet();}

    public void addNeighbour(V otherVal, D dir){
        neighbours.put(dir, otherVal);
    }
}
