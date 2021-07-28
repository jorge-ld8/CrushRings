package token;
import java.util.ArrayList;
import java.util.Objects;


//limitar la size
public final class TripleContainer extends Container{
    public TripleContainer(){
        tokens = new ArrayList<>();
        tokens.add(new NullToken());
        tokens.add(new NullToken());
        tokens.add(new NullToken());
    }

    @Override
    public int getSize(){return 3;}

    public Token getBigToken(){return tokens.get(2);}
    public Token getMidToken(){return tokens.get(1); }
    public Token getSmallToken() { return tokens.get(0);}

    private void setSmallToken(Token smallToken) {
        if(getSmallToken().isNil())
            tokens.add(0, smallToken);
    }

    private void setMidToken(Token midToken) {
        if(getMidToken().isNil())
            tokens.add(0, midToken);
    }

    private void setBigToken(Token bigToken) {
        if(getBigToken().isNil())
            tokens.add(0, bigToken);
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
    public void take(Token token) {
        switch (token.getSize()) {
            case SMALL:
                setSmallToken(token);
                break;
            case MEDIUM:
                setMidToken(token);
                break;
            case BIG:
                setBigToken(token);
                break;
            default:
                break;
        }
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
