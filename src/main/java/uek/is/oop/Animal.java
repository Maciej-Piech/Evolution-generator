package uek.is.oop;

import java.util.*;

import static java.lang.System.out;
import static uek.is.oop.MapDirection.*;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;

    private final List<IPositionChangeObserver> allObservers = new LinkedList<IPositionChangeObserver>();

    @Override
    public String toString() {
        String symbol = "";
        switch (orientation) {
            case NORTH -> symbol = "N";
            case EAST -> symbol = "E";
            case SOUTH -> symbol = "S";
            case WEST -> symbol = "W";
        }
        return symbol;

//        return "orientation: " + symbol + ", position: " + this.position;
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public boolean isAt(Vector2d position) {
        return position.equals(this.position);
    }

    public boolean moveCheckerForward(Vector2d position) {

        if (position.add(this.orientation.toUnitVector(this.orientation)).getX() > map.getMapWidth() ||
                position.add(this.orientation.toUnitVector(this.orientation)).getY() > map.getMapHeight() ||
                position.add(this.orientation.toUnitVector(this.orientation)).getX() < 0 ||
                position.add(this.orientation.toUnitVector(this.orientation)).getY() < 0) {
            out.println("Zwierze nie może wyjść poza mape");
            return false;
        }
        return true;
    }

    public boolean moveCheckerBackward(Vector2d position) {

        if (position.subtract(this.orientation.toUnitVector(this.orientation)).getX() > map.getMapWidth() ||
                position.subtract(this.orientation.toUnitVector(this.orientation)).getY() > map.getMapHeight() ||
                position.subtract(this.orientation.toUnitVector(this.orientation)).getX() < 0 ||
                position.subtract(this.orientation.toUnitVector(this.orientation)).getY() < 0) {
            out.println("Zwierze nie moze wyjsc poza mape");
            return false;
        }
        return true;
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> orientation = next(this.orientation);
            case LEFT -> orientation = previous(this.orientation);
            case FORWARD -> {
                if (moveCheckerForward(position)) {
                    Vector2d newPositionForward = this.position.add(this.orientation.toUnitVector(this.orientation));
                    this.positionChanged(newPositionForward);
                }
            }
            case BACKWARD -> {
                if (moveCheckerBackward(position)) {
                    Vector2d newPositionBackward = this.position.subtract(this.orientation.toUnitVector(this.orientation));
                    this.positionChanged(newPositionBackward);
                    }
                }
            }
        }

    void addObserver(IPositionChangeObserver observer) {
        this.allObservers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        this.allObservers.remove(observer);
    }

    void positionChanged(Vector2d newPosition) {
        if (this.map.canMoveTo(newPosition)) {
            Vector2d oldPosition = this.position;
            this.position = newPosition;
            for (IPositionChangeObserver observer : allObservers) {
                observer.positionChanged(oldPosition, newPosition);
            }

        }
        else out.println("Position is currently occupied.");

    }

    Animal() {
        orientation = NORTH;
        position = new Vector2d(2, 2);
    }


    Animal(IWorldMap map, Vector2d initialPosition) {
        this.orientation = NORTH;
        this.position = initialPosition;
        this.map = map;

    }
}
