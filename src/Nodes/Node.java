package Nodes;
import direction.*;

public class Node<V, D extends Direction> {
    private final Neighbourhood<D, Node<V, D>> n;
    private final V value;

    public Node(V value){
        n = new Neighbourhood<>();
        this.value = value;
    }

    public V getValue(){
        return value;
    }

    public Neighbourhood<D, Node<V, D>> getN(){
        return n;
    }
}
