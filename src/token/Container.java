package token;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Container{
    protected ArrayList<Token> tokens;

    public abstract void take(Token token);

    public abstract int getSize();

    public abstract boolean sameVal();

    public List<Token> getTokens(){return tokens;}

    public abstract boolean equals(Container ob);

    public abstract void clean(Color color);
}
