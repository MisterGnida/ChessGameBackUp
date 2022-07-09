package figures;

import game.Board;

public class BlackCell implements Figureable {
    private final String name = "11";

    @Override
    public Boolean reChecking(int x_1, int y_1, int x_2, int y_2, Board board) {
        return null;
    }

    public Boolean getColor() {
        return true;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    public boolean getHasMoved() {
        return false;
    }

    @Override
    public void setHasMoved() {

    }
}
