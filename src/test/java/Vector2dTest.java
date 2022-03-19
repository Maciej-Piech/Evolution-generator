import org.junit.jupiter.api.Test;
import uek.is.oop.Vector2d;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    void itChecksEquals(){
        //
        Vector2d vector2d1 = new Vector2d(1,1);
        Vector2d vector2d2 = new Vector2d(1,1);
        //
        assertTrue(vector2d1.equals(vector2d2));
    }

    @Test
    void itChecksToString(){
        //
        Vector2d vector2d = new Vector2d(1,1);
        //
        assertEquals(vector2d.toString(), "(1,1)");
    }

    @Test
    void itChecksPrecedes(){
        //
        Vector2d vector2d1 = new Vector2d(1,1);
        Vector2d vector2d2 = new Vector2d(2,2);
        //
        assertTrue(vector2d1.precedes(vector2d2));
    }

    @Test
    void itChecksFollows(){
        //
        Vector2d vector2d1 = new Vector2d(2,2);
        Vector2d vector2d2 = new Vector2d(1,1);
        //
        assertTrue(vector2d1.follows(vector2d2));
    }

    @Test
    void itChecksUpperRight(){
        Vector2d vector2d1 = new Vector2d(2,1);
        Vector2d vector2d2 = new Vector2d(1,2);
        //
        assertEquals(vector2d1.upperRight(vector2d2), new Vector2d(2,2));
    }

    @Test
    void itChecksLowerLeft(){
        Vector2d vector2d1 = new Vector2d(2,1);
        Vector2d vector2d2 = new Vector2d(1,2);
        //
        assertEquals(vector2d1.lowerLeft(vector2d2), new Vector2d(1,1));
    }

    @Test
    void itChecksAdd(){
        Vector2d vector2d1 = new Vector2d(2,1);
        Vector2d vector2d2 = new Vector2d(1,2);
        //
        assertEquals(vector2d1.add(vector2d2), new Vector2d(3,3));
    }

    @Test
    void itChecksSubtract(){
        Vector2d vector2d1 = new Vector2d(2,2);
        Vector2d vector2d2 = new Vector2d(1,1);
        //
        assertEquals(vector2d1.subtract(vector2d2), new Vector2d(1,1));
    }

    @Test
    void itChecksOpposite(){
        Vector2d vector2d = new Vector2d(1,1);
        //
        assertEquals(vector2d.opposite(), new Vector2d(-1,-1));
    }
}
