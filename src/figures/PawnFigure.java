package figures;

import game.Board;

//пешка
public class PawnFigure implements Figureable{
    private Figure pawn;

    public PawnFigure(int x, int y, boolean color, String name){
        pawn = new Figure();
        pawn.setColor(color);
        pawn.setX(x);
        pawn.setY(y);
        pawn.setName(name);

    }

    public String getName(){
        return pawn.getName();
    }

    @Override
    public String toString() {
        return pawn.getName();
    }

    @Override
    public Boolean reChecking(int x_1, int y_1, int x_2, int y_2, Board board) {

        board.getElement(x_1, y_1).getName();
        return true;
    }

}
