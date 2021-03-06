package uek.is.oop;

import java.util.Objects;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2d() {
        x = getX();
        y = getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + String.valueOf(x) + "," + String.valueOf(y) + ")";
    }

    public boolean precedes(Vector2d other) {
        return other.x >= this.x && other.y >= this.y;
    }

    public boolean follows(Vector2d other) {
        return other.x <= this.x && other.y <= this.y;
    } //return precedes(other) ? false : true; <-- it works too

    public Vector2d upperRight(Vector2d other) {
        int maxX;
        int maxY;
        maxX = Math.max(x, other.x);
        maxY = Math.max(y, other.y);
        return new Vector2d(maxX, maxY);
    }

    public Vector2d lowerLeft(Vector2d other) {
        int minX;
        int minY;
        minX = Math.min(x, other.x);
        minY = Math.min(y, other.y);
        return new Vector2d(minX, minY);
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(x + other.x, y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(x - other.x, y - other.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return this.x == vector2d.x && this.y == vector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    public Vector2d opposite() {
        int xReversed = x * (-1);
        int yReversed = y * (-1);
        return new Vector2d(xReversed, yReversed);
    }

    public int compareByX(Vector2d other) {
        if (this.x > other.x) return 1;
        else if (this.x < other.x) return -1;
        else return 0;
    }

    public int compareByY(Vector2d other) {
        if (this.y > other.y) return 1;
        else if (this.y < other.y) return -1;
        else return 0;
    }
}
