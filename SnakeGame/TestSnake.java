import model.Direction;
import model.SnakeModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestSnake {
    SnakeModel snakeModel;
    int boardWidth;
    int boardHeight;

    @Before
    public void setUp() {
        snakeModel = new SnakeModel();
        boardWidth = 1000;
        boardHeight = 650;
    }

    @Test
    public void testSnakeSize() {
        assertEquals("Error Default size is 4", 4, snakeModel.getSnakeSize());
    }

    @Test
    public void testSnakeDirection() {
        assertEquals("Error Default direction is right", Direction.DIRECTION.RIGHT, snakeModel.getDirection());
    }

    @Test
    public void testSnakeChangeDirection() {
        snakeModel.setDirection(Direction.DIRECTION.DOWN);
        assertEquals("Error Should be down", Direction.DIRECTION.DOWN, snakeModel.getDirection());
    }

    @Test
    public void testSnakeChangeOppositeDirection() {
        snakeModel.setDirection(Direction.DIRECTION.DOWN);
        snakeModel.setDirection(Direction.DIRECTION.UP);
        assertEquals("Error Should be down still", Direction.DIRECTION.DOWN, snakeModel.getDirection());
    }

    @Test
    public void testCoinLocation() {
        boolean f = true;
        for (int i = 0; i < 10000; i++) {
            snakeModel.placeNewCoin();
            if (snakeModel.getCoinX() < 1000 && snakeModel.getCoinX() > 0) {
                if (snakeModel.getCoinY() < 650 && snakeModel.getCoinY() > 0) {
                    f = true;
                } else
                    f = false;
            } else {
                f = false;
            }
            assertEquals(+i + "  " + snakeModel.getCoinX() + "  " + snakeModel.getCoinY(), true, f);
        }
    }

    @Test
    public void testHitWall() {
        for (int i = 0; i < 39; i++) {
            snakeModel.move();
        }
        assertEquals("Error Should hit wall", true, snakeModel.hitWall());
    }

    @Test
    public void testGetX() {
        assertEquals("Error Return x value", snakeModel.getX(0), 1000 * .025, 0.01);
    }

    @Test
    public void testGetY() {
        assertEquals("Error Return y value", snakeModel.getY(0), 0);
    }

    @Test
    public void testSnakeGrowth() {
        snakeModel.addBody();
        assertEquals("Error Snake size should be 5", snakeModel.getSnakeSize(), 5);
    }

    @Test
    public void testMoveX() {
        snakeModel.move();
        assertEquals("Error snake should move", 1000 * .025 * 2, snakeModel.getX(0), .01);
    }

    @Test
    public void testMoveY() {
        snakeModel.setDirection(Direction.DIRECTION.DOWN);
        snakeModel.move();
        assertEquals("Error snake should move", 25, snakeModel.getY(0));
    }

    @Test
    public void testCheckCoin() {
        assertEquals("Error shouldn't hit coin", false, snakeModel.checkForCoin());
    }

    @Test
    public void testHitSelf() {
        for (int i = 0; i < 7; i++) {
            snakeModel.addBody();
        }
        snakeModel.setDirection(Direction.DIRECTION.UP);
        snakeModel.move();
        snakeModel.move();
        snakeModel.setDirection(Direction.DIRECTION.LEFT);
        snakeModel.move();
        snakeModel.move();
        snakeModel.setDirection(Direction.DIRECTION.DOWN);
        snakeModel.move();
        snakeModel.move();
        assertEquals("Errpr Snake should hitself", snakeModel.hitSelf(), true);
    }
}


