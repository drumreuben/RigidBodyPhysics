import java.awt.*;

/**
 * Created by Reuben on 9/2/2015.
 * A rigid object which can interact with other rigid bodies and its surroundings.
 * Rigid bodies are held in a World.
 */
public abstract class RigidBody implements DrawAble {

    protected double xPos;
    protected double yPos;
    protected Vector velocity;
    protected double mass;


    public RigidBody(){
        this.velocity = new Vector(0, 0);
    }
    /**
     * Draws the body
     */
    public abstract void draw(Graphics g);


    /**
     * applies a force to the bodies center of mass as a vector
     */
    public abstract void applyForce(Vector force);

    /**
     * Accelerates an object based off of an acceleration vector
     */
    public abstract void applyAcceleration(Vector acceleration);

    /**
     * updates body position based on velocity and elapsed time
     */
    public abstract void move(double elapsedTime);
}
