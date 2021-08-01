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
public class CrushRingsGame extends MatchGame<Ring, Octagonal, RoundCell<Ring, Octagonal>, SquareBoard> {
    @Override
    public void initGame() {
        //initialize game entities
        setBoard(new SquareBoard());
        setGamestate(GameState.GOING);
        setRule(new CrushRingsRule());
        setMarcador(new Marcador());
        setMostrador(new MostradorCrushRings(3));

        //game main loop
        mainGame();
    }

    private void mainGame(){
        //game main loop
        getMostrador().showMostrador();
        Container<Ring> currToken;
        RoundCell<Ring, Octagonal> currCell;
        do{
            do{
                currToken = readToken();
                currCell = readCell();
            }while(!getBoard().placeTokenAtCell(currToken, currCell));

            getMostrador().update(currToken); //remove currToken from mostrador

            boolean hayMatch = getRule().match(currCell, getMarcador());
            if(hayMatch)
                System.out.println("Hay match!");
            getBoard().showBoard();
            getMarcador().showCont();
            if(getMostrador().isEmpty())
                getMostrador().fill();
            getMostrador().showMostrador();
            updateGame();
        }while(getGamestate() == GameState.GOING);
    }

    private Container<Ring> readToken(){
        Container<Ring> readContainer;
        int indContainer = 0;
        Scanner myInput = new Scanner(System.in);
        do {
            try {
                System.out.print("Introduzca indice de ficha que quiere elegir: ");
                indContainer = myInput.nextInt();
            }catch(InputMismatchException e){
                System.out.println("ENTER A NUMBER");
            }
            myInput.nextLine();
        }while(indContainer<1 || indContainer >3);
        readContainer = getMostrador().getContainer(indContainer);
        return readContainer;
    }

    private RoundCell<Ring, Octagonal> readCell(){
        RoundCell<Ring, Octagonal> readCell;
        int indCell = 0;
        Scanner myInput = new Scanner(System.in);
        do{
            try {
                System.out.print("Introduzca indice de la casilla que quiere elegir: ");
                indCell = myInput.nextInt();
            }catch(InputMismatchException e){
                System.out.println("ENTER A NUMBER");
            }
        }while(indCell <1 || indCell>9);
        readCell = getBoard().getCell(indCell);
        return readCell;
    }

    @Override
    public void updateGame(){
        ArrayList<Container<Ring>> MostradorList = getMostrador().mostrador;

        for(Container<Ring> currContainer: MostradorList){
            if(currContainer.isNotEmpty() && getBoard().isAPlay(currContainer)) return;
        }
        setGamestate(GameState.LOST);
    }
}

class CrushRingsRule extends LinealRule<Ring, Octagonal>{}
