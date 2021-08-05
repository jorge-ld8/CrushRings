package board;

public final class Graficador {
    public static void printLine(int width){
        System.out.println("\n");
        for(int j=0; j<=width; j++)
            System.out.print("-");
        System.out.println("\n");
    }
}
