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
        while (true) {
            Scanner sc = new Scanner(System.in);
            int x_1 = sc.nextInt();
            int y_1 = sc.nextInt();
            int x_2 = sc.nextInt();
            int y_2 = sc.nextInt();
            move(x_1, y_1, x_2, y_2);

        }
    }

    public boolean move(int x_1, int y_1, int x_2, int y_2){
        //проверка рокировки

        if(castlingCheck(x_1, y_1, x_2, y_2)) {
            board.getElement(x_1, y_1).setHasMoved();
            board.getElement(x_2, y_2).setHasMoved();
            String str = board.getElement(x_2, y_2).getName();
            Figureable Rook = board.getElement(x_2, y_2);
            board.setElement(x_2, y_2, board.getElement(x_1, y_1));
            board.setElement(x_1, y_1, Rook);
            board.printBoard();
            return true;
        }

        //обычный ход
        if(check(x_1, y_1, x_2, y_2)) {
            if(board.getElement(x_1, y_1).reChecking(x_1, y_1, x_2, y_2, board)) {
                board.setElement(x_2, y_2, board.getElement(x_1, y_1));
                initNullCell(x_1, y_1);
                board.printBoard();
            }
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
        if(board.getElement(x_2, y_2).getName().equals("11") || board.getElement(x_2, y_2).getName().equals("00")) {
            return true;
        }
        if(board.getElement(x_1, y_1).getColor().equals(board.getElement(x_2, y_2).getColor())){
            return false;
        }
        return true;
    }
    //рокировка
    //вроде работает, но нужно тестрировать
    public boolean castlingCheck(int x_1, int y_1, int x_2, int y_2){
        if((board.getElement(x_1, y_1).getName().charAt(0) == 'K' && board.getElement(x_2, y_2).getName().charAt(0) == 'R') || (board.getElement(x_1, y_1).getName().charAt(0) == 'R' && board.getElement(x_2, y_2).getName().charAt(0) == 'K') ) {
            if (board.getElement(x_1, y_1).getColor() == board.getElement(x_2, y_2).getColor()) {
                if (!board.getElement(x_1, y_1).getHasMoved() && !board.getElement(x_2, y_2).getHasMoved()) {
                    if (y_1 < y_2) {
                        for (int y = y_1 + 1; y < y_2; y++) {
                            if (!board.getElement(x_1, y).getName().equals("11") && !board.getElement(x_1, y).getName().equals("00")) {
                                return false;
                            }
                        }
                        return true;
                    }
                    if (y_1 > y_2) {
                        for (int y = y_2 + 1; y < y_1; y++) {
                            if (!board.getElement(x_1, y).getName().equals("11") && !board.getElement(x_1, y).getName().equals("00")) {
                                return false;
                            }
                        }
                        return true;
                    }

                }
            }
        }
        return false;
    }
    //взятие на прозоде
    public void takingOnThePassCheck(){

    }

    // замена пешки
    public void pawnUpdate(){

    }

    public Board getBoard() {
        return board;
    }
}
