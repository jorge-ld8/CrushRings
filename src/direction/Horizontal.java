package direction;

public enum Horizontal implements Direction {
    LEFT,
    RIGHT;

    public Horizontal opposite(){
        return switch(this){
            case LEFT -> RIGHT;
            case RIGHT -> LEFT;
        };
    }
}
