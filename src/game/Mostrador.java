package game;
import board.Graficador;
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
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  MOSTRADOR");
        int cont=1;
        Graficador.printLine(149);
        for(Container<T> currContainer: mostrador) {
            System.out.printf("F%d", cont++);
            System.out.printf(" |%s|\t\t",currContainer);
        }
        Graficador.printLine(149);
    }

    public Container<T> getContainer(int index){
        if(index<1 || index>size())
            throw new IllegalArgumentException(String.format("INDEX %d no esta dentro de los limites de Mostrador", index));
        Container<T> retContainer = mostrador.get(index-1);
        if(!retContainer.isNotEmpty())
            throw new IllegalArgumentException("FICHA VACÍA");
        return retContainer;
    }

    public void update(Container<T> updateContainer){ updateContainer.clean();}
}



