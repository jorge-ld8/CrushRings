package token;
import java.util.ArrayList;

public final class TripleContainer extends Container<Token>{
    public TripleContainer(Token...ts){
        if(ts.length>3)
            throw new IllegalArgumentException("ERROR. Tokens don't fit in the container");
        tokens = new ArrayList<>();
        tokens.add(new SmallRing());
        tokens.add(new MidRing());
        tokens.add(new BigRing());
        for(Token token: ts)
            this.take(token);
    }

    public TripleContainer(){ //Overloaded
        tokens = new ArrayList<>();
        tokens.add(new SmallRing());
        tokens.add(new MidRing());
        tokens.add(new BigRing());
    }

    public boolean equals(Container<Token> ob, Color color){
        for(Token token: getTokens()){
            Color currColor = token.getColor();
            if(currColor == color) {
                for (Token token1 : ob.getTokens()) {
                    Color otherColor = token1.getColor();
                    if(otherColor == currColor)
                        return true;
                }
            }
        }
        return false;
    }

    public boolean sameVal() {
        return tokens.get(0).equals(tokens.get(1)) &&
                tokens.get(0).equals(tokens.get(2))&&
                tokens.get(1).equals(tokens.get(2));
    }

    public boolean isPlayable(Container<Token> container){
        for(Token token: container.getTokens()){
            for(Token currToken: getTokens()) {
                if((token.getClass() == currToken.getClass()) && currToken.isNotNil())
                    return false;
            }
        }
        return true;
    }

    @Override
    public boolean take(Container<Token> container){
        if(!isPlayable(container)) return false;
        for(Token token: container.getTokens())
            take(token);
        return true;
    }

    private void take(Token token) { //Overloaded
        for(Token currToken: tokens)
            currToken.set(token);
    }

    public void clean(){
        for(Token token: getTokens())
            token.clean();
    }

    public void clean(Color color) { //Overloaded
        for (Token token : getTokens()){
            if (token.getColor() == color)
                token.clean();
        }
    }

    @Override
    public String toString(){
        return String.format("  %s  %s  %s  ", tokens.get(0), tokens.get(1), tokens.get(2));
    }

    @Override
    public void draw() {
        System.out.printf("  %s  %s  %s  ", tokens.get(0), tokens.get(1), tokens.get(2));
    }
}
