package game;
import Nodes.RoundTile;
import board.SquareBoard;
import direction.Octagonal;
import rule.LinealRule;
import token.Ring;

//implementar metodos de juego
public class CrushRingsGame extends MatchGame<SquareBoard> {
    @Override
    public void initGame() {
        setBoard(new SquareBoard());
        setGamestate(GameState.GOING);
        setRule(new LinealRule());
        setMarcador(new Marcador());
        setMostrador(new Mostrador());

        do{
            ;
        }while(true);
    }

    @Override
    public void updateGame() {
        ;
    }

    @Override
    public void makeAMove(){
        ;
    }
}
