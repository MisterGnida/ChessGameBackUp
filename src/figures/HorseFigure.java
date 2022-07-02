package figures;

import game.Board;

//конь
public class HorseFigure implements Figureable{
    private Figure horse;

    public HorseFigure(int x, int y, boolean color, String name){
        horse = new Figure();
        horse.setColor(color);
        horse.setX(x);
        horse.setY(y);
        horse.setName(name);
    }

    public String getName(){
        return horse.getName();
    }

    public String toString() {
        return horse.getName();
    }

    @Override
    public Boolean reChecking(int x_1, int y_1, int x_2, int y_2, Board board) {
        return null;
    }
}
