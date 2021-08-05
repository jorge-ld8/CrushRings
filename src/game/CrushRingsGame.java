package game;
import Nodes.*;
import board.SquareBoard;
import rule.LinealRule;
import token.*;
import direction.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//implementar metodos de juego
//abstraer para que en vez de un solo token sea un Container (extensible para 1 o mas tokens)

//TODO: cambiar diseño de clases Marcador y Lineal Rule tal que Regla solo se encargue de decir si hay match y marcador solo de contar puntos
public class CrushRingsGame extends MatchGame<Token, Octagonal, RoundCell<Token, Octagonal>, SquareBoard> {
    @Override
    public void initGame() {
        //initialize game entities
        setBoard(new SquareBoard());
        setGamestate(GameState.GOING);
        setRule(new CrushRingsRule());
        setMarcador(new Marcador<>());
        setMostrador(new MostradorCrushRings());

        //game main loop
        mainGame();
    }

    private void mainGame(){
        //game main loop
        getMostrador().showMostrador();
        Container<Token> currToken;
        RoundCell<Token, Octagonal> currCell;
        do{
            do{
                currToken = readToken();
                currCell = readCell();
            }while(!getBoard().placeTokenAtCell(currToken, currCell));

            getMostrador().update(currToken); //remove currToken from mostrador

            boolean hayMatch = getRule().match(currCell, getMarcador());
            if(hayMatch) System.out.println("Hay match!");

            getBoard().showBoard();
            getMarcador().showCont();
            if(getMostrador().isEmpty())
                getMostrador().fill();
            getMostrador().showMostrador();
            updateGame();
        }while(getGamestate() == GameState.GOING);
    }

    private Container<Token> readToken(){
        Container<Token> readContainer = new TripleContainer();
        int indContainer = 0;
        Scanner myInput = new Scanner(System.in);
        do {
            try {
                System.out.print("Introduzca indice de ficha que quiere elegir: ");
                indContainer = myInput.nextInt();
                readContainer = getMostrador().getContainer(indContainer);
            }catch(InputMismatchException e){
                System.out.println("ENTER A NUMBER");
            }
            catch(IllegalArgumentException e){
                System.out.println("TOME UNA FICHA VALIDA");
            }
            myInput.nextLine();
        }while(indContainer<1 || indContainer >3 || !readContainer.isNotEmpty());
        return readContainer;
    }

    private RoundCell<Token, Octagonal> readCell(){
        RoundCell<Token, Octagonal> readCell;
        int indCell = 0;
        Scanner myInput = new Scanner(System.in);
        do{
            try {
                System.out.print("Introduzca indice de la casilla que quiere elegir: ");
                indCell = myInput.nextInt();
            }catch(InputMismatchException e){
                System.out.println("ENTER A NUMBER");
            }
            myInput.nextLine();
        }while(indCell <1 || indCell>9);
        readCell = getBoard().getCell(indCell);
        return readCell;
    }

    @Override
    public void updateGame(){
        ArrayList<Container<Token>> MostradorList = getMostrador().mostrador;
        for(Container<Token> currContainer: MostradorList){
            if(currContainer.isNotEmpty() && getBoard().isAPlay(currContainer))
                return;
        }
        setGamestate(GameState.LOST);
    }
}

class CrushRingsRule extends LinealRule<Token, Octagonal>{}
