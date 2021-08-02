package token;

public class BigRing extends Ring{
    public BigRing(Color color){
        super(color);
    }

    public BigRing(){
        super();
    }

    @Override
    public void set(Token token){
        if(token instanceof BigRing)
            setColor(token.getColor());
    }

    @Override
    public String toString(){
        return String.format("BIG %s RING", getColor());
    }
}
