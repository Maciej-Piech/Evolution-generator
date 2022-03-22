package uek.is.oop;
import java.util.Arrays;

import static java.lang.System.out;
import static uek.is.oop.MoveDirection.*;

public class World {



    public static void run(Enum[] commands){
    for(int i=0; i<commands.length;i++){
        Direction newDirection = Direction.valueOf(String.valueOf(commands[i]));
        String command = switch ( newDirection){
            case FORWARD -> "Zwierzak idzie do przodu";
            case BACKWARD -> "Zwierzak idzie do tyłu";
            case LEFT -> "Zwierzak idzie w lewo";
            case RIGHT -> "Zwierzak idzie w prawo";
            default -> "Nieznana komenda";
        };
        if(commands[i] == commands[commands.length-1]){
            out.println(command);
        }
        else{
            out.println(command); }
    }
    }

    public static void main(String[] args){

        out.println("System wystartował");
        /*
        run(new Enum[]{Direction.FORWARD, Direction.FORWARD, Direction.LEFT, Direction.RIGHT});
        out.println("System zakończył działanie");
        out.println("========================");
        Vector2d position1 = new Vector2d(1,2);
        out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        out.println(position2);
        out.println(position1.add(position2));
        Vector2d vector2d = new Vector2d(1,1);
        //
        out.println(vector2d);
        Animal animal1 = new Animal();
        out.println(animal1);
        //
        animal1.move(RIGHT);
        animal1.move(FORWARD);
        animal1.move(FORWARD);
        animal1.move(FORWARD);
        out.println(animal1);
        //
        Animal animal2 = new Animal();
        out.println("\n=========== ANIMAL 2 ===========\n");
        out.println(animal2);
        String[] arrayDirections = {"r","f","f"};
        for(int i=0; i<arrayDirections.length;i++){
            animal2.move(OptionsParser.parse(arrayDirections)[i]);
        }
        animal2.move(FORWARD);
        out.println(animal2);
        //
        */
        String[] test = {"f","b", "r" , "l", "f", "f", "r","r", "f", "f", "f", "f", "f","f", "f", "f"};
        //String[] test = {"r","l"};
        MoveDirection[] directions = OptionsParser.parse(test);
        out.println(Arrays.toString(directions));
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        out.println(map);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        out.println(map);
    }
}
