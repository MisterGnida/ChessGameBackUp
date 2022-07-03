package figures;

public class Figure {
    private boolean color;
    private int x;
    private int y;
    private String name;

    public Figure(){
        color = false;
        x = 0;
        y = 0;
        name = "-";
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name;
    }


}
