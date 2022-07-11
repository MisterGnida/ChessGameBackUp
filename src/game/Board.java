package game;

import figures.*;

public class Board {
    //Object[][] body;
    private final Figureable[][] body;

    public Board() {
        this.body = new Figureable[ChessGame.MAX_SIZE][ChessGame.MAX_SIZE];
        fillBoard();
        createFigures();
        //printBoard();
    }

    public void createFigures() {
        // x - строка
        // У - столбик

        // КОРОЛЕВЫ
        QueenFigure queenWhite = new QueenFigure(0, 3, false, "QW");
        body[0][3] = queenWhite;
        QueenFigure queenBlack = new QueenFigure(7, 3, true, "QB");
        body[7][3] = queenBlack;

        // КОРОЛИ
        KingFigure kingWhite = new KingFigure(0, 4, false, "KW");
        body[0][4] = kingWhite;
        KingFigure kingBlack = new KingFigure(7, 4, true, "KB");
        body[7][4] = kingBlack;

        // КОНИ
        HorseFigure horseWhite_1 = new HorseFigure(0, 1, false, "HW");
        body[0][1] = horseWhite_1;
        HorseFigure horseWhite_2 = new HorseFigure(0, 6, false, "HW");
        body[0][6] = horseWhite_2;
        HorseFigure horseBlack_1 = new HorseFigure(7, 1, true, "HB");
        body[7][1] = horseBlack_1;
        HorseFigure horseBlack_2 = new HorseFigure(7, 6, true, "HB");
        body[7][6] = horseBlack_2;

        // ЛАДЬИ
        RookFigure rookWhite_1 = new RookFigure(0, 0, false, "RW");
        body[0][0] = rookWhite_1;
        RookFigure rookWhite_2 = new RookFigure(0, 7, false, "RW");
        body[0][7] = rookWhite_2;
        RookFigure rookBlack_1 = new RookFigure(7, 0, true, "RB");
        body[7][0] = rookBlack_1;
        RookFigure rookBlack_2 = new RookFigure(7, 7, true, "RB");
        body[7][7] = rookBlack_2;

        //ОШИЦЕРЫ
        BishopFigure bishopWhite_1 = new BishopFigure(0, 2, false, "BW");
        body[0][2] = bishopWhite_1;
        BishopFigure bishopWhite_2 = new BishopFigure(0, 5, false, "BW");
        body[0][5] = bishopWhite_2;
        BishopFigure bishopBlack_1 = new BishopFigure(7, 2, true, "BB");
        body[7][2] = bishopBlack_1;
        BishopFigure bishopBlack_2 = new BishopFigure(7, 5, true, "BB");
        body[7][5] = bishopBlack_2;

        // ПЕШКИ
        PawnFigure pawnWhite_1 = new PawnFigure(1, 0, false, "PW");
        body[1][0] = pawnWhite_1;
        PawnFigure pawnWhite_2 = new PawnFigure(1, 1, false, "PW");
        body[1][1] = pawnWhite_2;
        PawnFigure pawnWhite_3 = new PawnFigure(1, 2, false, "PW");
        body[1][2] = pawnWhite_3;
        PawnFigure pawnWhite_4 = new PawnFigure(1, 3, false, "PW");
        body[1][3] = pawnWhite_4;
        PawnFigure pawnWhite_5 = new PawnFigure(1, 4, false, "PW");
        body[1][4] = pawnWhite_5;
        PawnFigure pawnWhite_6 = new PawnFigure(1, 5, false, "PW");
        body[1][5] = pawnWhite_6;
        PawnFigure pawnWhite_7 = new PawnFigure(1, 6, false, "PW");
        body[1][6] = pawnWhite_7;
        PawnFigure pawnWhite_8 = new PawnFigure(1, 7, false, "PW");
        body[1][7] = pawnWhite_8;

        PawnFigure pawnBlack_1 = new PawnFigure(6, 0, true, "PB");
        body[6][0] = pawnBlack_1;
        PawnFigure pawnBlack_2 = new PawnFigure(6, 1, true, "PB");
        body[6][1] = pawnBlack_2;
        PawnFigure pawnBlack_3 = new PawnFigure(6, 2, true, "PB");
        body[6][2] = pawnBlack_3;
        PawnFigure pawnBlack_4 = new PawnFigure(6, 3, true, "PB");
        body[6][3] = pawnBlack_4;
        PawnFigure pawnBlack_5 = new PawnFigure(6, 4, true, "PB");
        body[6][4] = pawnBlack_5;
        PawnFigure pawnBlack_6 = new PawnFigure(6, 5, true, "PB");
        body[6][5] = pawnBlack_6;
        PawnFigure pawnBlack_7 = new PawnFigure(6, 6, true, "PB");
        body[6][6] = pawnBlack_7;
        PawnFigure pawnBlack_8 = new PawnFigure(6, 7, true, "PB");
        body[6][7] = pawnBlack_8;

    }

    public void fillBoard() {
        WhiteCell whiteCell = new WhiteCell();
        BlackCell blackCell = new BlackCell();
        for (int x = 0; x < ChessGame.MAX_SIZE; ++x) {
            for (int y = 0; y < ChessGame.MAX_SIZE; ++y) {
                if ((x + y) % 2 == 0) {
                    body[x][y] = /*"00"*/ whiteCell;
                } else {
                    body[x][y] = /*"11"*/ blackCell;
                }
            }
        }
    }

    public void printBoard() {
        StringBuilder str = new StringBuilder();
        str.append(" ");
        for (int i = 0; i < ChessGame.MAX_SIZE; i++) {
            str.append("   ");
            str.append(i);
        }

        str.append("\n");

        for (int x = 0; x < ChessGame.MAX_SIZE; x++) {
            str.append(x + " [");
            for (int y = 0; y < ChessGame.MAX_SIZE; y++) {
                str.append(" ");
                str.append(body[x][y].toString());
                str.append(" ");
            }

            str.append("]");
            str.append("\n");
        }
        String finishedStr = String.valueOf(str);
        System.out.println(finishedStr);
    }

    public Figureable[][] getBody() {
        return body;
    }

    public Figureable getElement(int x, int y) {
        return body[x][y];
    }

    public void setElement(int x, int y, Figureable obj) {
        body[x][y] = obj;
    }

    public Board copy() {
        Board newBoard = new Board();
        for (int i = 0; i < ChessGame.MAX_SIZE; ++i) {
            for (int j = 0; j < ChessGame.MAX_SIZE; ++j) {
                newBoard.body[i][j] = this.body[i][j];
            }
        }

        return newBoard;
    }
}


