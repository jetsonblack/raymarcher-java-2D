import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class March implements Drawable{
    private Point2D startingCoor;
    private Point2D endingCoor;

    public March(Point2D startingCoor, Point2D endingCoor){
        this.startingCoor = startingCoor;
        this.endingCoor = endingCoor;
    }

    public Point2D getStartingCoor() {
        return startingCoor;
    }

    public Point2D getEndingCoor() {
        return endingCoor;
    }

    // Algorithm for drawing marches
    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        g2d.draw(new Line2D.Double(startingCoor, endingCoor));
        double rad = startingCoor.distance(endingCoor);
        double diameter = rad * 2;
        double x = startingCoor.getX() - rad;
        double y = startingCoor.getY() - rad;
        g2d.setColor(Color.GREEN);
        g2d.drawOval((int) x, (int) y, (int) diameter, (int) diameter);
    }

    // Compute the distance from the end coordinate of the line segment
    @Override
    public double computeDistance(double cameraX, double cameraY) {
        return endingCoor.distance(cameraX, cameraY);
    }
}
