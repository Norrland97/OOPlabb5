package Models;

import java.awt.*;

/**
 * Represents a land vehicle
 */

public class Car extends Vehicle {

    private int nrDoors;

    /**
     * The construtor of Models.Car
     * @param enginePower The engine power of the Models.Car
     * @param color The color of the Models.Car
     * @param modelName The model name of the Models.Car
     * @param nrDoors The number of doors of the Models.Car
     */
    public Car(double enginePower, Color color, String modelName, int nrDoors) {
        super(enginePower, color, modelName);
        this.nrDoors = nrDoors;
    }

    /**
     * @return Returns the number of doors on the Models.Car
     */
    public int getNrDoors() {
        return nrDoors;
    }

}
