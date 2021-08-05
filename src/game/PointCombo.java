package game;

public class PointCombo{
    private int multiplier;

    public PointCombo(){
        multiplier = 1;
    }

    public void incMultiplier(){multiplier++;}

    public int getMultiplier(){return multiplier;}

    public void reset(){multiplier = 1;}
}
