package board;
import token.*;

public class boardTest {
    public static void main(String[] args) {
        SquareBoard myBoard = new SquareBoard();
        myBoard.placeTokenAtCell(new TripleContainer(new Ring(Color.BLUE, Size.MEDIUM)), myBoard.getCell(1));
        myBoard.placeTokenAtCell(new TripleContainer(new Ring(Color.BLUE, Size.SMALL)), myBoard.getCell(2));
        myBoard.placeTokenAtCell(new TripleContainer(new Ring(Color.BLUE, Size.BIG)), myBoard.getCell(3));
        myBoard.placeTokenAtCell(new TripleContainer(new Ring(Color.GREEN, Size.MEDIUM)), myBoard.getCell(4));
        myBoard.showBoard();
    }
}
