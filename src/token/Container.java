package token;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Clase abstracta que representa un contenedor de fichas de un tamaño no definido
public abstract class Container<T extends Token>{
    protected ArrayList<T> tokens;

    public abstract boolean isPlayable(Container<T> container);

    public abstract boolean take(Container<T> container);

    public abstract boolean sameVal();

    public abstract boolean isNotEmpty();

    public abstract boolean equals(Container<T> ob);

    public abstract void clean();

    public abstract void clean(Color color);

    public ArrayList<Color> getColors(){
        ArrayList<Color> colorsList = new ArrayList<>();
        for(Token token: tokens) {
            if(token.isNotNil())
                colorsList.add(token.getColor());
        }
        return colorsList;
    }

    public ArrayList<T> getTokens() {
        ArrayList<T> tokensList = new ArrayList<>();
        for (T token : tokens) {
            if (token.isNotNil())
                tokensList.add(token);
        }
        return tokensList;
    }
}
