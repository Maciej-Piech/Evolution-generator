package uek.is.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap{

    protected List<Grass> grassBlocks = new ArrayList<>();

    public GrassField( int numberOfGrassBlocks){
        int maxSize = (int)Math.sqrt(10* numberOfGrassBlocks);

        super.topRight = new Vector2d(maxSize, maxSize);
        super.bottomLeft = new Vector2d(0,0);

        Random random = new Random();
        Set<Integer> grassSet = new HashSet<>();

        while(grassSet.size()< numberOfGrassBlocks){
            grassSet.add(random.nextInt((maxSize+1)*(maxSize+1)));
        }
        for(Integer i : grassSet){
            grassBlocks.add(new Grass(new Vector2d(i % (maxSize+1), i / (maxSize+1))));
        }

    }

    @Override
    public Object objectAt(Vector2d checkedPosition) {
        Object object = super.objectAt(checkedPosition);
        if ( object != null ){
            return object;
        }
        for(Grass grassElement: grassBlocks){
            if(grassElement.getPosition().equals(checkedPosition)){
                return grassElement;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        this.topRight=this.allAnimals.get(0).getPosition();
        this.bottomLeft=this.allAnimals.get(0).getPosition();

        for(Animal animal: allAnimals){
            this.topRight=this.topRight.upperRight(animal.getPosition());
            this.bottomLeft=this.bottomLeft.lowerLeft(animal.getPosition());
        }
        for(Grass grassElement: grassBlocks){
            this.topRight=this.topRight.upperRight(grassElement.getPosition());
            this.bottomLeft=this.bottomLeft.lowerLeft(grassElement.getPosition());
        }
        return super.toString();

    }

}
