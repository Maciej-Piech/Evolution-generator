import org.junit.jupiter.api.Test;
import uek.is.oop.MapDirection;

import static java.lang.System.out;
import static uek.is.oop.MapDirection.*;
import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {
    @Test
    void itChecksNextFunction(){
        //
        MapDirection.next(MapDirection.NORTH);
        //
        assertEquals(EAST,MapDirection.next(NORTH));
    }
    @Test
    void itChecksPreviousFunction(){
        //
        MapDirection.previous(MapDirection.NORTH);
        //
        assertEquals(EAST,MapDirection.next(NORTH));
    }

}
