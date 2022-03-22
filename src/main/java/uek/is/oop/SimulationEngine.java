package uek.is.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine{

    MoveDirection[] moveDirections;
    IWorldMap worldMapInstance;
    Vector2d[] initialAnimalPositions;
    ArrayList<Animal> allAnimals = new ArrayList<>();

    public SimulationEngine(MoveDirection[] moveDirections, IWorldMap worldMapInstance, Vector2d[] initialAnimalPositions) {
        this.moveDirections = moveDirections;
        this.worldMapInstance = worldMapInstance;
        this.initialAnimalPositions = initialAnimalPositions;

        for (Vector2d initialAnimalPosition : initialAnimalPositions) {
            Animal animal = new Animal(worldMapInstance, initialAnimalPosition);
            if (worldMapInstance.place(animal)) {
                allAnimals.add(animal);
            }
        }
    }

    @Override
    public void run()
    {
        int animalNumber = allAnimals.size();
        int animalIterator = 0;
        for (MoveDirection moveDirection : moveDirections) {
            /* if (animalNumber <= animalIterator) {
                animalIterator = 0;
            }*/
            allAnimals.get(animalIterator).move(moveDirection);
            animalIterator= (animalIterator + 1) % animalNumber;
        }
        }

    }

