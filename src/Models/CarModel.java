package Models;

import java.util.ArrayList;
import java.util.List;

public abstract class CarModel {
    private static List<Car> cars = new ArrayList<>();

    public List<Car> getCars(){
        List<Car> newCars = cars;//new ArrayList<>(cars);
        return newCars;
    }

    public void addSaab(Car car){
        cars.add(VehicleFactory.createSaab95());
    }

    public void addVolvo(){
        cars.add(VehicleFactory.createVolvo240());
    }

    public void addScania(){
        cars.add(VehicleFactory.createScania());
    }
}
