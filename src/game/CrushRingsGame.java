package game;
import board.SquareBoard;
import rule.LinealRule;

import java.util.Scanner;

//implementar metodos de juego
//abstraer para que en vez de un solo token sea un Container (extensible para 1 o mas tokens)

//TODO: cambiar diseño de clases Marcador y Lineal Rule tal que Regla solo se encargue de decir si hay match y marcador solo de contar puntos
//

public class CrushRingsGame extends MatchGame<SquareBoard> {
    @Override
    public void initGame() {
        //initialize game entities
        setBoard(new SquareBoard());
        setGamestate(GameState.GOING);
        setRule(new LinealRule());
        setMarcador(new Marcador());
        setMostrador(new Mostrador());

        //game main loop
        mainGame();
    }

    private void mainGame(){
        Scanner myInput = new Scanner(System.in);
        //game main loop
        do{
            //makeAMove();
            //if(hayMatch){
            //  llamar a objeto marcador en c/u de las direcciones
            //  llamar cleaner en c/u de las direcciones}
           //show marcador
            //if (mostrador is empty) fill mostrador;
            //updateGame();
            int x = 1;
        }while(getGamestate() == GameState.GOING);
    }

    //recibe una casilla y retorna true si hay match, false otherwise
    public boolean hayMatch(){
        return true;
    }

    //TODO: Se puede implementar ya
    @Override
    public void updateGame() {
        //si se puede hacer jugada con el mostrador y tablero actual sigue habiendo juego
        //si no no hay juego, se debe actualizar el gamestate a LOST
    }

    @Override
    public void makeAMove(){
        //do{
        //   take a token from Mostrador
        //   choose a cell from Board
        //}while(placeTokenAtCell(token, cell) is false);
        //mostrador.update()
    }
}
