package figures;

import game.Board;

public interface Figureable {
    String toString();

    Boolean reChecking(int x_1, int y_1, int x_2, int y_2, Board board);

    String getName();
}