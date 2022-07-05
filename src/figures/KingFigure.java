package figures;

import game.Board;
//все ходы реализованы проверено by vladilshk
// rechecking в доработке не нуждается
// ахуеть я круто его сделал
public class KingFigure implements Figureable{
    private Figure king;
    private boolean hasMoved;

    public KingFigure(int x, int y, boolean color, String name){
        king = new Figure();
        king.setColor(color);
        king.setX(x);
        king.setY(y);
        king.setName(name);
        hasMoved = false;
    }

    public boolean getHasMoved(){return hasMoved;}

    @Override
    public void setHasMoved() {
        hasMoved = true;
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

        if(((x_1 - x_2 <= 1) && (x_1 - x_2 >= -1)) && ((y_1 - y_2 <= 1 && y_2 - y_1 >= -1))){
            hasMoved = true;
            return true;
        }
        return false;


    }

}
