package Models;

import Models.Car;

import java.awt.*;

/**
 * Represents a smaller Models.Car that transports people
 */

public class PassengerCar extends Car {

    /**
     * The constructor of Models.PassengerCar
     * @param enginePower The engine power of the Models.PassengerCar
     * @param color The color of the Models.PassengerCar
     * @param modelName The model name of the Models.PassengerCar
     * @param nrDoors The number of doors of the Passengercar
     */

    public PassengerCar(double enginePower, Color color, String modelName, int nrDoors) {
        super(enginePower, color, modelName, nrDoors);
    }

}
