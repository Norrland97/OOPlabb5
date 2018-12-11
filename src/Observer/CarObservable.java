package Observer;

public interface CarObservable {

    void notifyObservers(String notification);

    void addObserver(CarObserver carObserver);

}
