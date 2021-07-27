package Nodes;
import token.*;

/*Clase abstracta generica que representa un nodo del cual deben extender todas aquellas estructuras que tengan nodos
(arboles, grafos, etc)
 */
abstract class Nodo<T extends Token> {
    private Container valor; // valor que guarda el vertice

    public Nodo(Container valor){
        this.valor = valor;
    }

    public Container getValor(){
        return valor;
    }

    //public void take(TripleContainer<T> valor){;}
}

//public class NodoJuego<T> extends Nodo<T>{
//  private int id;
//}