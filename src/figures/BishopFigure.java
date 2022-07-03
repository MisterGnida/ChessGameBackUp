package figures;

import game.Board;

//слон  ОФИЦЕР
public class BishopFigure implements Figureable{
    private Figure bishop;

    public BishopFigure(int x, int y, boolean color, String name){
        bishop = new Figure();
        bishop.setColor(color);
        bishop.setX(x);
        bishop.setY(y);
        bishop.setName(name);

    }

    public String getName(){
        return bishop.getName();
    }

    @Override
    public String toString() {
        return bishop.getName();
    }

    @Override
    public Boolean reChecking(int x_1, int y_1, int x_2, int y_2, Board board) {
        String direction = "";
        int localX = x_1;
        int localY = y_1;
        boolean localColor = board.getElement(x_1, y_1).getColor();
        WhiteCell wc = new WhiteCell();
        BlackCell bc = new BlackCell();

        int differenceX = x_1 - x_2;
        if (differenceX < 0){
            differenceX = -differenceX;
        }

        int differenceY = y_1 - y_2;
        if (differenceY < 0){
            differenceY = -differenceY;
        }
        if (differenceX != differenceY){
            return false;
        } else {
            if (x_2 < x_1 && y_2 < y_1){
                direction = "leftUp";
            } else if (x_2 > x_1 && y_2 < y_1) {
                direction = "leftDown";
            } else if (x_2 > x_1 && y_2 > y_1) {
                direction = "rightDown";
            } else if (x_2 < x_1 && y_2 > y_1) {
                direction = "rightUp";
            }

            if (direction.equals("leftUp")){
                while(localX != x_2 && localY != y_2){
                    localX--;
                    localY--;
                    if ((localColor != board.getElement(localX, localY).getColor()) || (board.getElement(localX, localY).equals(wc)) || (board.getElement(localX, localY).equals(bc))){
                        System.out.println("im here");
                    }
                }
            }
        }
        return null;
    }
}
