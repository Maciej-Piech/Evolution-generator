package uek.is.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    @Test
    public void itChecksRectangularMap(){
        //
        IWorldMap map = new RectangularMap(10, 5);
        //
        assertEquals(map.getMapWidth(), 10);
        assertEquals(map.getMapHeight(),5);
    }

    @Test
    public void itChecksIsOccupiedMethod(){
        //
        IWorldMap map = new RectangularMap(10, 5);
        Animal animal = new Animal(map, new Vector2d(2,2));
        //
        map.place(animal);
        //
        assertTrue(map.isOccupied(new Vector2d(2,2)));
    }

    @Test
    public void itChecksPlaceMethod(){
        //
        IWorldMap map = new RectangularMap(10, 5);
        Animal animal = new Animal(map, new Vector2d(2,2));
        //
        assertTrue(map.place(animal));
    }

    @Test
    public void itChecksObjectAtMethod(){
        //
        IWorldMap map = new RectangularMap(10, 5);
        Animal animal = new Animal(map, new Vector2d(2,2));
        //
        map.place(animal);
        //
        assertEquals(map.objectAt((new Vector2d(2,2))), animal);
    }

    @Test
    public void itChecksCanMoveTo(){
        //
        IWorldMap map = new RectangularMap(10, 5);
        Animal animal = new Animal(map, new Vector2d(2,2));
        //
        map.place(animal);
        //
        assertFalse(map.canMoveTo(new Vector2d(2,2)));

    }






}
