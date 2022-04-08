package uek.is.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap {

    protected Map<Vector2d, Grass> allGrasses = new HashMap();

    public GrassField(int numberOfGrassBlocks) {
        int maxSize = (int) Math.sqrt(10 * numberOfGrassBlocks);

        super.topRight = new Vector2d(maxSize, maxSize);
        super.bottomLeft = new Vector2d(0, 0);

        Random random = new Random();
        Set<Integer> grassSet = new HashSet<>();

        while (grassSet.size() < numberOfGrassBlocks) {
            grassSet.add(random.nextInt((maxSize + 1) * (maxSize + 1)));
        }
        for (Integer i : grassSet) {
            Vector2d grassPosition = (new Vector2d(i % (maxSize + 1), i / (maxSize + 1)));
            allGrasses.put(grassPosition, new Grass(grassPosition));
        }

    }

    @Override
    public Object objectAt(Vector2d checkedPosition) {
        if (allAnimals.containsKey(checkedPosition)) {
            return allAnimals.get(checkedPosition);
        }
        return allGrasses.get(checkedPosition);
    }

    @Override
    public String toString() {


        for (Vector2d key : allAnimals.keySet()) {
            this.topRight = key;
            this.bottomLeft = key;
        }

        allAnimals.keySet()
                .forEach(position -> {
                    this.topRight = this.topRight.upperRight(position);
                    this.bottomLeft = this.bottomLeft.lowerLeft(position);
                });
        allGrasses.keySet()
                .forEach(position -> {
                    this.topRight = this.topRight.upperRight(position);
                    this.bottomLeft = this.bottomLeft.lowerLeft(position);
                });

        return super.toString();

    }

}
