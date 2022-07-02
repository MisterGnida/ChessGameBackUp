package figures;

import game.Board;

public class WhiteCell implements Figureable{
    String name = "00";

    public String getName() {
        return name;
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
