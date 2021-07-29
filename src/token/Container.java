package token;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Clase abstracta que representa un contenedor de fichas de un tamaño no definido
public abstract class Container{
    protected ArrayList<Token> tokens;

    public abstract boolean take(Token token);

    public abstract boolean sameVal();

    public abstract boolean equals(Container ob);

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

    public ArrayList<Token> getTokens() {
        ArrayList<Token> tokensList = new ArrayList<>();
        for (Token token : tokens) {
            if (token.isNotNil())
                tokensList.add(token);
        }
        return tokensList;
    }
}
