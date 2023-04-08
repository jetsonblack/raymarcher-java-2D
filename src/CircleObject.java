import java.awt.*;
import java.util.Random;

public class CircleObject extends CollisionObject {
    private double radius;
    private final Color color;

    public CircleObject(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;

        Random rainbowColors = new Random();
        this.color = new Color(rainbowColors.nextInt(250), rainbowColors.nextInt(250), rainbowColors.nextInt(250));
    }

    // Getter
    public double getRadius() {
        return radius;
    }

    // Setter
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Algorithm for drawing circles
    @Override
    public void drawObject(Graphics2D g2d) {
        Color circleColor = g2d.getColor();
        g2d.setColor(color);
        int diameter = (int)(getRadius() * 2);
        int x = (int)(getX() - getRadius());
        int y = (int)(getY() - getRadius());
        g2d.fillOval(x, y, diameter, diameter);
        g2d.setColor(circleColor);
    }

    // Distance formula
    @Override
    public double computeDistance(double cameraX, double cameraY) {
        double distanceFromObj = Math.sqrt(Math.pow(cameraX - getX(), 2) + Math.pow(cameraY - getY(), 2)) - getRadius();
        return distanceFromObj;
    }
}