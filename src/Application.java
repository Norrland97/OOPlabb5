import Controllers.CarController;
import Models.CarModel;

public class Application {

    public static void main(String[] args){
        CarController cc = new CarController();
        CarModel.addVolvo();
        CarModel.addSaab();
        CarModel.addScania();
        cc.initCarcontroller();

    }
}
