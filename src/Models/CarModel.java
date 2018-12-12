package Models;

import java.util.ArrayList;
import java.util.List;

public class CarModel {
    private static List<Car> cars = new ArrayList<>();

    private static int offset = 0;

    public static List<Car> getCars(){
        List<Car> newCars = new ArrayList<>(cars); //Sends a copy of the list with cars ;)
        return newCars;
    }

    public static List<Vehicle> getVehicles(){
        List<Vehicle> vehicles = new ArrayList<>();
        for (Car c: cars){
            vehicles.add(c);
        }
        return vehicles;
    }

    public static void addSaab(){
        carModelAddCar(VehicleFactory.createSaab95());
    }

    public static void addVolvo(){
        carModelAddCar(VehicleFactory.createVolvo240());
    }

    public static void addScania(){
        carModelAddCar(VehicleFactory.createScania());
    }

    public static void carModelAddCar(Car car){
        cars.add(car);
        car.getCurrentPos().setY(offset);
        offset = offset + 100;
        if (offset > 1000)
            offset = 1000;
    }

    public static void carModelRemoveCar(){
        if (cars.size() > 0) {
            cars.remove(cars.size() - 1);
            offset = offset - 100;
            if (offset < 0)
                offset = 0;
        }
    }

}
