package board;
import direction.Octagonal;
import game.Marcador;
import game.MarcadorCrushRings;
import rule.LinealRule;
import token.*;

public class boardTest {
    public static void main(String[] args) {
        SquareBoard myBoard = new SquareBoard();
        LinealRule<Token, Octagonal> myRule = new LinealRule<>();
        Marcador<Token, Octagonal> myMarcador = new MarcadorCrushRings();
        myBoard.placeTokenAtCell(new TripleContainer(new SmallRing(Color.BLUE)), myBoard.getCell(1));
        myBoard.placeTokenAtCell(new TripleContainer(new SmallRing(Color.BLUE)), myBoard.getCell(7));
        myBoard.placeTokenAtCell(new TripleContainer(new BigRing(Color.CYAN)), myBoard.getCell(5));
        myBoard.placeTokenAtCell(new TripleContainer(new MidRing(Color.BLUE)), myBoard.getCell(8));
        System.out.println(myRule.match(myBoard.getCell(8), myMarcador)? "HAY MATCH" : "NO HAY MATCH");
    }
}
