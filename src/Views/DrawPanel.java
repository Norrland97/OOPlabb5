package Views;

import Models.Position;
import Models.Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This panel represent the animated part of the view with the car images.
 */

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize fixa en satans HashMap JUH :D
    HashMap<String, BufferedImage> vehicleImages = new HashMap<>();
    // To keep track of a singel cars position
    Position vehiclePoint = new Position();

    private List<Vehicle> vehicles = new ArrayList<>();

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
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);

        //print an error message in case file is not found with a try/catch block

        try {
            //for (Models.Vehicle vehicle: vehicles) {
               // BufferedImage vehicleImage = ImageIO.read(new File(getFilePath(vehicle)));
               // vehicleImages.put(vehicle.toString(), vehicleImage);
            //}
            vehicleImages.put("Volvo240", ImageIO.read(new File("src" + File.separator + "pics" + File.separator +"Volvo240.jpg")));
            vehicleImages.put("Saab95", ImageIO.read(new File("src" + File.separator + "pics" + File.separator +"Saab95.jpg")));
            vehicleImages.put("Scania", ImageIO.read(new File("src" + File.separator + "pics" + File.separator +"Scania.jpg")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    //<T>String  getFilePath(T c){
    //    return "src" + File.separator + "pics" + File.separator + c.toString() +".jpg";
    //    // ersatt filsökvägen från där uppe och gör den generisk
    //}

    /**
     * This method is called each time the panel updates/refreshes/repaints itself
     */
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Vehicle v : vehicles) {
            //Models.Vehicle v = vehicles.get(i);
            int x = (int) Math.round(v.getCurrentPos().getX());
            int y = (int) Math.round(v.getCurrentPos().getY());
            g.drawImage(vehicleImages.get(v.toString()), x, y, null); // see javadoc for more info on the parameters
        }
    }
}
