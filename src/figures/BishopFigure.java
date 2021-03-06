package figures;

import game.Board;

//слон  ОФИЦЕР
public class BishopFigure implements Figureable {
    private final Figure bishop;

    public BishopFigure(int x, int y, boolean color, String name) {
        bishop = new Figure();
        bishop.setColor(color);
        bishop.setX(x);
        bishop.setY(y);
        bishop.setName(name);

    }

    public String getName() {
        return bishop.getName();
    }

    public Boolean getColor() {
        return bishop.getColor();
    }

    @Override
    public boolean getHasMoved() {
        return false;
    }

    @Override
    public void setHasMoved() {

    }

    @Override
    public void setX(int x) {
        bishop.setX(x);
    }

    @Override
    public void setY(int y) {
        bishop.setY(y);
    }

    @Override
    public int getX() {
        return bishop.getX();
    }

    @Override
    public int getY() {
        return bishop.getY();
    }

    @Override
    public boolean isDoubleStep() {
        return false;
    }

    @Override
    public String toString() {
        return bishop.getName();
    }

    @Override
    public Boolean reChecking(int x_1, int y_1, int x_2, int y_2, Board board) {
        if (x_2 > x_1 && y_2 > y_1 && (x_2 - x_1 == y_2 - y_1)) {
            int y = y_1;
            for (int x = x_1 + 1; x < x_2; x++) {
                y++;
                if (!(board.getElement(x, y).getName().equals("11")) && !(board.getElement(x, y).getName().equals("00"))) {
                    return false;
                }
            }
            return true;
        }
        //диагональ лево вверх white
        if (x_2 > x_1 && y_2 < y_1 && (x_2 - x_1 == y_1 - y_2)) {
            int y = y_1;
            for (int x = x_1 + 1; x < x_2; x++) {
                y--;
                if (!(board.getElement(x, y).getName().equals("11")) && !(board.getElement(x, y).getName().equals("00"))) {
                    return false;
                }
            }
            return true;
        }
        //диагональ право вниз white
        if (x_2 < x_1 && y_2 > y_1 && (x_1 - x_2 == y_2 - y_1)) {
            int y = y_1;
            for (int x = x_1 - 1; x > x_2; x--) {
                y++;
                if (!(board.getElement(x, y).getName().equals("11")) && !(board.getElement(x, y).getName().equals("00"))) {
                    return false;
                }
            }
            return true;
        }
        //диагональ лево вниз white
        if (x_2 < x_1 && y_2 < y_1 && (x_1 - x_2 == y_1 - y_2)) {
            int y = y_1;
            for (int x = x_1 - 1; x > x_2; x--) {
                y--;
                if (!(board.getElement(x, y).getName().equals("11")) && !(board.getElement(x, y).getName().equals("00"))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
