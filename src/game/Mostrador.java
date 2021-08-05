package game;
import token.*;
import java.util.ArrayList;

//Toda clase que extienda de Mostrador firma debe implementar el metodo fill y size, por lo que debe definir el size del mostrador
public abstract class Mostrador<T extends Token>{
    protected ArrayList<Container<T>> mostrador;

    public Mostrador(){
        mostrador = new ArrayList<>();
    }

    public boolean isEmpty(){return availableTokens()==0;}

    public abstract void fill();

    public abstract int size();

    public abstract int availableTokens();

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



