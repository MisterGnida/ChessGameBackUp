public class ChessGame {
    public static final int MAX_SIZE = 8;

    private final Board board;

    public ChessGame(){
        this.board = new Board();
        createGame(this.board);
    }


    private void createGame(Board gameBoard){
        for (int y = 0; y < ChessGame.MAX_SIZE; ++y){
            for (int x = 0; x < ChessGame.MAX_SIZE; ++x){
                if ((x + y) % 2 == 0) {
                    gameBoard.board[y][x] = "00";
                } else {
                    gameBoard.board[y][x] = "11";
                }
            }
        }

        gameBoard.printBoard();
    }

    public Board getBoard() {
        return board;
    }
}
