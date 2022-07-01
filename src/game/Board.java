public class Board {
    Object[][] board;

    public Board(){
        this.board = new Object[ChessGame.MAX_SIZE][ChessGame.MAX_SIZE];
    }

    public void add(Object newFigure){

    }

    public void printBoard(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < ChessGame.MAX_SIZE; i++) {
            str.append("[");
            for (int j = 0; j < ChessGame.MAX_SIZE; j++) {
                str.append(" ");
                str.append(board[i][j].toString());
                str.append(" ");
            }

            str.append("]");
            str.append("\n");
        }
        String finishedStr = String.valueOf(str);
        System.out.println(finishedStr);
    }
}
