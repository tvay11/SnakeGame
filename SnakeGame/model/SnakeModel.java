package model;

import java.util.ArrayList;
import java.util.Random;

public class SnakeModel {
    Direction.DIRECTION direction;
    int boardWidth;
    int boardHeight;
    int coinX;
    int coinY;
    Random rand;
    Position coin;
    ArrayList<Position> snake;
    Position newAddition;
    int unit;

    public SnakeModel() {
        this.boardWidth = 1000;
        this.unit = (int) (this.boardWidth * 0.025);
        this.boardHeight = (int) (this.boardWidth * .8 - (6 * unit));
        Position head = new Position(unit, 0);
        this.direction = Direction.DIRECTION.RIGHT;
        snake = new ArrayList<Position>();
        snake.add(head);
        for (int i = 0; i < 3; i++) {
            newAddition = new Position(snake.get(snake.size() - 1).getX() - unit, snake.get(snake.size() - 1).getY());
            snake.add(newAddition);
        }

        coin = new Position(-100, -100);
    }

    public void move() {
        for (int i = snake.size() - 1; i > 0; i--) {
            snake.get(i).setX(snake.get(i - 1).getX());
            snake.get(i).setY(snake.get(i - 1).getY());
        }

        if (direction.equals(Direction.DIRECTION.UP)) {
            snake.get(0).increment(0, -unit);
        } else if (direction.equals(Direction.DIRECTION.DOWN)) {
            snake.get(0).increment(0, unit);
        } else if (direction.equals(Direction.DIRECTION.LEFT)) {
            snake.get(0).increment(-unit, 0);
        } else if (direction.equals(Direction.DIRECTION.RIGHT)) {
            snake.get(0).increment(unit, 0);
        }
    }

    public int getSnakeSize() {
        return snake.size();
    }

    public Direction.DIRECTION getDirection() {
        return this.direction;
    }

    public void setDirection(Direction.DIRECTION toDirection) {

        switch (toDirection) {
            case UP:
                if (!this.direction.equals(Direction.DIRECTION.DOWN)) {
                    this.direction = Direction.DIRECTION.UP;
                }
                break;
            case DOWN:
                if (!this.direction.equals(Direction.DIRECTION.UP)) {
                    this.direction = Direction.DIRECTION.DOWN;
                }
                break;
            case RIGHT:
                if (!this.direction.equals(Direction.DIRECTION.LEFT)) {
                    this.direction = Direction.DIRECTION.RIGHT;
                }
                break;
            case LEFT:
                if (!this.direction.equals(Direction.DIRECTION.RIGHT)) {
                    this.direction = Direction.DIRECTION.LEFT;
                }
                break;
        }
    }

    public void addBody() {
        newAddition = new Position(snake.get(snake.size() - 1).getX(), snake.get(snake.size() - 1).getY());
        snake.add(newAddition);
    }

    public boolean checkForCoin() {
        if (snake.get(0).getX() == coin.getX() && snake.get(0).getY() == coin.getY()) {
            addBody();
            return true;
        }
        return false;
    }

    public void placeNewCoin() {
        rand = new Random();
        coinX = rand.nextInt((boardWidth / unit - 1)) * unit + unit;
        coinY = rand.nextInt(((boardHeight) / unit - 1)) * unit + unit;
        for (int i = 0; i < snake.size(); i++) {
            if (snake.get(i).getX() == coinX && snake.get(i).getY() == coinY) {
                placeNewCoin();
            }
        }
        coin.setX(coinX);
        coin.setY(coinY);
    }

    public int getCoinX() {
        return this.coinX;
    }

    public int getCoinY() {
        return this.coinY;
    }

    public boolean hitWall() {
        if (snake.get(0).getX() >= boardWidth) {
            return true;
        } else if (snake.get(0).getY() >= boardHeight) {
            return true;
        } else if (snake.get(0).getX() < 0) {
            return true;
        } else if (snake.get(0).getY() < 0) {
            return true;
        } else return false;
    }

    public boolean hitSelf() {
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(0).getX() == snake.get(i).getX() && snake.get(0).getY() == snake.get(i).getY()) {
                return true;
            }
        }
        return false;
    }

    public int getX(int w) {
        return snake.get(w).getX();
    }

    public int getY(int w) {
        return snake.get(w).getY();
    }
}
