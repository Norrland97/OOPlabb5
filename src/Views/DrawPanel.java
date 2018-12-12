package Views;

import Models.Position;
import Models.Vehicle;
import Models.VehicleFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This panel represent the animated part of the view with the car images.
 */

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize fixa en satans HashMap JUH :D
    HashMap<Vehicle, BufferedImage> vehicleImages = new LinkedHashMap<>();
    // To keep track of a singel cars position
    Position vehiclePoint = new Position();

    private List<Vehicle> vehicles;

    // TODO: Make this genereal for all cars (typ gå igenom en lista med alla bilar och kolla deras position...)
    public void moveit(int x, int y) {
        vehiclePoint.setX(x);
        vehiclePoint.setY(y);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * Initializes the panel and reads the images
     */
    public DrawPanel(int x, int y, List<Vehicle> vehicles) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);
        this.vehicles = vehicles;

        //print an error message in case file is not found with a try/catch block

        try {
            for (Models.Vehicle vehicle : vehicles) {
                BufferedImage vehicleImage = ImageIO.read(new File(getFilePath(vehicle)));
                vehicleImages.put(vehicle, vehicleImage);
            }
            // vehicleImages.put(VehicleFactory.createVolvo240(), ImageIO.read(new File("src" + File.separator + "pics" + File.separator +"Volvo240.jpg")));
            // vehicleImages.put(VehicleFactory.createSaab95(), ImageIO.read(new File("src" + File.separator + "pics" + File.separator +"Saab95.jpg")));
            // vehicleImages.put(VehicleFactory.createScania(), ImageIO.read(new File("src" + File.separator + "pics" + File.separator +"Scania.jpg")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    <T>String  getFilePath(T c){
        return "src" + File.separator + "pics" + File.separator + c.toString() +".jpg";
        // ersatt filsökvägen från där uppe och gör den generisk
    }

    /**
     * This method is called each time the panel updates/refreshes/repaints itself
     */
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Vehicle vehicle : vehicles) {
            //Models.Vehicle v = vehicles.get(i);
            int x = (int) Math.round(vehicle.getCurrentPos().getX());
            int y = (int) Math.round(vehicle.getCurrentPos().getY());
            g.drawImage(vehicleImages.get(vehicle), x, y, null); // see javadoc for more info on the parameters
        }
    }

    public void removeCarImage() {
        if (vehicleImages.size() > 0) {
            Object lastKey = new ArrayList<>(vehicleImages.keySet()).get(vehicleImages.size() - 1);
            vehicleImages.remove(lastKey);
        }
    }

    public void addCarImage() {
        if (vehicleImages.size() < 9) {
            try {
                vehicleImages.put(VehicleFactory.createVolvo240(), ImageIO.read(new File("src" + File.separator + "pics" + File.separator + "Volvo240.jpg")));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
