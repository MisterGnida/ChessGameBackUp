package figures;

import game.Board;

//ладья
public class RookFigure implements Figureable{
    private Figure rook;

    public RookFigure(int x, int y, boolean color, String name){
        rook = new Figure();
        rook.setColor(color);
        rook.setX(x);
        rook.setY(y);
        rook.setName(name);
    }

    public Boolean getColor(){
        return rook.getColor();
    }

    public String getName(){
        return rook.getName();
    }

    @Override
    public String toString() {
        return rook.getName();
    }

    @Override
    public Boolean reChecking(int x_1, int y_1, int x_2, int y_2, Board board) {
        return null;
    }
}
