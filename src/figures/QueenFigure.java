package figures;

import game.Board;

public class QueenFigure implements Figureable{
    Figure queen;
    public QueenFigure(int x, int y, boolean color, String name){
        queen = new Figure();
        queen.setColor(color);
        queen.setX(x);
        queen.setY(y);
        queen.setName(name);

    }

    public Boolean getColor(){
        return queen.getColor();
    }

    public String getName(){
        return queen.getName();
    }

    public String toString(){
        return queen.getName();
    }

    @Override
    public Boolean reChecking(int x_1, int y_1, int x_2, int y_2, Board board) {
        return null;
    }

    public boolean check(){

        return true;
    }

}
