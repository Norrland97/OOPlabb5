package Models;

import java.util.ArrayList;
import java.util.List;

public abstract class CarModel {
    private static List<Car> cars = new ArrayList<>();

    public static List<Car> getCars(){
        List<Car> newCars = new ArrayList<>(cars); //Sends a copy of the list with cars ;)
        return newCars;
    }

    public static void addSaab(){
        cars.add(VehicleFactory.createSaab95());
    }

    public static void addVolvo(){
        cars.add(VehicleFactory.createVolvo240());
    }

    public static void addScania(){
        cars.add(VehicleFactory.createScania());
    }
}
