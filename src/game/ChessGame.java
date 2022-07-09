package game;

import figures.*;

import java.util.Scanner;

public class ChessGame {
    public static final int MAX_SIZE = 8;
    private final Board board;
    private boolean player;

    private boolean checkWhite;
    private boolean checkBlack;

    private int whiteKingX;
    private int whiteKingY;

    private int blackKingX;
    private int blackKingY;

    public ChessGame() {
        this.board = new Board();
        this.player = false;
        whiteKingX = 0;
        whiteKingY = 4;

        blackKingX = 7;
        blackKingY = 4;

        checkBlack = false;
        checkWhite = false;
        startGame();
    }

    public void startGame() {
        while (true) {
            if (!player) {
                System.out.println("White step");
            }
            if (player) {
                System.out.println("Black step");
            }
            System.out.println("Enter the coordinates: ");
            Scanner sc = new Scanner(System.in);
            int x_1 = sc.nextInt();
            int y_1 = sc.nextInt();
            int x_2 = sc.nextInt();
            int y_2 = sc.nextInt();
            if ((!player && !board.getElement(x_1, y_1).getColor()) || (player && board.getElement(x_1, y_1).getColor())) {
                if (!move(x_1, y_1, x_2, y_2)) {
                    System.out.println("You can't do this step");
                } else {
                    player = !player;
                }
            } else if (player && !board.getElement(x_1, y_1).getColor()) {
                System.out.println("It's black turn now");
            } else if (!player && board.getElement(x_1, y_1).getColor()) {
                System.out.println("It's white turn now");
            }
        }
    }

    public boolean move(int x_1, int y_1, int x_2, int y_2) {
        //рокировка
        if (castlingCheck(x_1, y_1, x_2, y_2)) {
            board.getElement(x_1, y_1).setHasMoved();
            board.getElement(x_2, y_2).setHasMoved();
            Figureable Rook = board.getElement(x_2, y_2);
            board.setElement(x_2, y_2, board.getElement(x_1, y_1));
            board.getElement(x_2, y_2).setX(x_2);
            board.getElement(x_2, y_2).setY(y_2);

            if (board.getElement(x_2, y_2).getName().equals("KW")) {
                whiteKingX = x_2;
                whiteKingY = y_2;
            }
            if (board.getElement(x_2, y_2).getName().equals("KB")) {
                blackKingX = x_2;
                blackKingY = y_2;
            }
            board.setElement(x_1, y_1, Rook);
            board.getElement(x_1, y_1).setX(x_1);
            board.getElement(x_1, y_1).setY(y_1);
            board.printBoard();
            checkKing(true, this.board);
            checkKing(false, this.board);


            return true;
        }

        // замена пешки
        if (pawnUpdate(x_1, y_1, x_2, y_2)) {
            board.getElement(x_2, y_2).setX(x_2);
            board.getElement(x_2, y_2).setY(y_2);
            board.printBoard();
            checkKing(true, this.board);
            checkKing(false, this.board);
            return true;
        }

        // обычный ход
        if (check(x_1, y_1, x_2, y_2)) {
            if (board.getElement(x_1, y_1).reChecking(x_1, y_1, x_2, y_2, board)) {
                board.setElement(x_2, y_2, board.getElement(x_1, y_1));
                initNullCell(x_1, y_1);
                board.printBoard();
                if (board.getElement(x_2, y_2).getName().equals("KW")) {
                    whiteKingX = x_2;
                    whiteKingY = y_2;
                }
                if (board.getElement(x_2, y_2).getName().equals("KB")) {
                    blackKingX = x_2;
                    blackKingY = y_2;
                }
                board.getElement(x_2, y_2).setX(x_2);
                board.getElement(x_2, y_2).setY(y_2);

                checkKing(true, this.board);
                checkKing(false, this.board);
                return true;
            } else {
                System.out.println("Error\n");
            }
        }
        return false;
    }

    public void initNullCell(int x_1, int y_1) {
        WhiteCell whiteCell = new WhiteCell();
        BlackCell blackCell = new BlackCell();

        if ((x_1 + y_1) % 2 == 1) {
            board.setElement(x_1, y_1, blackCell);
        } else {
            board.setElement(x_1, y_1, whiteCell);
        }
    }

    public boolean check(int x_1, int y_1, int x_2, int y_2) {
        //your figure or not
        /*if(player != board.getElement(x_1, y_1).getColor()){
            return false;
        }*/
        //move off the board
        if (x_2 > 7 || y_2 > 7 || x_1 > 7 || y_1 > 7) {
            return false;
        }
        //move an empty cell
        if (board.getElement(x_1, y_1).getName().equals("11") || board.getElement(x_1, y_1).getName().equals("00")) {
            return false;
        }

        if (board.getElement(x_2, y_2).getName().equals("11") || board.getElement(x_2, y_2).getName().equals("00")) {
            return true;
        }

        return !board.getElement(x_1, y_1).getColor().equals(board.getElement(x_2, y_2).getColor());
    }

