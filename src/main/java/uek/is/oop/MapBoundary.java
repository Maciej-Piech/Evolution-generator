package uek.is.oop;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    private final SortedSet<Vector2d> setElementsX = new TreeSet<>(Vector2d::compareByX);
    private final SortedSet<Vector2d> setElementsY = new TreeSet<>(Vector2d::compareByY);

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        this.setElementsX.remove(oldPosition);
        this.setElementsX.add(newPosition);

        this.setElementsY.remove(oldPosition);
        this.setElementsY.add(newPosition);
    }
}

