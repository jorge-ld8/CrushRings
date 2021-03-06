package board;

import Nodes.*;
import direction.Octagonal;
import token.*;

public class SquareBoard extends Board<Token, Octagonal, RoundCell<Token, Octagonal>> {
    public SquareBoard(){
        //cell of the board
        super();
        for(int i=0; i<=8; i++)
            board.add(i, new RoundCell<>(new TripleContainer()));

        //adjacencies of cells created at runtime
        getCell(1).genAdjacency(getCell(2), Octagonal.RIGHT);
        getCell(1).genAdjacency(getCell(4), Octagonal.DOWN);
        getCell(1).genAdjacency(getCell(5), Octagonal.DOWN_RIGHT);

        getCell(2).genAdjacency(getCell(3), Octagonal.RIGHT);
        getCell(2).genAdjacency(getCell(5), Octagonal.DOWN);

        getCell(3).genAdjacency(getCell(6), Octagonal.DOWN);
        getCell(3).genAdjacency(getCell(5), Octagonal.DOWN_LEFT);

        getCell(4).genAdjacency(getCell(7), Octagonal.DOWN);
        getCell(4).genAdjacency(getCell(5), Octagonal.RIGHT);

        getCell(6).genAdjacency(getCell(9), Octagonal.DOWN);
        getCell(6).genAdjacency(getCell(5), Octagonal.LEFT);

        getCell(7).genAdjacency(getCell(8), Octagonal.RIGHT);
        getCell(7).genAdjacency(getCell(5), Octagonal.UP_RIGHT);

        getCell(8).genAdjacency(getCell(9), Octagonal.RIGHT);
        getCell(8).genAdjacency(getCell(5), Octagonal.UP);

        getCell(9).genAdjacency(getCell(5), Octagonal.UP_LEFT);
    }

    public void draw() {
        int i = 1;
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tTABLERO");
        Graficador.printLine(149);
        for (RoundCell cell : board) {
            System.out.printf("C%d ", i++);
            cell.draw();
            if((i-1) % 3 == 0)
                Graficador.printLine(149);
        }
        System.out.println();
    }
}
