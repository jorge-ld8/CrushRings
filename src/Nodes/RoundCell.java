package Nodes;

import direction.Direction;
import token.*;

/*Clase concreta Round Tile que representa una ficha redonda, con el metodo draw() sobreescrito apropiadamente*/
public class RoundCell<T extends Token, D extends Direction> extends Cell<T, D>{

    public RoundCell(Container<T> valor){ super(valor);}

    @Override
    public void draw(){
        System.out.printf("Round Cell: %s", getValue());
    }

    @Override
    public String toString(){
        return String.format("Round Cell: %s", getValue());
    }
}
