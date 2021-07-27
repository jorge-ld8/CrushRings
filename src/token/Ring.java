package token;

public final class Ring extends Token{
    //think about restrictions about input vals

    public Ring(){
        this(Color.EMPTY, Size.EMPTY);
    }

    //constructor
    public Ring(Color color, Size size){
        this.color = color;
        this.size = size;
    }

    public void draw(){
        System.out.printf("A %s %s Ring", getSize(), getColor());
    }

    public boolean isEmpty() {
        return getColor() == Color.EMPTY || getSize() == Size.EMPTY;
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof Ring otherRing)) return false;
        return getColor() != Color.EMPTY && getColor() == otherRing.getColor();
    }

    public void clean(){
        setColor(Color.EMPTY);
        setSize(Size.EMPTY);
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public String toString(){
        return String.format("%s %s token", getSize(), getColor());
    }
}
