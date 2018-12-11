package Models;

/**
 * Represents The interface Models.Movable, for movable items.
 * This has three methods which are move, turnLeft and turnRight.
 */
public interface Movable {

    /**
     * Moves the object
     */
    void move();

    /**
     * turns the object left
     */
    void turnLeft();

    /**
     * turns the object right
     */
    void turnRight();

}
