package direction;

public interface Direction {
    <T extends Direction> T opposite();
}
