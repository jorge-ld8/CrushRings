package game;
import Nodes.*;
import token.*;
import direction.*;

public class Marcador<T extends Token, D extends Direction>{
    private  int cont; //contador de puntos

    public static final int pointVal = 1; //valor por ficha en match

    private PointCombo combo = new PointCombo();

    public int getCont(){
        return cont;
    }

    public void showCont(){
        System.out.print("Contador de puntos: " + getCont());
        if(combo.getMultiplier() != 1)
            System.out.printf(" %s X%d %s", ColorConstants.TEXT_WHITE, combo.getMultiplier(), ColorConstants.TEXT_RESET);
        System.out.println();
    }

    public void increment(int incRate){ cont+=pointVal*incRate*combo.getMultiplier();}

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

    public void  resetCombo(){combo.reset();}

    public void combo(){ combo.incMultiplier();}

    public void pruebaUpdate(Cell<T, D> cell){
        //prueba de una update de puntos
    }
}

/*public void update(Cell<T, D> cell, Color color){
}
 */

