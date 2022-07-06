package game;

import figures.*;

import java.util.Scanner;

public class ChessGame {
    public static final int MAX_SIZE = 8;

    private final Board board;
    private boolean player;

    public ChessGame(){
        this.board = new Board();
        startGame();
        player = false;
    }

    public void startGame(){
        while (true) {
/*            if(!player){
                System.out.println("White step");
            }
            if(player){
                System.out.println("Black step");
            }*/
            System.out.println("Enter the coordinates: ");
            Scanner sc = new Scanner(System.in);
            int x_1 = sc.nextInt();
            int y_1 = sc.nextInt();
            int x_2 = sc.nextInt();
            int y_2 = sc.nextInt();
            if (!move(x_1, y_1, x_2, y_2)){
                System.out.println("You can't do this step");
            }
            /*else {
                if(!player){
                    player = true;
                }
                if(player){
                    player = false;
                }
            }*/
        }
    }

    public boolean move(int x_1, int y_1, int x_2, int y_2){
        //рокировка
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
        if(pawnUpdate(x_1, y_1, x_2, y_2)){
            board.printBoard();
            return true;
        }
        if(check(x_1, y_1, x_2, y_2)) {
            if(board.getElement(x_1, y_1).reChecking(x_1, y_1, x_2, y_2, board)) {
                board.setElement(x_2, y_2, board.getElement(x_1, y_1));
                initNullCell(x_1, y_1);
                board.printBoard();
                return true;
            } else {
                System.out.println("Error\n");
            }
        }
        return false;
    }

    public void whichFigure(){
        //Figureable fig = new PawnFigure();
    }

    public void initNullCell(int x_1, int y_1){
        WhiteCell whiteCell = new WhiteCell();
        BlackCell blackCell = new BlackCell();

        if ((x_1 + y_1) % 2 == 1){
            board.setElement(x_1, y_1, blackCell);
        } else {
            board.setElement(x_1, y_1, whiteCell);
        }
    }

    public boolean check(int x_1, int y_1, int x_2, int y_2){
        //your figure or not
        /*if(player != board.getElement(x_1, y_1).getColor()){
            return false;
        }*/
        //move off the board
        if(x_2 > 7 || y_2 > 7 || x_1 > 7 || y_1 > 7){
            return false;
        }
        //move an empty cell
        if(board.getElement(x_1, y_1).getName().equals("11") || board.getElement(x_1, y_1).getName().equals("00")){
            return false;
        }




        if(board.getElement(x_2, y_2).getName().equals("11") || board.getElement(x_2, y_2).getName().equals("00")) {
            return true;
        }

        return !board.getElement(x_1, y_1).getColor().equals(board.getElement(x_2, y_2).getColor());
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
    //взятие на проходе
    public void takingOnThePassCheck(){

    }

    // замена пешки
    public boolean pawnUpdate(int x_1, int y_1, int x_2, int y_2){
        if (!check(x_1, y_1, x_2, y_2)){
            return false;
        }

        //white pawn
        if((board.getElement(x_1, y_1).getName().equals("PW") && x_1 == 6 && x_2 == 7 && (y_1 == y_2 || y_1 - y_2 == 1 || y_1 - y_2 == -1)) || (board.getElement(x_1, y_1).getName().equals("PB") && x_1 == 1 && x_2 == 0 && (y_1 == y_2 || y_1 - y_2 == 1 || y_1 - y_2 == -1))) {
            boolean localColor = board.getElement(x_1, y_1).getColor();
            while (true) {
                System.out.println("Select the shape number:");
                System.out.println("1 - Queen");
                System.out.println("2 - Horse");
                System.out.println("3 - Rook");
                System.out.println("4 - Bishop");
                Scanner sc = new Scanner(System.in);
                int number = sc.nextInt();
                initNullCell(x_1, y_1);
                if (number == 1){
                    if (!localColor) {
                        QueenFigure newQueen = new QueenFigure(x_2, y_2, localColor, "QW");
                        board.setElement(x_2, y_2, newQueen);
                    } else {
                        QueenFigure newQueen = new QueenFigure(x_2, y_2, localColor, "QB");
                        board.setElement(x_2, y_2, newQueen);
                    }
                    return true;
                } else if (number == 2){
                    if (!localColor) {
                        HorseFigure newHorse = new HorseFigure(x_2, y_2, localColor, "HW");
                        board.setElement(x_2, y_2, newHorse);
                    } else {
                        HorseFigure newHorse = new HorseFigure(x_2, y_2, localColor, "HB");
                        board.setElement(x_2, y_2, newHorse);
                    }
                    return true;
                } else if (number == 3){
                    if(!localColor) {
                        RookFigure newRook = new RookFigure(x_2, y_2, localColor, "RW");
                        board.setElement(x_2, y_2, newRook);
                    }
                    if(localColor) {
                        RookFigure newRook = new RookFigure(x_2, y_2, localColor, "RB");
                        board.setElement(x_2, y_2, newRook);
                    }
                    return true;
                } else if (number == 4){
                    if (!localColor) {
                        BishopFigure newBishop = new BishopFigure(x_2, y_2, localColor, "BW");
                        board.setElement(x_2, y_2, newBishop);
                    }
                    if (localColor) {
                        BishopFigure newBishop = new BishopFigure(x_2, y_2, localColor, "BB");
                        board.setElement(x_2, y_2, newBishop);
                    }
                    return true;
                } else {
                    System.out.println("Enter number of the shape");
                }
            }
        }

        return false;
    }

    public Board getBoard() {
        return board;
    }
}
