/**
 * Created by Reuben on 9/5/2015.
 * A 2 dimensional vector
 */
public class Vector {

    //vector components
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    //Vector math operation
    public double getMagnitude() {
        return Math.sqrt((x * x) + (y * y));
    }

    public static Vector add(Vector v1, Vector v2) {
        return new Vector(v1.getX() + v2.getX(), v1.getY() + v2.getY());
    }

    public static Vector subtract(Vector v1, Vector v2) {
        return new Vector(v1.getX() - v2.getX(), v1.getY() - v2.getY());
    }

    public static double dotProduct(Vector v1, Vector v2) {
        return (v1.getX() * v2.getX()) + (v1.getY() + v2.getY());
    }

    public static Vector scale(Vector v, double scale) {
        return new Vector(v.getX() * scale, v.getY() * scale);
    }

    public static Vector normalize(Vector v) {
        return scale(v, 1 / v.getMagnitude());
    }


}
