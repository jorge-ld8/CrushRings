package token;

public class MidRing extends Ring{
    public MidRing(Color color){
        super(color);
    }

    public MidRing(){
        super();
    }

    @Override
    public void set(Token token){
        if(token instanceof MidRing)
            setColor(token.getColor());
    }

    @Override
    public String toString(){ return String.format("%sMID %s%s", getColor().getColorRepresentation(), super.toString(), ColorConstants.TEXT_RESET);}
}
