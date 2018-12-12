package Models;

import java.util.ArrayList;
import java.util.List;

public class CarModel {
    private static List<Car> cars = new ArrayList<>();

    public static List<Car> getCars(){
        List<Car> newCars = cars;//new ArrayList<>(cars);
        return newCars;
    }

    public static void addSaab(Car car){
        cars.add(VehicleFactory.createSaab95());
    }

    public static void addVolvo(){
        cars.add(VehicleFactory.createVolvo240());
    }

    public static void addScania(){
        cars.add(VehicleFactory.createScania());
    }
}
