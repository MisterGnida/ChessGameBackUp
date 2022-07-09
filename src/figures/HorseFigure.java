package figures;

import game.Board;

//конь
//все ходы реализованы проверено by vladilshk
// rechecking в доработке не нуждается
public class HorseFigure implements Figureable {
    private final Figure horse;

    public HorseFigure(int x, int y, boolean color, String name) {
        horse = new Figure();
        horse.setColor(color);
        horse.setX(x);
        horse.setY(y);
        horse.setName(name);
    }

    public boolean getHasMoved() {
        return false;
    }

    @Override
    public void setHasMoved() {

    }

    @Override
    public void setX(int x) {
        horse.setX(x);
    }

    @Override
    public void setY(int y) {
        horse.setY(y);
    }

    @Override
    public int getX() {
        return horse.getX();
    }

    @Override
    public int getY() {
        return horse.getY();
    }

    public Boolean getColor() {
        return horse.getColor();
    }

    public String getName() {
        return horse.getName();
    }

    public String toString() {
        return horse.getName();
    }

    @Override
    public Boolean reChecking(int x_1, int y_1, int x_2, int y_2, Board board) {
        //2 вперёд
        if (x_2 - x_1 == 2 && (y_2 - y_1 == 1 || y_1 - y_2 == 1)) {
            return true;
        }

        //2 назад
        if (x_1 - x_2 == 2 && (y_2 - y_1 == 1 || y_1 - y_2 == 1)) {
            return true;
        }

        //2 вправо
        if (y_2 - y_1 == 2 && (x_2 - x_1 == 1 || x_1 - x_2 == 1)) {
            return true;
        }

        //2 влево
        if (y_1 - y_2 == 2 && (x_2 - x_1 == 1 || x_1 - x_2 == 1)) {
            return true;
        }
        return false;
    }
}
