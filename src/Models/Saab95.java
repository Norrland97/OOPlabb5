package Models;

import java.awt.*;

/**
 * Represents a Models.Saab95
 * It's got a turbo to boost the speed.
 */
public class Saab95 extends PassengerCar {

    private boolean turboOn;

    /**
     *
     * @param nrDoors The number of doors of the car - int
     * @param enginePower The engine power of the car - double
     * @param color The color of the car - Color
     * @param modelName The model name of the car - String
     * @param turboOn Whether or not the turbo is activated or not - boolean
     */

    public Saab95(double enginePower, Color color, String modelName, int nrDoors, boolean turboOn) {
        super(enginePower, color, modelName, nrDoors);
        this.turboOn = turboOn;
    }

    /**
     * Activate turbo
     */

    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Deactivate turbo
     */

    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Method which returns the speedFactor
     * @return EnginePower * 0.01 * turbo
     */

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }




}
