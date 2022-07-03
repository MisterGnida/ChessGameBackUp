package game;

import figures.*;

import java.util.Scanner;

public class ChessGame {
    public static final int MAX_SIZE = 8;

    private final Board board;

    public ChessGame(){
        this.board = new Board();
        startGame();
    }

    public void startGame(){
        Scanner sc = new Scanner(System.in);
        int x_1 = sc.nextInt();
        int y_1 = sc.nextInt();
        int x_2 = sc.nextInt();
        int y_2 = sc.nextInt();
        move(x_1, y_1, x_2, y_2);
    }

    public boolean move(int x_1, int y_1, int x_2, int y_2){

       // System.out.println(board.getBody()[x_1][y_1].reChecking(x_1, y_1, x_2, y_2, board));
        if(check(x_1, y_1, x_2, y_2)) {
            board.setElement(x_2, y_2, board.getElement(x_1, y_1));
            initNullCell(x_1, y_1);
            board.printBoard();
        }
        return true;
    }

    public void whichFigure(){
        //Figureable fig = new PawnFigure();
    }

    public void initNullCell(int x_1, int y_1){
        WhiteCell whiteCell = new WhiteCell();
        BlackCell blackCell = new BlackCell();

        if (x_1 + y_1 % 2 == 1){
            board.setElement(x_1, y_1, blackCell);
        } else {
            board.setElement(x_1, y_1, whiteCell);
        }
    }

    public boolean check(int x_1, int y_1, int x_2, int y_2){
        if(x_2 > 7 || y_2 > 7){
            return false;
        }
        return true;
    }
    public Board getBoard() {
        return board;
    }
}
