/**
 * Created by Reuben on 9/2/2015.
 * A custom swing component that renders out a World
 */

import javax.swing.*;
import java.awt.*;

public class WorldPaintComponent extends JPanel {

    //Default window size
    private final Dimension DEFAULT_SIZE = new Dimension(500, 500);
    //The World to be rendered
    private World world;

    /**
     * Custom PaintComponent Constructor
     * @param world the World to be rendered
     */
    public WorldPaintComponent(World world) {
        super();
        this.world = world;
        this.setPreferredSize(DEFAULT_SIZE);
    }

    @Override
    /**
     * Called to paint the World
     */
    public void paintComponent(Graphics g){
        System.out.println("called");
        //fills the background color of the world
        g.setColor(this.world.getCurrentBackgroundColor());
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        if(this.world.isRunning()){
            g.setColor(Color.BLACK);
            g.drawString("Running", 10, this.getHeight()-10);
        } else {
        }
        //draws each body in the world
        for(RigidBody body : this.world.getBodies()) {
            body.draw(g);
            System.out.println("painted!");
        }

    }
}
