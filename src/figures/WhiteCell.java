package figures;

import game.Board;

public class WhiteCell implements Figureable {
    private final String name = "00";

    public String getName() {
        return name;
    }

    public Boolean getColor() {
        return false;
    }

    public boolean getHasMoved() {
        return false;
    }

    @Override
    public void setHasMoved() {

    }

    @Override
    public void setX(int x) {

    }

    @Override
    public void setY(int y) {

    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Boolean reChecking(int x_1, int y_1, int x_2, int y_2, Board board) {
        return null;
    }

}
