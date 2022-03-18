package uek.is.oop;
import static java.lang.System.out;
import java.util.Scanner;

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
        run(new Enum[]{Direction.FORWARD, Direction.FORWARD, Direction.LEFT, Direction.RIGHT});
        out.println("System zakończył działanie");
        out.println("========================");
        Vector2d position1 = new Vector2d(1,2);
        out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        out.println(position2);
        out.println(position1.add(position2));

    }
}
