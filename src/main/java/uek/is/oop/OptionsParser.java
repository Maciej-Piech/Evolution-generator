package uek.is.oop;
import java.util.Arrays;

import static uek.is.oop.MoveDirection.*;

public class OptionsParser {

    public static MoveDirection[] parse(String[] directions){
        MoveDirection[] MoveDirectionsArray = {};
        for(String direction: directions){
            MoveDirectionsArray = Arrays.copyOf(MoveDirectionsArray, MoveDirectionsArray.length+1);
            switch (direction){
                case "f", "forward" -> MoveDirectionsArray[MoveDirectionsArray.length -1] = FORWARD;
                case "b", "backward" -> MoveDirectionsArray[MoveDirectionsArray.length -1] = BACKWARDS;
                case "r", "right" ->MoveDirectionsArray[MoveDirectionsArray.length -1] = RIGHT;
                case "l", "left" ->MoveDirectionsArray[MoveDirectionsArray.length -1] = LEFT;
            }
        }
        return MoveDirectionsArray;

    }
}
