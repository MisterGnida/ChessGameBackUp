package figures;

import game.Board;

//пешка
//все ходы реализованы проверено by vladilshk
// нужно добавить превращение в другие фигуры и разобраться с пролетом
public class PawnFigure implements Figureable {
    private final Figure pawn;
    private boolean hasMoved;
    private boolean doubleStep;

    public PawnFigure(int x, int y, boolean color, String name) {
        pawn = new Figure();
        pawn.setColor(color);
        pawn.setX(x);
        pawn.setY(y);
        pawn.setName(name);
        hasMoved = false;

    }

    public Boolean getColor() {
        return pawn.getColor();
    }

    @Override
    public boolean getHasMoved() {
        return false;
    }

    @Override
    public void setHasMoved() {
        hasMoved = true;
    }

    @Override
    public void setX(int x) {
        pawn.setX(x);
    }

    @Override
    public void setY(int y) {
        pawn.setY(y);
    }

    @Override
    public int getX() {
        return pawn.getX();
    }

    @Override
    public int getY() {
        return pawn.getY();
    }

    public String getName() {
        return pawn.getName();
    }

    @Override
    public String toString() {
        return pawn.getName();
    }

    @Override
    public Boolean reChecking(int x_1, int y_1, int x_2, int y_2, Board board) {

        //white double step
        if (x_2 - x_1 == 2 && !(this.getColor()) && y_1 == y_2 && !hasMoved) {
            if (board.getElement(x_2 - 1, y_2).getName().equals("11") || board.getElement(x_2 - 1, y_2).getName().equals("00")) {
                if ((board.getElement(x_2, y_2).getName().equals("11") || board.getElement(x_2, y_2).getName().equals("00"))) {
                    setHasMoved();
                    doubleStep = true;
                    return true;
                }
            }
        }
        //black double step
        if (x_1 - x_2 == 2 && (this.getColor()) && y_1 == y_2 && !hasMoved) {
            if (board.getElement(x_2 + 1, y_2).getName().equals("11") || board.getElement(x_2 + 1, y_2).getName().equals("00")) {
                if ((board.getElement(x_2, y_2).getName().equals("11") || board.getElement(x_2, y_2).getName().equals("00"))) {
                    setHasMoved();
                    doubleStep = true;
                    return true;
                }
            }
        }

        //white oneStep
        if (x_2 - x_1 == 1 && !(this.getColor()) && y_1 == y_2 && (board.getElement(x_2, y_2).getName().equals("11") || board.getElement(x_2, y_2).getName().equals("00"))) {
            setHasMoved();
            return true;
        }

        //black oneStep
        if (x_1 - x_2 == 1 && (this.getColor()) && y_1 == y_2 && (board.getElement(x_2, y_2).getName().equals("11") || board.getElement(x_2, y_2).getName().equals("00"))) {
            setHasMoved();
            return true;
        }

        //white eat
        if (x_2 - x_1 == 1 && !(this.getColor()) && ((y_2 - y_1 == 1) || (y_1 - y_2 == 1))) {
            if (!(board.getElement(x_2, y_2).getName().equals("11")) && !(board.getElement(x_2, y_2).getName().equals("00"))) {
                setHasMoved();
                return true;
            }
        }

        //black eat
        if (x_1 - x_2 == 1 && this.getColor() && ((y_2 - y_1 == 1) || (y_1 - y_2 == 1))) {
            if (!(board.getElement(x_2, y_2).getName().equals("11")) && !(board.getElement(x_2, y_2).getName().equals("00"))) {
                setHasMoved();
                return true;
            }
        }

        return false;
    }

    public boolean isDoubleStep() {
        return doubleStep;
    }
}
