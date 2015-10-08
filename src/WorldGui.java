/**
 * Created by Reuben on 9/2/2015.
 * Displays the world and allows the user to interact with it.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class WorldGui {

    //the default window size
    private final Dimension DEFAULT_SIZE = new Dimension(500, 500);

    //standard Icon size
    private final Dimension STANDARD_ICON_SIZE = new Dimension(75, 75);

    //The Swing container of the Gui
    private JFrame window;

    //The world currently being displayed
    private World world;

    //A map of all the image icons used in the Gui
    HashMap<String, ImageIcon> iconHashMap;

    /**
     * Gui Constructor
     * @param world The World displayed by the Gui
     */
    public WorldGui(World world) {
        this.world = world;
        this.iconHashMap = loadImages();
        this.window = makeWindow(world);
        this.window.setVisible(true);
    }

    /**
     * Builds the Gui
     * @param world The World Displayed by the Gui
     * @return The finalized Gui JFrame including all components
     */
    private JFrame makeWindow(World world) {
        //creates the window
        JFrame window = new JFrame("Rigid Body Simulator");
        //window.setSize(DEFAULT_SIZE);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //the top level JPanel
        JPanel parent = new JPanel(new BorderLayout());
        //The panel that holds the world
        JPanel worldPanel = world.getWorldPainter();
        parent.add(worldPanel);
        JPanel sidebar = makeSidebar();
        parent.add(sidebar, BorderLayout.LINE_END);
        //Adds parent to the window
        window.add(parent);
        window.pack();
        return window;
    }

    /**
     * Creates the Sidebar
     */
    private JPanel makeSidebar() {
        int width = 75;
        int height = 500;
        Dimension yGap= new Dimension(0, 10);
        final JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.PAGE_AXIS));
        sidebar.setPreferredSize(new Dimension(width, height));

        /**
         * adds buttons to the sidebar
         */

        //Toggles the physics engine on and off
        JButton startStop = new JButton(iconHashMap.get("startStopIcon"));
        startStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("startStop clicked");
                world.toggleRunning();
            }
        });
        startStop.setMaximumSize(STANDARD_ICON_SIZE);
        sidebar.add(startStop);
        sidebar.add(new Box.Filler(yGap, yGap, yGap));

        //imports a world from a txt file
        JButton importWorld = new JButton(iconHashMap.get("importWorldIcon"));
        importWorld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("importWorld clicked");
            }
        });
        importWorld.setPreferredSize(STANDARD_ICON_SIZE);
        sidebar.add(importWorld);
        sidebar.add(new Box.Filler(yGap, yGap, yGap));

        //exports the current world to a txt file
        JButton exportWorld = new JButton(iconHashMap.get("exportWorldIcon"));
        exportWorld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("exportWorld clicked");
            }
        });
        exportWorld.setPreferredSize(STANDARD_ICON_SIZE);
        sidebar.add(exportWorld);
        sidebar.add(new Box.Filler(yGap, yGap, yGap));

        //launches the polygon creation utility
        JButton newPolygon = new JButton("New Polygon");
        newPolygon.setMaximumSize(STANDARD_ICON_SIZE);
        newPolygon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("foo");
            }
        });

        return sidebar;
    }

    /**
     * loads and scales the necessary images
     */
    private HashMap<String, ImageIcon> loadImages() {
        HashMap<String, ImageIcon> iconHashMap = new HashMap<>();
        iconHashMap.put("startStopIcon", scaleIcon(new ImageIcon("startStopIcon.png")));
        iconHashMap.put("importWorldIcon", scaleIcon(new ImageIcon("importWorldIcon.png")));
        iconHashMap.put("exportWorldIcon", scaleIcon(new ImageIcon("exportWorldIcon.png")));
        return iconHashMap;
    }

    /**
     * Scales an image icon to its proper size
     */
    private ImageIcon scaleIcon(ImageIcon icon) {
        Image image = icon.getImage();
        Image scaled = image.getScaledInstance(STANDARD_ICON_SIZE.width, STANDARD_ICON_SIZE.height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }
}
