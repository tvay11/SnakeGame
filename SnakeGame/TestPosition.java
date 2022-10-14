import model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPosition {
    Position position;

    @Before
    public void setUp() {
        position = new Position();
    }

    @Test
    public void testPositionX() {
        assertEquals("Error incorrect default position", position.getX(), 0);
    }

    @Test
    public void testPositionY() {
        assertEquals("Error incorrect default position", position.getY(), 0);
    }

    @Test
    public void testSetPositionX() {
        position.setX(10);
        assertEquals("Error setX", 10, position.getX());
    }

    @Test
    public void testSetPositionY() {
        position.setY(20);
        assertEquals("Error setY", 20, position.getY());
    }

    @Test
    public void testConstructorX() {
        Position position = new Position(25, 10);
        assertEquals("Error ConstructorX", 25, position.getX());
    }

    @Test
    public void testConstructorY() {
        Position position = new Position(25, 10);
        assertEquals("Error ConstructorY", 10, position.getY());
    }

    @Test
    public void testIncrementX() {
        position.increment(10, 0);
        assertEquals("Error increment value x should increase", 10, position.getX());
    }

    @Test
    public void testIncrementY() {
        position.increment(0, 10);
        assertEquals("Error increment value y should increase", 10, position.getY());
    }
}
