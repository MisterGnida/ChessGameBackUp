package figures;

import game.Board;

//ладья
//все ходы реализованы проверены by vladilshk
// rechecking в доработке не нуждается
public class RookFigure implements Figureable {
    private final Figure rook;
    private boolean hasMoved;

    public RookFigure(int x, int y, boolean color, String name) {
        rook = new Figure();
        rook.setColor(color);
        rook.setX(x);
        rook.setY(y);
        rook.setName(name);
        hasMoved = false;
    }

    public boolean getHasMoved() {
        return hasMoved;
    }

    @Override
    public void setHasMoved() {
        hasMoved = true;
    }

    @Override
    public void setX(int x) {
        rook.setX(x);
    }

    @Override
    public void setY(int y) {
        rook.setY(y);
    }

    @Override
    public int getX() {
        return rook.getX();
    }

    @Override
    public int getY() {
        return rook.getY();
    }

    public Boolean getColor() {
        return rook.getColor();
    }

    public String getName() {
        return rook.getName();
    }

    @Override
    public String toString() {
        return rook.getName();
    }

    @Override
    public Boolean reChecking(int x_1, int y_1, int x_2, int y_2, Board board) {
        //вперёд white назад black
        if (y_1 == y_2 && x_1 < x_2) {
            for (int i = x_1 + 1; i < x_2; i++) {
                if (!(board.getElement(i, y_1).getName().equals("11")) && !(board.getElement(i, y_1).getName().equals("00"))) {
                    return false;
                }
            }
            hasMoved = true;
            return true;
        }

        //назад white вперёд black
        if (y_1 == y_2 && x_1 > x_2) {
            for (int i = x_1 - 1; i > x_2; i--) {
                if (!(board.getElement(i, y_1).getName().equals("11")) && !(board.getElement(i, y_1).getName().equals("00"))) {
                    return false;
                }
            }
            hasMoved = true;
            return true;
        }

        //право
        if (x_1 == x_2 && y_1 < y_2) {
            for (int i = y_1 + 1; i < y_2; i++) {
                if (!(board.getElement(x_1, i).getName().equals("11")) && !(board.getElement(x_1, i).getName().equals("00"))) {
                    return false;
                }
            }
            hasMoved = true;
            return true;
        }

        //лево
        if (x_1 == x_2 && y_1 > y_2) {
            for (int i = y_1 - 1; i > y_2; i--) {
                if (!(board.getElement(x_1, i).getName().equals("11")) && !(board.getElement(x_1, i).getName().equals("00"))) {
                    return false;
                }
            }
            hasMoved = true;
            return true;
        }

        return false;
    }

}
