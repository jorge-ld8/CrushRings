package token;
import functionalInterfaces.Cleanable;

import java.util.ArrayList;

//Clase abstracta que representa un contenedor de fichas de un tamaño no definido
public abstract class Container<T extends Token> implements Cleanable{
    protected ArrayList<T> tokens;

    public abstract boolean isPlayable(Container<T> container);

    public abstract boolean take(Container<T> container);

    public abstract boolean sameVal();

    public abstract boolean equals(Container<T> ob, Color color);

    public boolean isNotEmpty(){return getTokens().size() > 0;}

    public ArrayList<T> getTokens() {
        ArrayList<T> tokensList = new ArrayList<>();
        for (T token : tokens) {
            if (token.isNotNil())
                tokensList.add(token);
        }
        return tokensList;
    }
}
