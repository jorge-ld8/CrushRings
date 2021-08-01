package token;
import java.util.ArrayList;
import java.util.Objects;

//TODO:Discuss implementation of the container as hashmap
//TODO: Find out how to deal with mutability of returning an ArrayList
public final class TripleContainer<T extends Token> extends Container<T>{
    @SafeVarargs
    public TripleContainer(T...ts){
        if(ts.length>3)
            throw new IllegalArgumentException("ERROR. Tokens don't fit in the container");
        tokens = new ArrayList<>();
        tokens.add((T) new NullToken());
        tokens.add((T) new NullToken());
        tokens.add((T) new NullToken());
        for(T token: ts)
            this.take(token);
    }

    public TripleContainer(){
        tokens = new ArrayList<>();
        tokens.add((T) new NullToken());
        tokens.add((T) new NullToken());
        tokens.add((T) new NullToken());
    }

    public Token getBigToken(){return tokens.get(2);}
    public Token getMidToken(){return tokens.get(1); }
    public Token getSmallToken() { return tokens.get(0);}

    private void setSmallToken(T smallToken) {
        tokens.set(0, smallToken);
    }

    private void setMidToken(T midToken) {
        tokens.set(1, midToken);
    }

    private void setBigToken(T bigToken) {
        tokens.set(2, bigToken);
    }

    public boolean equals(Container<T> ob) {
        for(T token: getTokens()){
            for(T otherToken: ob.getTokens()){
                if(token.equals(otherToken))
                    return true;
            }
        }
        return false;
    }

    public boolean equals(Container<T> ob, Color color){
        for(Color currColor: getColors()){
            if(currColor == color) {
                for (Color otherColor : ob.getColors()) {
                    if(otherColor == currColor)
                        return true;
                }
            }
        }
        return false;
    }

    public boolean sameVal() {
        return getSmallToken().equals(getMidToken()) &&
                getSmallToken().equals(getBigToken()) &&
                getMidToken().equals(getBigToken());
    }

    public boolean isPlayable(Container<T> container){
        for(T token: container.getTokens()){
            switch (token.getSize()){
                case SMALL ->{
                    if(getSmallToken().isNotNil()) return false;}
                case MEDIUM ->{
                    if(getMidToken().isNotNil()) return false;}
                case BIG ->{
                    if(getBigToken().isNotNil()) return false;}
            }
        }
        return true;
    }
    @Override
    public boolean take(Container<T> container){
        if(!isPlayable(container)) return false;
        for(T token: container.getTokens())
            take(token);
        return true;
    }

    private void take(T token) {
        switch (token.getSize()) {
            case SMALL -> setSmallToken(token);
            case MEDIUM -> setMidToken(token);
            case BIG -> setBigToken(token);
        }
    }

    public void clean(){
        setSmallToken((T) new NullToken());
        setMidToken((T) new NullToken());
        setBigToken((T) new NullToken());
    }

    public void clean(Color color){
        if(getSmallToken().getColor() == color)
            setSmallToken((T) new NullToken());
        if(getMidToken().getColor() == color)
            setMidToken((T) new NullToken());
        if(getBigToken().getColor() == color)
            setBigToken((T) new NullToken());
    }

    public boolean isNotEmpty(){
        for(T token: tokens){
            if(token.isNotNil())
                return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("Triple container: -%-20s-%-20s-%-20s %n", getSmallToken(), getMidToken(), getBigToken());
    }
}
