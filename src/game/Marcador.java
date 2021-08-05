package game;
import Nodes.*;
import token.*;
import direction.*;

public class Marcador<T extends Token, D extends Direction>{
    private  int cont; //contador de puntos

    public static final int pointVal = 1; //valor por ficha en match

    public int getCont(){
        return cont;
    }

    public void showCont(){
        System.out.println("Contador de puntos: " + getCont());
    }

    public void increment(int incRate){ cont+=pointVal*incRate;}

    public void update(Cell<T, D> cell, Color color, D direction){
        for(D d : cell.getNeighbours()){
            if(d == direction){
                Cell<T, D> currTile = cell.getNeighbour(d);
                increment(currTile.getColor(color));
                update(currTile, color, d);
                currTile.clean(color);
            }
        }
    }

    public void pruebaUpdate(Cell<T, D> cell){
        //prueba de una update de puntos
    }
}

/*public void update(Cell<T, D> cell, Color color){
}
 */

