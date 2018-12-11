package Models;

import Models.Car;

import java.awt.*;

/**
 * Represents a vehicle which travels on water and can move Trucks and PassengerCars
 */

public class Ferry extends Vehicle {

    private Transporter<Car> parent;

    /**
     * The constructor of Models.Ferry
     * @param enginePower The engine power of the Models.Ferry
     * @param color The color of the Models.Ferry
     * @param modelName The model name of the Models.Ferry
     * @param isDocked Whether the ferry is docked or not. Allows for loading of Cars
     * @param maxLoad The maximum number of Cars which the Models.Ferry can load
     */
    public Ferry(double enginePower, Color color, String modelName, boolean isDocked,
                 int maxLoad) {
        super(enginePower, color, modelName);
        this.parent = new Transporter<>(maxLoad, isDocked, getCurrentPos());
    }

    /**
     * Method to load cars onto the Models.Ferry
     * @param car The car which is to be loaded
     */
    public void loadCar(Car car) {
        parent.loadCar(car);
    }

    /**
     * Method to unload the car which was first loaded
     */
    public void unloadCar() {
        Position point = new Position(getCurrentPos().x - 5, getCurrentPos().y - 5);
        parent.unloadCar(point, Transporter.UnloadPriority.FIRSTIN);
    }

    /**
     * Method to start the engine. Can't start engined whiled still docked and ready to load cars
     */
    @Override
    public void startEngine(){
        if (!parent.isCanLoad()) {
            super.startEngine();
        } else {
            System.out.println("Can't start while docked");
        }
    }

    /**
     * Method to load Cars. Models.Ferry must be stationary to dock.
     */
    public void dock() {
        if (getCurrentSpeed() == 0)
            parent.setCanLoad(true);
        else
            System.out.println("Can't dock while moving");
    }

    /**
     * Undocks the ferry
     */
    public void unDock() {
        parent.setCanLoad(false);
    }

}
