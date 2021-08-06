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
        return String.format("%s %-10s%s", getColor().getColorRepresentation(),"BIG " + super.toString(), ColorConstants.TEXT_RESET);
    }

    public void draw(){
        System.out.printf("%s %-10s%s", getColor().getColorRepresentation(),"BIG " + super.toString(), ColorConstants.TEXT_RESET);
    }
}
