package game;
import token.*;
import direction.*;
import Nodes.*;
import board.*;
import rule.*;

public abstract class MatchGame<T extends Token, D extends Direction, C extends Cell<T,D>, B extends Board<T, D, C>>{
    private GameState gamestate; //X
    private B board; //X
    private Rule<T, D> rule; //X
    private Marcador marcador; //X
    private Mostrador<T> mostrador;

    public abstract void initGame();

    public void setRule(Rule<T, D> rule){ this.rule = rule;}

    public void setBoard(B board){
        this.board = board;
    }

    public B getBoard() {
        return board;
    }

    public GameState getGamestate() {
        return gamestate;
    }

    public Mostrador<T> getMostrador() {
        return mostrador;
    }

    public Marcador<T, D> getMarcador(){ return marcador;}

    public Rule<T, D> getRule() {
        return rule;
    }

    public void setGamestate(GameState gamestate){
        this.gamestate = gamestate;
    }

    public void setMarcador(Marcador marcador) {
        this.marcador = marcador;
    }

    public void setMostrador(Mostrador mostrador) {
        this.mostrador = mostrador;
    }

    public abstract void updateGame();
}
