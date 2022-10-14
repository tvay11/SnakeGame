package model;

public class Position {
    protected int x;
    protected int y;
    Direction.DIRECTION direction;

    public Position() {
        this.x = 0;
        this.y = 0;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int pos) {
        this.x = pos;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int pos) {
        this.y = pos;
    }

    public void increment(int xVal, int yVal) {
        this.x += xVal;
        this.y += yVal;
    }

    public void setDirection(Direction.DIRECTION toDirection) {
        this.direction = toDirection;
    }
}
