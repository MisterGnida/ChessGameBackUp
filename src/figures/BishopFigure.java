package figures;

import game.Board;

//слон  ОФИЦЕР
public class BishopFigure implements Figureable{
    private Figure bishop;

    public BishopFigure(int x, int y, boolean color, String name){
        bishop = new Figure();
        bishop.setColor(color);
        bishop.setX(x);
        bishop.setY(y);
        bishop.setName(name);

    }

    public String getName(){
        return bishop.getName();
    }

    @Override
    public String toString() {
        return bishop.getName();
    }

    @Override
    public Boolean reChecking(int x_1, int y_1, int x_2, int y_2, Board board) {

        return null;
    }
}
