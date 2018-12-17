package Views;

import Models.CarModel;
import Models.Position;
import Models.Vehicle;

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

    private HashMap<Vehicle, BufferedImage> vehicleImages = new LinkedHashMap<>();
    // To keep track of a singel cars position
    private Position point = new Position();

    public void moveit(int x, int y) {
        point.setX(x);
        point.setY(y);
    }

    /**
     * Initializes the panel and reads the images
     */
    DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);

        try {
            for (Models.Vehicle vehicle : CarModel.getCars()) {
                BufferedImage vehicleImage = ImageIO.read(new File(getFilePath(vehicle)));
                vehicleImages.put(vehicle, vehicleImage);
            }
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Vehicle vehicle : CarModel.getCars()) {
            int x = (int) Math.round(vehicle.getCurrentPos().getX());
            int y = (int) Math.round(vehicle.getCurrentPos().getY());
            g.drawImage(vehicleImages.get(vehicle), x, y, null); // see javadoc for more info on the parameters
        }
    }

    public void removeCarImage() {
        if (vehicleImages.size() > 0) {
            Object lastKey = new ArrayList<>(vehicleImages.keySet()).get(vehicleImages.size() - 1);
            vehicleImages.remove(lastKey);
        } else
            System.out.println("No cars to remove.");
    }

    public void addCarImage(Vehicle vehicle) {
        if (vehicleImages.size() < 10) {
            try {
                vehicleImages.put(vehicle, ImageIO.read(new File("src" + File.separator + "pics" + File.separator + "Volvo240.jpg")));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else
            System.out.println("Maximum number of cars reached.");
    }
}
