package uek.is.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap{
    private final Vector2d topRight;
    private final Vector2d bottomLeft = new Vector2d(0,0);
    MapVisualizer mapVisualizer = new MapVisualizer(this);

    public int getMapWidth(){
        return topRight.getX();
    }

    public int getMapHeight(){
        return topRight.getY();
    }

    public RectangularMap(int width, int height){
        this.topRight= new Vector2d(width,height);
    }

    ArrayList<Animal> allAnimals = new ArrayList<Animal>();

    @Override
    public String toString(){
        return mapVisualizer.draw(bottomLeft, topRight);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        return (!isOccupied(position) && position.precedes(topRight) && position.follows(bottomLeft));
    };

    @Override
    public boolean isOccupied(Vector2d checkPosition){
        for(Animal animal: allAnimals){
            if(animal.getPosition().equals(checkPosition)){
                return true;
            }
        }
        return false;
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