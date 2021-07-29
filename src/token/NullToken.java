package token;

public class NullToken extends Token{
    @Override
    public boolean isNotNil() {return false;}

    @Override
    public void draw(){}

    @Override
    public String toString(){ return "EMPTY";}
}
