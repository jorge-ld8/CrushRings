package token;
import java.util.ArrayList;
import java.util.Objects;


public final class TripleContainer extends Container{
    public TripleContainer(Token...ts){
        if(ts.length>3)
            throw new IllegalArgumentException("ERROR. Tokens don't fit in the container");
        tokens = new ArrayList<>();
        tokens.add(new NullToken());
        tokens.add(new NullToken());
        tokens.add(new NullToken());
        for(Token token: ts)
            this.take(token);
    }

    public TripleContainer(){
        tokens = new ArrayList<>();
        tokens.add(new NullToken());
        tokens.add(new NullToken());
        tokens.add(new NullToken());
    }

    public Token getBigToken(){return tokens.get(2);}
    public Token getMidToken(){return tokens.get(1); }
    public Token getSmallToken() { return tokens.get(0);}

    private void setSmallToken(Token smallToken) {
        tokens.remove(0);
        tokens.add(0, smallToken);
    }

    private void setMidToken(Token midToken) {
        tokens.remove(1);
        tokens.add(1, midToken);
    }

    private void setBigToken(Token bigToken) {
        tokens.remove(2);
        tokens.add(2, bigToken);
    }

    public boolean equals(Container ob) {
        for(Token token: getTokens()){
            for(Token otherToken: ob.getTokens()){
                if(token.equals(otherToken))
                    return true;
            }
        }
        return false;
    }

    public boolean sameVal() {
        return getSmallToken().equals(getMidToken()) &&
                getSmallToken().equals(getBigToken()) &&
                getMidToken().equals(getBigToken());
    }

    @Override
    public boolean take(Token token) {
        switch (token.getSize()) {
            case SMALL -> {
                if (getSmallToken().isNotNil()) return false;
                setSmallToken(token);
            }
            case MEDIUM -> {
                if (getMidToken().isNotNil()) return false;
                setMidToken(token);
            }
            case BIG -> {
                if (getBigToken().isNotNil()) return false;
                setBigToken(token);
            }
        }
        return true;
    }

    public void clean(){
        setSmallToken(new NullToken());
        setMidToken(new NullToken());
        setBigToken(new NullToken());
    }

    public void clean(Color color){
        if(getSmallToken().getColor() == color)
            setSmallToken(new NullToken());
        if(getMidToken().getColor() == color)
            setMidToken(new NullToken());
        if(getBigToken().getColor() == color)
            setBigToken(new NullToken());
    }

    @Override
    public String toString(){
        return String.format("Triple container:%n\t-%s%n\t-%s%n\t-%s%n", getSmallToken(), getMidToken(), getBigToken());
    }
}
