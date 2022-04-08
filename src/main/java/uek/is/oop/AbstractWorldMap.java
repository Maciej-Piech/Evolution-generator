package uek.is.oop;

import java.util.*;

import static java.lang.System.out;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Vector2d topRight;
    protected Vector2d bottomLeft;
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);


    public int getMapWidth() {
        return topRight.getX();
    }

    public int getMapHeight() {
        return topRight.getY();
    }

    protected Map<Vector2d, Animal> allAnimals = new HashMap<>();

    @Override
    public String toString() {
        return this.mapVisualizer.draw(this.bottomLeft, this.topRight);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !this.allAnimals.containsKey(position);
    }

    @Override
    public boolean isOccupied(Vector2d checkPosition) {
        return this.objectAt(checkPosition) != null;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d checkPosition = animal.getPosition();
        if (canMoveTo(checkPosition)) {
            this.allAnimals.put(checkPosition, animal);
            animal.addObserver(this);
            out.println("animal placed" + checkPosition);
            return true;
        }
        throw new IllegalArgumentException("Position " + checkPosition + " is already occupied");
    }

    @Override
    public Object objectAt(Vector2d checkPosition) {
        return this.allAnimals.get(checkPosition);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        this.allAnimals.put(newPosition, this.allAnimals.remove(oldPosition));
    }
}
