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
        return String.format("%s BIG %s%s", getColor().getColorRepresentation(), super.toString(), ColorConstants.TEXT_RESET);
    }
}
