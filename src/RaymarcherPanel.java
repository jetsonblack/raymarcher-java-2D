import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

/**
 * Displays and updates the logic for the top-down raymarcher.
 */
public class RaymarcherPanel extends JPanel {

    /**
     * We need to keep a reference to the parent swing app for sizing and
     * other bookkeeping.
     */
    private final RaymarcherRunner raymarcherRunner;
    private final Camera moveCam;
    private final List<CollisionObject> obj;

    public RaymarcherPanel(RaymarcherRunner raymarcherRunner) {
        this.raymarcherRunner = raymarcherRunner;
        this.setPreferredSize(new Dimension(this.raymarcherRunner.getFrame().getHeight(),
                this.raymarcherRunner.getFrame().getHeight()));

        // This is the list of random objects we will iterate through
        this.obj = createList();

        // Instance of camera
        moveCam = new Camera(0, 0);

        // Adding listeners for camera movement
        this.addMouseMotionListener(moveCam);
        this.addMouseListener(moveCam);
        this.addKeyListener(moveCam);
    }

    // Method for adding randomly sized shapes to the list using random method
    public List createList() {
        List<CollisionObject> objects = new ArrayList<>();
        Random ran = new Random();
        // for loop that generates 15 objects on the panel
        for (int i = 0; i < 16; i++) {
            double x = ran.nextDouble(500);
            double y = ran.nextDouble(500);
            if (ran.nextBoolean()) {
                double r = ran.nextDouble(100) + 10;
                objects.add(new CircleObject(x, y, r));
            } else {
                double width = ran.nextDouble(200) + 10;
                double height = ran.nextDouble(200) + 10;
                objects.add(new RectangleObject(x, y, width, height));
            }
        }
        return objects;
    }

    // march method allows the use of March class
    public ArrayList<March> march(){
        ArrayList<March> marches = new ArrayList<>();
        Point2D vertex = new Point2D.Double(moveCam.getX(),moveCam.getY());
        Point2D vertexCopy = new Point2D.Double(moveCam.getX(),moveCam.getY());

        while(vertex.getX() >= 0 && vertex.getX() <= getWidth() && vertex.getY() >= 0 && vertex.getY() <= getHeight()){
            double min = Integer.MAX_VALUE;
            for(CollisionObject o : obj){
                min = Math.min(min,o.computeDistance(vertex.getX(),vertex.getY()));
            }
            if(min < 0.01)
            {
                break;
            }
            // Use the camera angle
            double ex = (vertex.getX() + min * Math.cos(Math.toRadians(moveCam.getAngle())));
            double ey = (vertex.getY() + min * Math.sin(Math.toRadians(moveCam.getAngle())));
            vertex = new Point2D.Double(ex,ey);
            marches.add(new March(vertexCopy,vertex));
            vertexCopy = vertex;
        }
        return marches;
    }

    // Iterating through List<CollisionObject> obj to draw the actual objects on the screen, along with the marches
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Random rainbowColors = new Random();
        g2d.setColor(Color.BLUE);

        double minDistance = Integer.MAX_VALUE;

        Color rainbow = new Color(rainbowColors.nextInt(250), rainbowColors.nextInt(250), rainbowColors.nextInt(250));
        g2d.setColor(rainbow);

        // Draw collision objects
        for (CollisionObject o : obj) {
            minDistance = Math.min(minDistance, o.computeDistance(moveCam.getX(), moveCam.getY()));
            o.drawObject((Graphics2D) g);

        }

        // Draw marches
        for(March mar : march()){
            mar.drawObject(g2d);
            moveCam.drawObject((Graphics2D) g);
        }
    }
}
