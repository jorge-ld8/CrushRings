package Nodes;

import direction.Direction;
import token.*;

/*Clase concreta Round Tile que representa una ficha redonda, con el metodo draw() sobreescrito apropiadamente*/
public class RoundTile<T extends Token, D extends Direction> extends Cell<T, D>{

    public RoundTile(Container valor){ super(valor);}

    @Override
    public void draw(){
        System.out.printf("Round Tile: %s", getValor());
    }

    @Override
    public String toString(){
        return String.format("Round Tile: %s", getValor());
    }
}
