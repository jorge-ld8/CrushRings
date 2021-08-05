package direction;

public interface Direction {
    <D extends Direction> D opposite();
}
