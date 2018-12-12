package Controllers;

import Observer.CarObserver;
import Views.*;
import Models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController implements CarObserver{

    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    //List<Car> cars = new ArrayList<>();
    // An object that handles all creation of Vehicles.
    private VehicleFactory factory = new VehicleFactory();

    //methods:

    public void initCarcontroller() {
        // Instance of this class

        int offset = 0;

        for(Car car : CarModel.getCars()){
            car.getCurrentPos().setY(offset);
            offset = offset + 100;
        }


        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0");
        frame.addObserver(this);

        // Start the timer
        timer.start();
    }

    @Override
    public void update(String notification) {

        switch (notification)
        {
            case "setTurboOn":
                setTurboOn();
                break;
            case "setTurboOff":
                setTurboOff();
                break;
            case "lowerFlatBed":
                lowerScaniaFlatBed();
                break;
            case "raiseFlatBed":
                raiseScaniaFlatBed();
                break;
            case "startEngine":
                startEngine();
                break;
            case "stopEngine":
                stopAllCars();
                break;
            case "gas":
                gas(frame.getSpeedAmount());
                break;
            case "brake":
                brake(frame.getSpeedAmount());
                break;
            case "addCar":
                // Add car
                break;
            case "removeCar":
                removeCar();
                frame.drawPanel.removeCarImage();
                break;
            default:
                System.out.println("Button not connected to action");
                break;
        }
    }

    /**
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : CarModel.getCars()) {
                car.move();
                if(isOutOfBounds(car)){
                    inverseDirection(car);
                }
                //TODO fixa som metod och gå igenom varje bil!
                frame.getDrawPanel().getVehicles().add(car);
                frame.drawPanel.moveit((int)car.getCurrentPos().getX(),(int)car.getCurrentPos().getY());

            }
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
    }

    private boolean isOutOfBounds(Car car){
        int x = (int) Math.round(car.getCurrentPos().getX());
        int y = (int) Math.round(car.getCurrentPos().getY());
        if (x < 0) {
            x = 0;
            return true;
        } else if (x + 120 > frame.getWidth()) {
            x = frame.getWidth() - 120;
            return true;
        }
        if (y < 0) {
            y = 0;
            inverseDirection(car);
        } else if (y + 120 > frame.getHeight()) {
            y = frame.getHeight() - 120;
            return true;
        }
        return false;
    }

    public VehicleFactory getFactory(){
        return factory;
    }
    // ----------- Methods to connect the buttons to actions ---------------

    /**
     * Calls the start engine method for each car once
     */
    private void startEngine() {
        for (Car car : CarModel.getCars())
            car.startEngine();
    }

    /**
     * Calls the stop engine method for each car once
     */
    private void stopAllCars() {
        for (Car car : CarModel.getCars())
            car.stopEngine();
    }

    /**
     * Calls the gas method for each car once
     */
    private void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : CarModel.getCars()) {
            car.gas(gas);
        }
    }

    /**
     * Calls the brake method for each car once
     */
    private void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : CarModel.getCars()) {
            car.brake(brake);
        }
    }

    /**
     * Calls the set turbo on method for each Models.Saab95 once
     */
    private void setTurboOn() {
        for (Car c : CarModel.getCars()) {
            if (c.toString().equals("Saab95")) {
                Saab95 s = (Saab95) c;
                s.setTurboOn();
            }
        }
    }

    /**
     * Calls the set turbo off method for each Models.Saab95 once
     */
    private void setTurboOff() {
        for (Car c : CarModel.getCars()) {
            if (c.toString().equals("Saab95")) {
                Saab95 s = (Saab95) c;
                s.setTurboOff();
            }
        }
    }

    /**
     * Calls the lower bed angle method for each Models.Scania once
     */
    private void lowerScaniaFlatBed() {
        for (Car c : CarModel.getCars()) {
            if (c.toString().equals("Scania")) {
                Scania s = (Scania) c;
                for (int i = 0; i < 70; i++)
                    s.lowerBedAngle();
            }
        }
    }

    /**
     * Calls the raise bed angle method for each Models.Scania once
     */
    private void raiseScaniaFlatBed() {
        for (Car c : CarModel.getCars()) {
            if (c.toString().equals("Scania")) {
                Scania s = (Scania) c;
                for (int i = 0; i < 70; i++)
                    s.raiseBedAngle();
            }
        }
    }

    /**
     * Reverse the direction for each car once. Used for when the car is hitting a wall.
     * @param car The car
     */
    private void inverseDirection(Car car) {
        for (int i = 0; i < 4; i++) {
            car.turnLeft();
        }
    }

    private void removeCar(){
        CarModel model = new CarModel();
        model.removeCar();
    }

}
