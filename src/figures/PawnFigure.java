package figures;

import game.Board;

//пешка
public class PawnFigure implements Figureable{
    private Figure pawn;

    public PawnFigure(int x, int y, boolean color, String name){
        pawn = new Figure();
        pawn.setColor(color);
        pawn.setX(x);
        pawn.setY(y);
        pawn.setName(name);

    }

    public Boolean getColor(){
        return pawn.getColor();
    }

    public String getName(){
        return pawn.getName();
    }

    @Override
    public String toString() {
        return pawn.getName();
    }

    @Override
    public Boolean reChecking(int x_1, int y_1, int x_2, int y_2, Board board) {
        if(x_2 - x_1 == 2 && y_1 == y_2 ){
            if(board.getElement(x_2 - 1 , y_2).equals("11") || board.getElement(x_2 - 1, y_2).getName().equals("00")){
                if((board.getElement(x_2, y_2).equals("11") || board.getElement(x_2, y_2).equals("00"))){
                    return true;
                }
            }
        }

        if(x_2 - x_1 == 1 && y_1 == y_2 && (board.getElement(x_2, y_2).getName().equals("11") || board.getElement(x_2, y_2).getName().equals("00"))){
            return true;
        }

        if(x_2 - x_1 == 1 && ((y_2 - y_1 == 1) || (y_1 - y_2 == 1))){
            if(! (board.getElement(x_2, y_2).getName().equals("11")) || !(board.getElement(x_2, y_2).getName().equals("00"))){
                return true;
            }
        }

       /* move(1, 0, 2, 0);
        System.out.println("true");
        move(1, 1, 3, 1);
        System.out.println("true");
        move(1, 2, 4, 2);
        System.out.println("false");
        move(1, 3, 1, 4);
        System.out.println("false");
        move(1, 4, 2, 5);
        System.out.println("false");

        move(6, 2, 4, 2);
        System.out.println("true");
        move(3, 1, 4, 2);
        System.out.println("true");

        */


        return false;
    }

}
