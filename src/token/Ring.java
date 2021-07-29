package token;

public final class Ring extends Token{
    //think about restrictions about input vals
    //constructor
    public Ring(Color color, Size size){
        this.color = color;
        this.size = size;
    }

    public void draw(){}

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof Ring otherRing)) return false;
        return getColor() == otherRing.getColor();
    }

    @Override
    public boolean isNotNil() { return true;}

    @Override
    public String toString(){
        return String.format("%s %s token", getSize(), getColor());
    }
}
