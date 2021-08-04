package token;

public abstract class Ring extends Token{
    //constructor
    public Ring(Color color){this.color = color;}

    public Ring(){
        this.color = Color.EMPTY;
    }

    public void draw(){}

    @Override
    public void clean(){
        setColor(Color.EMPTY);
    }

    public abstract void set(Token token);

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof Ring otherRing)) return false;
        return getColor() != Color.EMPTY && getColor() == otherRing.getColor();
    }

    @Override
    public boolean isNotNil(){
        return getColor() != Color.EMPTY;
    }

   // @Override
    //public String toString(){return String.format("%s %s token", getSize(), getColor());}
}
