package uek.is.oop;
import static java.lang.System.out;
import static uek.is.oop.MapDirection.*;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;

    @Override
    public String toString(){
        String symbol ="";
        switch(orientation){
            case NORTH ->  symbol = "N";
            case EAST -> symbol = "E";
            case SOUTH ->  symbol ="S";
            case WEST -> symbol = "W";
        }

        return "orientation: "+ symbol +", position: "+ this.position;
    }

    public Vector2d getPosition(){
        return this.position;
    }
    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }

    public boolean moveCheckerForward(Vector2d position){

        if(position.add(this.orientation.toUnitVector(this.orientation)).getX()>map.getMapWidth() ||
                position.add(this.orientation.toUnitVector(this.orientation)).getY()>map.getMapHeight() ||
                position.add(this.orientation.toUnitVector(this.orientation)).getX()<0 ||
                position.add(this.orientation.toUnitVector(this.orientation)).getY()<0)
        { out.println("Zwierze nie może wyjść poza mape");
        return false;}
        return true;
        }

    public boolean moveCheckerBackward(Vector2d position){

        if(position.subtract(this.orientation.toUnitVector(this.orientation)).getX()> map.getMapWidth() ||
                position.subtract(this.orientation.toUnitVector(this.orientation)).getY()> map.getMapHeight() ||
                position.subtract(this.orientation.toUnitVector(this.orientation)).getX()<0 ||
                position.subtract(this.orientation.toUnitVector(this.orientation)).getY()<0)
        { out.println("Zwierze nie moze wyjsc poza mape");
        return false;}
        return true;
    }

    public void move( MoveDirection direction) {
        switch (direction) {
            case RIGHT -> orientation = next(this.orientation);
            case LEFT -> orientation = previous(this.orientation);
            case FORWARD -> {
                if (moveCheckerForward(position)) {
                    if (this.map.canMoveTo(this.position.add(this.orientation.toUnitVector(this.orientation))))
                    // ^ it checks if animal can move to next position
                    {
                        this.position = this.position.add(this.orientation.toUnitVector(this.orientation));
                    }
                }
            }
            case BACKWARD -> {
                if (moveCheckerBackward(position)) {
                    {
                        if (this.map.canMoveTo(this.position.subtract(this.orientation.toUnitVector(this.orientation))))
                        // ^ it checks if animal can move to next position
                        {
                            this.position = this.position.subtract(this.orientation.toUnitVector(this.orientation));
                        }
                    }
                }
            }
        }
    }

    Animal(){
        orientation = NORTH;
        position = new Vector2d(2,2);
    }


    Animal(IWorldMap map, Vector2d initialPosition){
        this.orientation = NORTH;
        this.position = initialPosition;
        this.map=map;

    }
}
