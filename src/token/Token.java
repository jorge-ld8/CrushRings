package token;
import functionalInterfaces.Drawable;

public abstract class Token implements Drawable {
    protected Color color;

    //getters
    public Color getColor(){ return color;}

    //setters
    public void setColor(Color color){ this.color = color;}

    public abstract void set(Token token);

    public abstract boolean isNotNil();

    public abstract void clean();
}
