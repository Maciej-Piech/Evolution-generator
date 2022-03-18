import org.junit.jupiter.api.Test;
import uek.is.oop.MapDirection;

import static java.lang.System.out;
import static uek.is.oop.MapDirection.*;
import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {
    @Test
    void itChecksNextFunction(MapDirection direction){
        //
        MapDirection mapDirection = MapDirection.valueOf(String.valueOf(direction));
        //
        mapDirection.next(NORTH);
        //
        assertEquals(EAST,mapDirection.next(NORTH));
    }
    @Test
    void itChecksPreviousFunction(MapDirection direction){
        //
        MapDirection mapDirection = MapDirection.valueOf(String.valueOf(direction));
        //
        mapDirection.next(NORTH);
        //
        assertEquals(WEST,mapDirection.next(NORTH));
    }

}
