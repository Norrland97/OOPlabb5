package Models;

import Models.Car;

import java.awt.*;

/**
 * Represents a bigger Models.Car which can load things
 */

public class Truck extends Car {

    /**
     * The constructor of the Models.Truck
     * @param enginePower The engine power of the Models.Truck
     * @param color The color of the Models.Truck
     * @param modelName The model name of the Models.Truck
     * @param nrDoors The number of doors of the Models.Truck
     */

    public Truck(double enginePower, Color color, String modelName, int nrDoors) {
        super(enginePower, color, modelName, nrDoors);
    }

}
