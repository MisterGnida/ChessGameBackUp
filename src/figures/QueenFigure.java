package figures;

import game.Board;
//все ходы реализованы проверено by vladilshk
// rechecking в доработке не нуждается
public class QueenFigure implements Figureable{
    Figure queen;
    public QueenFigure(int x, int y, boolean color, String name){
        queen = new Figure();
        queen.setColor(color);
        queen.setX(x);
        queen.setY(y);
        queen.setName(name);

    }

    public Boolean getColor(){
        return queen.getColor();
    }

    public String getName(){
        return queen.getName();
    }

    public String toString(){
        return queen.getName();
    }

    @Override
    public Boolean reChecking(int x_1, int y_1, int x_2, int y_2, Board board) {
        //вперёд white назад black
        if(y_1 == y_2 && x_1 < x_2){
            for (int x = x_1 + 1; x < x_2; x++) {
                if(!(board.getElement(x, y_1).getName().equals("11")) && !(board.getElement(x, y_1).getName().equals("00"))){
                    return false;
                }
            }
            return true;
        }

        //назад white вперёд black
        if(y_1 == y_2 && x_1 > x_2){
            for (int x = x_1 - 1; x > x_2; x--) {
                if(!(board.getElement(x, y_1).getName().equals("11")) && !(board.getElement(x, y_1).getName().equals("00"))){
                    return false;
                }
            }
            return true;
        }
        //право
        if(x_1 == x_2 && y_1 < y_2){
            for (int y = y_1 + 1; y < y_2; y++) {
                if(!(board.getElement(x_1, y).getName().equals("11")) && !(board.getElement(x_1, y).getName().equals("00"))){
                    return false;
                }
            }
            return true;
        }
        //лево
        if(x_1 == x_2 && y_1 > y_2){
            for (int y = y_1 - 1; y > y_2; y--) {
                if(!(board.getElement(x_1, y).getName().equals("11")) && !(board.getElement(x_1, y).getName().equals("00"))){
                    return false;
                }
            }
            return true;
        }

        //диагональ право вверх white
        if(x_2 > x_1 && y_2 > y_1 && (x_2 - x_1 == y_2 - y_1)){
            int y = y_1;
            for (int x = x_1 + 1; x < x_2; x++) {
                y++;
                if(!(board.getElement(x, y).getName().equals("11")) && !(board.getElement(x, y).getName().equals("00"))){
                    return false;
                }
            }
            return true;
        }
        //диагональ лево вверх white
        if(x_2 > x_1 && y_2 < y_1  && (x_2 - x_1 == y_1 - y_2)){
            int y = y_1;
            for (int x = x_1 + 1; x < x_2; x++) {
                y--;
                if(!(board.getElement(x, y).getName().equals("11")) && !(board.getElement(x, y).getName().equals("00"))){
                    return false;
                }
            }
            return true;
        }
        //диагональ право вниз white
        if(x_2 < x_1 && y_2 > y_1 && (x_1 - x_2 == y_2 - y_1)){
            int y = y_1;
            for (int x = x_1 - 1; x > x_2; x--) {
                y++;
                if(!(board.getElement(x, y).getName().equals("11")) && !(board.getElement(x, y).getName().equals("00"))){
                    return false;
                }
            }
            return true;
        }
        //диагональ лево вниз white
        if(x_2 < x_1 && y_2 < y_1  && (x_1 - x_2 == y_1 - y_2)){
            int y = y_1;
            for (int x = x_1 - 1; x > x_2; x--) {
                y--;
                if(!(board.getElement(x, y).getName().equals("11")) && !(board.getElement(x, y).getName().equals("00"))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean check(){

        return true;
    }

}
