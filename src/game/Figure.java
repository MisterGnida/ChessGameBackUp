public abstract class Figure {
    private boolean color;
    private int x;
    private int y;
    private String name;

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
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

    public void step(int x, int y){

    }
}
