package Nodes;

import direction.Direction;
import token.*;

/*Clase concreta Round Tile que representa una ficha redonda, con el metodo draw() sobreescrito apropiadamente*/
public class RoundCell<T extends Token, D extends Direction> extends Cell<T, D>{

    public RoundCell(Container<T> valor){ super(valor);}

    @Override
    public String toString(){
        return String.format("|%50s|\t\t", getValue());
    }

    @Override
    public void draw(){
        System.out.printf("|%50s|\t\t", getValue());
    }
}
