package uek.is.oop;

import java.util.*;

public class AbstractWorldMap implements IWorldMap{
    protected  Vector2d topRight;
    protected Vector2d bottomLeft;
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);


    public int getMapWidth(){
        return topRight.getX();
    }

    public int getMapHeight(){
        return topRight.getY();
    }

    protected List<Animal> allAnimals = new ArrayList<Animal>();

    @Override
    public String toString(){ return this.mapVisualizer.draw(this.bottomLeft, this.topRight);}

    @Override
    public boolean canMoveTo(Vector2d position){
        return (!isOccupied(position) && position.precedes(topRight) && position.follows(bottomLeft));
    }

    @Override
    public boolean isOccupied(Vector2d checkPosition){
        return this.objectAt(checkPosition) != null;
    }

    @Override
    public boolean place(Animal animal){
        Vector2d checkPosition = animal.getPosition();
        if(canMoveTo(checkPosition)){
            allAnimals.add(animal);
            return true;
        }
        return false;
    }
    @Override
    public Object objectAt(Vector2d checkPosition){
        for(Animal animal: allAnimals){
            if(animal.getPosition().equals(checkPosition)){
                return animal;
            }
        }
        return null;
    }
}
