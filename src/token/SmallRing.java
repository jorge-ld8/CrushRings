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
        //return String.format("%s %s %s, getColor().getColorRepresentation(),super.toString(), ColorConstants.TEXT_RESET);
        return String.format("%s %-10s%s", getColor().getColorRepresentation(),"SMALL "+super.toString(), ColorConstants.TEXT_RESET);
    }
}
