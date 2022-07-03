package figures;

import game.Board;

public class KingFigure implements Figureable{
    private Figure king;

    public KingFigure(int x, int y, boolean color, String name){
        king = new Figure();
        king.setColor(color);
        king.setX(x);
        king.setY(y);
        king.setName(name);
    }

    public Boolean getColor(){
        return king.getColor();
    }

    public String getName(){
        return king.getName();
    }

   @Override
    public String toString() {
        return king.getName();
    }

    @Override
    public Boolean reChecking(int x_1, int y_1, int x_2, int y_2, Board board) {
        return null;
    }

}
