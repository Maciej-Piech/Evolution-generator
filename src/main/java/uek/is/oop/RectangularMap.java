package uek.is.oop;


public class RectangularMap extends AbstractWorldMap {

    MapVisualizer mapVisualizer = new MapVisualizer(this);


    public RectangularMap(int width, int height) {
        this.bottomLeft = new Vector2d(0, 0);
        this.topRight = new Vector2d(width, height);
    }


    @Override
    public String toString() {
        return mapVisualizer.draw(bottomLeft, topRight);
    }


    @Override
    public boolean canMoveTo(Vector2d checkedPosition) {
        if (super.canMoveTo(checkedPosition)) {
            return checkedPosition.precedes(this.topRight) && checkedPosition.follows(this.bottomLeft);
            // it returns true if animal will not move outside the map
        }
        return false;
    }


}