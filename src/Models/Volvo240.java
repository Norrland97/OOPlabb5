package Models;

import java.awt.*;

/**
 * Represents a Volvo 240.
 * It has the function trim to make it go faster.
 */
public class Volvo240 extends PassengerCar {

    public final static double trimFactor = 1.25;

    /**
     * Constructor for Models.Volvo240
     * @param nrDoors The number of doors for the car - int
     * @param enginePower - The engine power of the car - double
     * @param color - The color of the car - Color
     * @param modelName - The model name of the car - String
     */

    public Volvo240(double enginePower, Color color, String modelName, int nrDoors) {
        super(enginePower, color, modelName, nrDoors);
    }

    /**
     * Method which returns speedfactor of car
     * @return enginePower * 0.01 * trimFactor
     */

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }


}
