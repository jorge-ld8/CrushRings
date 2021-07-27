package token;

public abstract class Token {
    protected Color color;
    protected Size size;

    //getters
    public Color getColor(){
        return color;
    }

    public Size getSize(){
        return size;
    }

    //setters
    public void setColor(Color color){ this.color = color;}

    public void setSize(Size size){this.size = size;}

    public boolean isSize(Size size){return getSize() == size;}

    //draw the token
    public abstract void draw();

    //return True if empty, false otherwise

    public abstract boolean isNil();

    public void clean(){
        this.color = Color.EMPTY;
        this.size = Size.EMPTY;
    }
}
