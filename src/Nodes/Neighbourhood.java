package Nodes;

import java.util.HashMap;
import java.util.Set;

import direction.Direction;
import token.Token;

/*Clase concreta Neighbourhood que representa las adyacencias de un nodo con demas nodos
* Recibe dos tipos T de cualquier tipo de ficha y D de cualquier gama de direcciones*/

public class Neighbourhood<T extends Token, D extends Direction>{
    //its state represents a neigbourhood between Nodes
    private final HashMap<D, Cell<T,D>> neighbours;

    public Neighbourhood(){ neighbours = new HashMap<>();}

    public HashMap<D, Cell<T,D>> getNeighbours() {
        return neighbours;
    }

    public Cell<T, D> get(D dir){ return neighbours.get(dir);}

    public void addNeighbour(Cell<T, D> otherNode, D dir){
        neighbours.put(dir, otherNode);
    }
}
