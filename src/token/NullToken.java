package token;

public class NullToken extends Token{
    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public void draw(){;}
}
