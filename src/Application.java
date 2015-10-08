import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Reuben on 9/2/2015.
 * Driver for the Rigid Body simulator.
 */
public class Application {

    public static void main(String[] args) {
        World testWorld = new World();
        WorldGui testGui = new WorldGui(testWorld);
        testWorld.addRigidBody(Polygon.simpleSquare(30, new Point(0,0)));
        testWorld.start();
    }
}
