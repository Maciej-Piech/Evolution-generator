package uek.is.oop;
import org.junit.jupiter.api.Test;
import static uek.is.oop.MoveDirection.*;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    public void itChecksisAt(){
        //
        Animal animal = new Animal();
        MoveDirection[] commands = {RIGHT,FORWARD,LEFT,FORWARD, FORWARD,RIGHT,FORWARD};
        //
        for (MoveDirection command : commands) {
            animal.move(command);
        }
        //
        assertTrue(animal.isAt(new Vector2d(4,4)));
        animal.move(FORWARD);
        assertFalse(animal.isAt(new Vector2d(5,4)));
    }
}
