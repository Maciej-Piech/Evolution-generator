package uek.is.oop;

import java.util.Arrays;

import static java.lang.System.out;

public class World {


    public static void run(Enum[] commands) {
        for (int i = 0; i < commands.length; i++) {
            Direction newDirection = Direction.valueOf(String.valueOf(commands[i]));
            String command = switch (newDirection) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case LEFT -> "Zwierzak idzie w lewo";
                case RIGHT -> "Zwierzak idzie w prawo";
                default -> "Nieznana komenda";
            };
            if (commands[i] == commands[commands.length - 1]) {
                out.println(command);
            } else {
                out.println(command);
            }
        }
    }

    public static void main(String[] args) {

        out.println("System wystartował");

        try {
            //String[] test = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
            String[] test = {"r", "l"};
            MoveDirection[] directions = OptionsParser.parse(test);
            out.println(Arrays.toString(directions));
            IWorldMap map = new GrassField(8);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            out.println(map);
        } catch (IllegalArgumentException ex) {
            out.println(ex.getMessage());
        }
    }
}
