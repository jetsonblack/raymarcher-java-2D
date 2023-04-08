import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;

public class RectangleObject extends CollisionObject{
    private double height;
    private double width;
    private Color color;
    private double distanceFromObj;


    public RectangleObject(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;

        Random rainbowColors = new Random();
        this.color = new Color(rainbowColors.nextInt(250), rainbowColors.nextInt(250), rainbowColors.nextInt(250));
    }

    // Getters
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }

    // Setters
    public void setWidth(double width){
        this.width = width;
    }
    public void setHeight(double height){
        this.height = height;
    }

    // Draw rectangle object
    @Override
    public void drawObject(Graphics2D g2d) {
        Color objColor = g2d.getColor();
        g2d.setColor(color);
        g2d.fillRect((int) (getX() - width/2), (int) (getY() - height/2), (int) width, (int) height);
        g2d.setColor(objColor);
    }

    // Fun and whacky algorithm to computer distance from camera compared to line segments of rectangle
    @Override
    public double computeDistance(double cameraX, double cameraY) {
        double rectangleWidth = (getX() - width / 2);
        double rectangleHeight = (getY() - height / 2);
        Line2D L1 = new Line2D.Double(rectangleWidth, rectangleHeight, rectangleWidth + width, rectangleHeight);
        Line2D L2 = new Line2D.Double(rectangleWidth, rectangleHeight, rectangleWidth, rectangleHeight + height);
        Line2D L3 = new Line2D.Double(rectangleWidth + width, rectangleHeight, rectangleWidth + width, rectangleHeight + height);
        Line2D L4 = new Line2D.Double(rectangleWidth, rectangleHeight + height, rectangleWidth + width, rectangleHeight + height);

        double distance1 = L1.ptSegDist(cameraX, cameraY);
        double distance2 = L2.ptSegDist(cameraX, cameraY);
        double distance3 = L3.ptSegDist(cameraX, cameraY);
        double distance4 = L4.ptSegDist(cameraX, cameraY);

        double distanceFromObj = Math.min(Math.min(distance1, distance2), Math.min(distance3, distance4));
        return distanceFromObj;
    }
}
