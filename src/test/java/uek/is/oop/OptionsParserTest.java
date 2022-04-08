package uek.is.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
    @Test
    public void itChecksParse() {
        String[] stringDirections = {"f", "b", "r", "f"};
        Animal animal = new Animal();
        MoveDirection[] moveDirections = OptionsParser.parse(stringDirections);

        for (int i = 0; i < stringDirections.length; i++) {
            animal.move(OptionsParser.parse(stringDirections)[i]);
        }
        assertTrue(animal.isAt(new Vector2d(3, 2)));
    }
}
