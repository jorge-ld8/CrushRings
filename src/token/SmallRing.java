package token;

public class SmallRing extends Ring{
    public SmallRing(Color color){
        super(color);
    }

    public SmallRing(){
        super();
    }

    @Override
    public void set(Token token){
        if(token instanceof SmallRing)
            setColor(token.getColor());
    }

    @Override
    public String toString(){
        return String.format("SMALL %s RING", getColor());
    }
}
