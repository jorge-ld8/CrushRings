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
        //mostrar marcador y tablero
        getBoard().showBoard();
        getMostrador().showMostrador();

        //game main loop
        Container<Token> currToken;
        RoundCell<Token, Octagonal> currCell;
        outer:
        do{
            do{
                currToken = readToken();
                if(!currToken.isNotEmpty()) { //way to exit the program before finishing
                    setGamestate(GameState.LOST);
                    continue outer;
                }
                currCell = readCell();
                System.out.println();
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
                if(indContainer == -1)break;
                readContainer = getMostrador().getContainer(indContainer);
            }catch(InputMismatchException e){
                System.out.println("ENTER A NUMBER");
            }
            catch(IllegalArgumentException e){
                System.out.println("TOME UNA FICHA VALIDA");
            }
            myInput.nextLine();
        }while(indContainer<1 || indContainer >getMostrador().size() || !readContainer.isNotEmpty());
        return readContainer;
    }

    private RoundCell<Token, Octagonal> readCell(){
        RoundCell<Token, Octagonal> readCell = null;
        int indCell = 0;
        Scanner myInput = new Scanner(System.in);
        do{
            try {
                System.out.print("Introduzca indice de la casilla que quiere elegir: ");
                indCell = myInput.nextInt();
                readCell = getBoard().getCell(indCell);
            }catch(InputMismatchException e){
                System.out.println("INTRODUZCA UN NUMERO");
            }
            catch(IllegalArgumentException e){
                System.out.println("INTRODUZCA UNA CASILLA VALIDA");
            }
            myInput.nextLine();
        }while(indCell <1 || indCell>9);
        return readCell;
    }

    @Override
    public void updateGame(){
        ArrayList<Container<Token>> MostradorList = getMostrador().mostrador;
        for(Container<Token> currContainer: MostradorList){
            if(currContainer.isNotEmpty() && getBoard().isAPlay(currContainer))
                return;
        }
        System.out.printf("GAME OVER!\n\nPUNTAJE: %d", getMarcador().getCont());
        setGamestate(GameState.LOST);
    }
}

class CrushRingsRule extends LinealRule<Token, Octagonal>{}
