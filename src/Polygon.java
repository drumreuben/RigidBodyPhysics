import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reuben on 9/3/2015.
 * A rigid body represented by a list of vertices.
 */
public class Polygon extends RigidBody {

    //Final
    private final Color DEFAULT_COLOR = Color.WHITE;
    private final double DEFAULT_Mass = 10;

    //Non Final
    private List<Point> points;
    private int[] xPoints;
    private int[] yPoints;
    private Color currentColor;

    /**
     * Constructor that uses the default Color
     * @param points the points of the polygon
     */
    public Polygon(List<Point> points) {
        this.points = points;
        this.xPoints = new int[points.size()];
        this.yPoints = new int[points.size()];
        for(int i = 0; i < points.size(); i++) {
            xPoints[i] = (int)points.get(i).getX();
            yPoints[i] = (int)points.get(i).getY();
        }
        currentColor = DEFAULT_COLOR;
        this.mass = DEFAULT_Mass;
    }

    public Polygon(List<Point> points, Color color) {
        this(points);
        currentColor = color;
        this.mass = DEFAULT_Mass;
    }

    /**
     * Draws the polygon
     */
    public void draw(Graphics g) {
        g.setColor(this.currentColor);
        g.fillPolygon(xPoints, yPoints, points.size());
    }

    /**
     * Generates a simple square. Useful for testing.
     * @param sideLength the length of each side
     * @param startPoint the upper leftmost point of the square
     * @return the complete square
     */
    public static Polygon simpleSquare(int sideLength, Point startPoint) {
        List<Point> points = new ArrayList<>();
        int startX = startPoint.x;
        int startY = startPoint.y;
        points.add(startPoint);
        points.add(new Point(startX+sideLength, startY));
        points.add(new Point(startX+sideLength, startY+sideLength));
        points.add(new Point(startX, startY+sideLength));
        return new Polygon(points);
    }

    /**
     * Applies a vector force to the center of mass of a body
     * @param force the force to be applied
     */
    public void applyForce(Vector force){
        Vector acceleration = Vector.scale(force, 1 / mass);
        applyAcceleration(acceleration);
    }

    /**
     * applies an acceleration vector too the objects velocity
     * @param acceleration the acceleration to be applied
     */
    public void applyAcceleration(Vector acceleration) {
        velocity = Vector.add(velocity, acceleration);
    }

    /**
     * updates body position based on velocity and elapsed time
     */
    public void move(double elapsedTime) {
        double xStep = velocity.getX() * elapsedTime;
        System.out.println("xStep: " + xStep);
        double yStep = velocity.getY() * elapsedTime;
        System.out.println("yStep: " + yStep);
        this.xPos += xStep;
        this.yPos += yStep;
        for(int i = 0; i < points.size(); i++) {
            xPoints[i] += xStep;
            yPoints[i] += yStep;
        }
        System.out.println("new positions are x: " + xPos + ", y: " + yPos);
    }
}
