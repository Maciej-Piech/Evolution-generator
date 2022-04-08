package uek.is.oop;

import static java.lang.System.out;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString(MapDirection direction) {
        MapDirection newDirection = MapDirection.valueOf(String.valueOf(direction));
        String str = switch (direction) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST -> "Wschód";
        };
        out.println(str);
        return str;
    }

    public static MapDirection next(MapDirection direction) {
        MapDirection mapDirNext = switch (direction) {
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case EAST -> SOUTH;
        };
        out.println(String.valueOf(mapDirNext));
        return mapDirNext;
    }

    public static MapDirection previous(MapDirection direction) {
        MapDirection mapDirPrev = switch (direction) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            case EAST -> NORTH;
        };
        out.println(String.valueOf(mapDirPrev));
        return mapDirPrev;
    }

    public Vector2d toUnitVector(MapDirection direction) {
        MapDirection newDirection = MapDirection.valueOf(String.valueOf(direction));
        Vector2d unitVect = switch (direction) {
            case NORTH -> new Vector2d(0, 1);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
            case EAST -> new Vector2d(1, 0);
        };
        out.println("Vector: " + unitVect);
        return unitVect;
    }
}
