import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reuben on 9/3/2015.
 * A tool used to create a new polygon
 */
public class NewPolygonTool extends MouseAdapter {

    //Final
    private final int DEFAULT_POINTSIZE = 10;

    //points in the newly created polygon
    private List<Point> points = new ArrayList<>();

    //graphics object to which each newly created point is draw
    private Graphics g;

    public  NewPolygonTool(Graphics g){
        this.g = g;
    }

    /**
     * Each time the mouse is clicked, the click location is added to a
     * running list of all points and that point is drawn onscreen.
     * @param e
     */
    public void mouseClicked(MouseEvent e) {
        points.add(new Point(e.getX(), e.getY()));
        g.drawOval(e.getX(), e.getY(), DEFAULT_POINTSIZE, DEFAULT_POINTSIZE);
    }

}
