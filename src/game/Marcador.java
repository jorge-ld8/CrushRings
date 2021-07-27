package game;
import Nodes.*;
import token.*;
import direction.*;

import java.util.HashMap;

public class Marcador<T extends Token, D extends Direction>{
    private  int cont; //contador de puntos

    public static final int pointVal = 1; //valor por ficha en match

    public int getCont(){
        return cont;
    }

    public void showCont(){
        System.out.println("Contador de puntos: " + getCont());
    }

    public void increment(){
        cont+=pointVal;
    }

    public void update(Cell<T, D> t, Color color, D direction){
        HashMap<D, Cell<T, D>> neighboursTile = t.getNeighbours();
        for(D d : neighboursTile.keySet()){
            if(d == direction){
                increment();
                update(neighboursTile.get(d), color, d);
                neighboursTile.get(d).clean(color);
            }
        }
    }
}
