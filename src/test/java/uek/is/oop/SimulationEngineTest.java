package uek.is.oop;

import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationEngineTest {
    @Test
    public void itChecksRunMethod() {
        String[] test = {"f", "b", "r", "l", "b", "f"};
        MoveDirection[] directions = OptionsParser.parse(test);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        out.println(map);
        assertTrue(map.isOccupied(new Vector2d(2, 3)));
        assertTrue(map.canMoveTo(new Vector2d(4, 5)));
    }
}
