package game;
import token.*;
import direction.*;
import Nodes.*;
import board.*;
import rule.*;

public abstract class MatchGame<B extends Board>{
    private GameState gamestate;
    private B board;
    private Rule rule;
    private Marcador marcador;
    private Mostrador mostrador;

    public abstract void initGame();

    public void setRule(Rule rule){ this.rule = rule;}

    public void setBoard(B board){
        this.board = board;
    }

    public B getBoard() {
        return board;
    }

    public GameState getGamestate() {
        return gamestate;
    }

    public Mostrador getMostrador() {
        return mostrador;
    }

    public Marcador getMarcador(){ return marcador;}

    public Rule getRule() {
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

    public abstract void makeAMove();
}
