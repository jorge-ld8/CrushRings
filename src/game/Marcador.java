package game;
import Nodes.*;
import token.*;
import direction.*;

public abstract class Marcador<T extends Token, D extends Direction>{
    private  int cont;

    public static final int POINT_VAL = 1; //valor por ficha en match

    private final PointCombo combo = new PointCombo();

    public int getCont(){
        return cont;
    }

    public void showCont(){
        System.out.print("Contador de puntos: " + getCont());
        if(combo.getMultiplier() != 1)
            System.out.printf(" %s X%d %s", ColorConstants.TEXT_WHITE, combo.getMultiplier(), ColorConstants.TEXT_RESET);
        System.out.println();
    }

    public void increment(int incRate){ cont+=POINT_VAL*incRate*combo.getMultiplier();}

    public void increment(Container<T> container){cont += POINT_VAL*container.getTokens().size();}

    public abstract void update(Cell<T, D> cell);

    public void  resetCombo(){combo.reset();}

    public void combo(){ combo.incMultiplier();}
}

