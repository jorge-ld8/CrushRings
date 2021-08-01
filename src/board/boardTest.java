package board;
import direction.Octagonal;
import game.Marcador;
import rule.LinealRule;
import token.*;

public class boardTest {
    public static void main(String[] args) {
        SquareBoard myBoard = new SquareBoard();
        LinealRule<Ring, Octagonal> myRule = new LinealRule<>();
        Marcador<Ring, Octagonal> myMarcador = new Marcador<>();
        myBoard.placeTokenAtCell(new TripleContainer<>(new Ring(Color.BLUE, Size.MEDIUM)), myBoard.getCell(1));
        myBoard.placeTokenAtCell(new TripleContainer<>(new Ring(Color.BLUE, Size.SMALL)), myBoard.getCell(7));
        myBoard.placeTokenAtCell(new TripleContainer<>(new Ring(Color.BLUE, Size.BIG)), myBoard.getCell(5));
        myBoard.placeTokenAtCell(new TripleContainer<>(new Ring(Color.GREEN, Size.MEDIUM)), myBoard.getCell(8));
        System.out.println(myRule.match(myBoard.getCell(8), myMarcador)? "HAY MATCH" : "NO HAY MATCH");;
    }
}
