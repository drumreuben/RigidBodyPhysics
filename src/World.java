/**
 * Created by Reuben on 9/2/2015.
 * Holds and simulates the interactions between multiple rigid bodies.
 * A world can be imported and exported as a txt file.
 */
import org.w3c.dom.css.RGBColor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class World implements DrawAble {

    //The default background color of the window.
    private final Color DEFAULT_BACKGROUND_COLOR = new Color(153, 231, 223);

    //default value for gravity
    public static final Double GRAVITY = -1.0;

    //Rigid Bodies in the World
    private List<RigidBody> bodies;

    //The custom painter that renders the world
    private WorldPaintComponent worldPainter;

    //Current Background color of the World
    private Color currentBackgroundColor;

    //is the simulation running.
    private boolean running = false;

    //timestamps for properly handling frames per second and animation\
    private double simulationStart;
    private double simulationEnd;
    private double elapsedTime;

    /**
     * Constructor
     */
    public World() {
        this.currentBackgroundColor = DEFAULT_BACKGROUND_COLOR;
        this.bodies = new ArrayList<>();
        this.worldPainter = new WorldPaintComponent(this);
    }

    /**
     * @return the world's current background color
     */
    public Color getCurrentBackgroundColor() {
        return currentBackgroundColor;
    }

    /**
     * @return the Rigid Bodies in the World
     */
    public List<RigidBody> getBodies() {
        return bodies;
    }

    /**
     * Draws the world;
     */
    public void draw(Graphics g) {
        worldPainter.repaint();
    }

    /**
     * main simulation loop. runs if running is true
     * Runs as fast as possible.
     */
    public void start() {
        simulationEnd = System.currentTimeMillis();
        while(true) {
            if (this.running) {
                simulationStart = System.currentTimeMillis();
                elapsedTime = simulationStart - simulationEnd;
                if(elapsedTime == 0) elapsedTime = .001;
                applyPhysics();
                moveBodies(elapsedTime * .0001);
                System.out.println("calling paint component");
                this.worldPainter.repaint();
                System.out.println("called repaint");
                simulationEnd = System.currentTimeMillis();
            }
        }
    }

    /**
     * Toggles whether the simulation is running
     */
    public void toggleRunning() {
        running = !running;
    }

    public boolean isRunning() {
        return running;
    }

    /**
     * Displays the state of the world at that time
     * @return
     */
    public WorldPaintComponent getWorldPainter() {
        return worldPainter;
    }

    public void addRigidBody(RigidBody rigidBody) {
        bodies.add(rigidBody);
    }

    public void applyPhysics(){
        System.out.println("applying physics");
        //first applies the force of gravity to all objects
        for (RigidBody body : bodies) {
            body.applyForce(new Vector(0, -GRAVITY));
        }
    }

    public void moveBodies(double elapsedTime) {
        System.out.println("moving bodies with elapsed time " + elapsedTime);
        for (RigidBody b : bodies) {
            b.move(elapsedTime);
        }
    }


}
