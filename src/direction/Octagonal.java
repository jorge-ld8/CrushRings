package direction;

public enum Octagonal implements Direction {
        UP,
        UP_RIGHT,
        RIGHT,
        DOWN_RIGHT,
        DOWN,
        DOWN_LEFT,
        LEFT,
        UP_LEFT;

        public  Octagonal opposite(){
            return switch (this) {
                case UP -> DOWN;
                case UP_RIGHT -> DOWN_LEFT;
                case RIGHT -> LEFT;
                case DOWN_RIGHT -> UP_LEFT;
                case DOWN -> UP;
                case DOWN_LEFT -> UP_RIGHT;
                case LEFT -> RIGHT;
                case UP_LEFT -> DOWN_RIGHT;
            };
        }
}
