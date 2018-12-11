package Models;

import java.awt.*;

public class VehicleFactory {

    public Car createVolvo240(){
        return new Volvo240(100, Color.green, "Volvo240", 2);
    }

    public Car createSaab95(){
        return new Saab95(100, Color.green, "Saab95",2, false);
    }
    public Car createScania(){
        return new Scania (100, Color.green, "Scania", 2);
    }


}