    //рокировка
    //вроде работает, но нужно тестрировать
    public boolean castlingCheck(int x_1, int y_1, int x_2, int y_2) {
        if ((board.getElement(x_1, y_1).getName().charAt(0) == 'K' && board.getElement(x_2, y_2).getName().charAt(0) == 'R') || (board.getElement(x_1, y_1).getName().charAt(0) == 'R' && board.getElement(x_2, y_2).getName().charAt(0) == 'K')) {
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
    public void takingOnThePassCheck() {

    }

    // замена пешки
    public boolean pawnUpdate(int x_1, int y_1, int x_2, int y_2) {
        if (!check(x_1, y_1, x_2, y_2)) {
            return false;
        }

        //white pawn
        if ((board.getElement(x_1, y_1).getName().equals("PW") && x_1 == 6 && x_2 == 7 && (y_1 == y_2 || y_1 - y_2 == 1 || y_1 - y_2 == -1)) || (board.getElement(x_1, y_1).getName().equals("PB") && x_1 == 1 && x_2 == 0 && (y_1 == y_2 || y_1 - y_2 == 1 || y_1 - y_2 == -1))) {
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
                if (number == 1) {
                    if (!localColor) {
                        QueenFigure newQueen = new QueenFigure(x_2, y_2, localColor, "QW");
                        board.setElement(x_2, y_2, newQueen);
                    } else {
                        QueenFigure newQueen = new QueenFigure(x_2, y_2, localColor, "QB");
                        board.setElement(x_2, y_2, newQueen);
                    }
                    return true;
                } else if (number == 2) {
                    if (!localColor) {
                        HorseFigure newHorse = new HorseFigure(x_2, y_2, localColor, "HW");
                        board.setElement(x_2, y_2, newHorse);
                    } else {
                        HorseFigure newHorse = new HorseFigure(x_2, y_2, localColor, "HB");
                        board.setElement(x_2, y_2, newHorse);
                    }
                    return true;
                } else if (number == 3) {
                    if (!localColor) {
                        RookFigure newRook = new RookFigure(x_2, y_2, localColor, "RW");
                        board.setElement(x_2, y_2, newRook);
                    }
                    if (localColor) {
                        RookFigure newRook = new RookFigure(x_2, y_2, localColor, "RB");
                        board.setElement(x_2, y_2, newRook);
                    }
                    return true;
                } else if (number == 4) {
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

    public boolean checkKing(boolean color, Board board) {

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                // если фигура противоположного цвета и не пустая клетка
                if (board.getElement(x, y).getColor().equals(!color) && !board.getElement(x, y).getName().equals("11") && !board.getElement(x, y).getName().equals("00")) {
                    if (!color) {
                        if (board.getElement(x, y).reChecking(x, y, whiteKingX, whiteKingY, board)) {
                            System.out.println("Check for white");
                            return true; // mat white
                        }
                    } else {
                        if (board.getElement(x, y).reChecking(x, y, blackKingX, blackKingY, board)) {
                            System.out.println("Check for black");
                            return true; // mat black
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean checkMate(boolean color) {
        //поставили шах белым, ход белого, проверяем все ходы, если ход возможен и шаха не будет, то возвращаем фолс

        Board newBoard = new Board();
        newBoard = board.copy();
        Figureable blackCell = new BlackCell();
        for (int x_1 = 0; x_1 < 8; x_1++) {
            for (int y_1 = 0; y_1 < 8; y_1++) {
                if (board.getElement(x_1, y_1).getColor().equals(color) && !board.getElement(x_1, y_1).getName().equals("11") && !board.getElement(x_1, y_1).getName().equals("00")) {
                    for (int x_2 = 0; x_2 < 8; x_2++) {
                        for (int y_2 = 0; y_2 < 8; y_2++) {
                            if (board.getElement(x_1, y_1).reChecking(x_1, y_1, x_2, y_2, board) && check(x_1, y_1, x_2, y_2)) {
                                newBoard = board.copy();
                                newBoard.setElement(x_2, y_2, board.getElement(x_1, x_2));
                                newBoard.setElement(x_1, y_1, blackCell);
                                if (!checkKing(color, newBoard)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }

        }
        return true;
    }

    public Board getBoard() {
        return board;
    }
}
