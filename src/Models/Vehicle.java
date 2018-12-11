package Models;

import java.awt.*;
import java.lang.*;

/**
 * Represents a vehicle and the abilities it has, which includes the number of doors, the engine power
 * the current speed, the current direction, the current position, the color of the car and the model name.
 */

public class Vehicle implements Movable {

    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private double currentDirection;
    private Position currentPos;
    private Color color; // Color of the car
    private String modelName; // The car model name
    private boolean engineOn;
    private boolean isLoaded;

    /** The constructor of Models.Vehicle
     *
     * @param enginePower The engine power of the Models.Vehicle
     * @param color The color of the Models.Vehicle
     * @param modelName The model name of the Models.Vehicle
     */

    public Vehicle(double enginePower, Color color, String modelName) {
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.color = color;
        this.modelName = modelName;
        this.currentDirection = 0;
        this.currentPos = new Position(0, 0);
        this.engineOn = false;
        this.isLoaded = false;
    }

    //----------------Getters and setters----------------


    /**
     * @return Returns the position of the Models.Vehicle
     */
    public Position getCurrentPos() {
        return currentPos;
    }



    /**
     * @return Returns current direction of Models.Vehicle
     */
    public double getCurrentDirection() {
        return currentDirection;
    }


    /**
     * @return Returns the power of the engine of the Models.Vehicle
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * @return Returns the speed of the Models.Vehicle
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * @return returns the color of the Models.Vehicle
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return returns true if egine is on
     */
    boolean isEngineOn() {
        return engineOn;
    }

    /**
     * Changes the color of the Models.Vehicle
     *
     * @param clr the color of the Models.Vehicle
     */
    public void setColor(Color clr) {
        color = clr;
    }

    //-----------Other methods--------------

    @Override
    public String toString(){
        return modelName;
    }

    /**
     * "Starts up the engine"
     * Actually: gives the Models.Vehicle a small amount of speed
     */
    public void startEngine() {
        currentSpeed = 0.1;
        engineOn = true;
    }

    /**
     * Sets the speed of the Models.Vehicle to 0, The car stops;
     */
    public void stopEngine() {
        engineOn = false;
        currentSpeed = 0;
    }

    /**
     * An internal method to get the speed factor of the Models.Vehicle
     *
     * @return speedFactor, the base speedfactor of Models.Vehicle
     */
    public double speedFactor() {
        return enginePower * 0.01;
    }

    /**
     * getter to see if veichle is loaded
     * @return boolean, true if object is loaded
     */
    public boolean isLoaded() {
        return isLoaded;
    }

    /**
     * setter for loading Veichle
     * @param loaded boolean, true if veichle is loaded, false otherwise
     */
    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }

    //--------Change speed----------

    /**
     * A method used to increase the speed of the Models.Vehicle based of the Models.Vehicle speedFactor and the amount
     * given to increase it. Cannot increase the speed of the Models.Vehicle higher than enginePower.
     *
     * @param amount A value between 0 and 1 given to increase the speed of the Models.Vehicle;
     */
    public void incrementSpeed(double amount) {

        if (engineOn) {
            currentSpeed = currentSpeed + speedFactor() * amount;
        } else {
            System.out.println("Start engine first");
            return;
        }

        if(currentSpeed >= enginePower)
            currentSpeed = enginePower;

    }

    /**
     * This lowers the speed of the Models.Vehicle
     *
     * @param amount The amount of the speed to slow down the car. Cannot lower the speed of the car
     *               lower than 0.
     */
    public void decrementSpeed(double amount) {

        currentSpeed = currentSpeed - speedFactor() * amount;

        if(currentSpeed < 0)
            currentSpeed = 0;
    }

    //-------------movement of the car------------


    /**
     * Moves the car forwards, depending on the current speed and direction
     * (updates the coordinates of the Models.Vehicle)
     */
    @Override
    public void move() {

        currentPos.x = currentPos.x + Math.cos(Math.toRadians(currentDirection)) * currentSpeed;
        currentPos.y = currentPos.y + Math.sin(Math.toRadians(currentDirection)) * currentSpeed;

    }


    /**
     * turns the Models.Vehicle to the left by increasing currentDirection
     */
    @Override
    public void turnLeft() {
        currentDirection = currentDirection + 45;
    }

    /**
     * turns the Models.Vehicle to the right by decreasing currentDirection
     */
    @Override
    public void turnRight() {
        currentDirection = currentDirection - 45;
    }


    /**
     * A method used to increase the speed of the Models.Vehicle based of the cars speedFactor and the amount
     * given to increase it. Cannot increase the speed of the Models.Vehicle higher than enginePower.
     *
     * @param amount A value between 0 and 1 given to increase the speed of the Models.Vehicle;
     */
    public void gas(double amount) {
        if(amount < 0 ){
            amount = 0;
        } else if (amount > 1){
            amount = 1;
        }
        incrementSpeed(amount);
    }

    /**
     * This lowers the speed of the Models.Vehicle
     *
     * @param amount The amount of the speed to slow down the Models.Vehicle cannot be lower than 0 or higher than 1
     */
    public void brake(double amount) {
        if(amount < 0 ){
            amount = 0;
        } else if (amount > 1){
            amount = 1;
        }
        decrementSpeed(amount);
    }
}
