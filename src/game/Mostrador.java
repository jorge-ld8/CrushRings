package game;
import Nodes.*;
import token.*;
import direction.*;
import java.util.ArrayList;
import java.util.Random;


public abstract class Mostrador<T extends Token>{
    protected ArrayList<Container<T>> mostrador;

    public Mostrador(){
        mostrador = new ArrayList<>();
    }

    public boolean isEmpty(){return size()==0;}

    public abstract void fill();

    public abstract int size();

    public void showMostrador(){
        System.out.println("Mostrador: ");
        int cont=1;
        for(Container<T> currContainer: mostrador) {
            System.out.printf("Ficha %d", cont++);
            System.out.println(currContainer);
        }
    }

    public Container<T> getContainer(int index){return mostrador.get(index-1);}

    public void update(Container<T> updateContainer){ updateContainer.clean();}
}



