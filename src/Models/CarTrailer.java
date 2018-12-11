package Models;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a car trailer it can hold a set number of cars,
 * It can only load cars while stationary.
 */
public class CarTrailer extends Truck {

    //private Boolean flatBedDown;
    private Transporter<PassengerCar> parent;

    /**
     * Constructor of a Models.CarTrailer
     *
     * @param enginePower The engine power of the Models.CarTrailer
     * @param color       The color of the Models.CarTrailer
     * @param modelName   The model name of the Models.CarTrailer
     */
    public CarTrailer(double enginePower, Color color, String modelName, int nrDoors, int maxLoad) {
        super(enginePower, color, modelName, nrDoors);
        //this.flatBedDown = flatBedDown;
        this.parent = new Transporter<>(maxLoad, false, getCurrentPos());
    }

//----------Public methods-----------

    /**
     * "Starts up the engine"
     * Actually: gives the car an small ammount of speed
     * Cannot start if the flat bed angle is greater than 0
     */
    @Override
    public void startEngine() {
        if (!parent.isCanLoad()) {
            super.startEngine();
        } else {
            System.out.println("The flat bed is down, the truck cannot start");
        }

    }

    /**
     * Method which lowers the flat bed. Allows for loading of cars.
     */
    public void lowerFlatBed() {
        if (getCurrentSpeed() == 0 && !this.isEngineOn())
            parent.setCanLoad(true);
        else
            System.out.println("Can't lower flat bed while driving");
    }

    /**
     * Method which raises the flat bed. Prevents the options of loading of cars.
     */
    public void raiseFlatBed() {
        parent.setCanLoad(false);
    }

    /**
     * Method which loads a Models.Car onto the Models.CarTrailer. The amount of cars loaded is decided by the variable maxLoad.
     * The Models.Car needs to be in the proximity of the Models.CarTrailer
     *
     * @param car The car which will get loaded.
     */
    public void loadCar(PassengerCar car) {
        parent.loadCar(car);
    }

    /**
     * Method which unloads the Models.Car that's been loaded most recently.
     * The Models.Car will be unloaded in the CarTrailers proximity.
     */
    public void unloadCar() {
        Position point = new Position(getCurrentPos().x - 5, getCurrentPos().y - 5);
        parent.unloadCar(point, Transporter.UnloadPriority.LASTIN);
    }

    /**
     * Moves the car forwards, depending on the current speed and direction
     * (updates the coordinates of the car)
     */
    @Override
    public void move() {

        getCurrentPos().x = (int) Math.round(getCurrentPos().x + Math.cos(getCurrentDirection()) * getCurrentSpeed());
        getCurrentPos().y = (int) Math.round(getCurrentPos().y + Math.sin(getCurrentDirection()) * getCurrentSpeed());


        //Moving the transporter
        parent.move(getCurrentPos());

    }





}
