package uek.is.oop;
import static java.lang.System.out;
import static uek.is.oop.MapDirection.*;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    @Override
    public String toString(){
        return "orientation: "+ this.orientation +", position: "+ this.position;
    }

    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }

    public boolean moveCheckerForward(Vector2d position){

        if(position.add(this.orientation.toUnitVector(this.orientation)).getX()>4 ||
                position.add(this.orientation.toUnitVector(this.orientation)).getY()>4 ||
                position.add(this.orientation.toUnitVector(this.orientation)).getX()<0 ||
                position.add(this.orientation.toUnitVector(this.orientation)).getY()<0)
        { out.println("Zwierze nie może wyjść poza mape");
        return false;}
        return true;
        }

    public boolean moveCheckerBackward(Vector2d position){

        if(position.subtract(this.orientation.toUnitVector(this.orientation)).getX()>4 ||
                position.subtract(this.orientation.toUnitVector(this.orientation)).getY()>4 ||
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
                    this.position = this.position.add(this.orientation.toUnitVector(this.orientation));
                }
            }
            case BACKWARDS -> {
                if (moveCheckerBackward(position)) {
                    this.position = this.position.subtract(this.orientation.toUnitVector(this.orientation));
                }
            }
        }
    }


    Animal(){
        orientation = NORTH;
        position = new Vector2d(2,2);
    }
}
