import java.awt.*;

public abstract class CollisionObject implements Drawable {
    private double x;
    private double y;
    private Color color;
    public CollisionObject(double x, double y){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    // Getters
     public double getX(){
        return x;
     }
     public double getY(){
        return y;
     }

     // Setters
     public void setX(double x){
        this.x = x;
     }
     public void setY(double y){
        this.y = y;
     }

    @Override
    public abstract void drawObject(Graphics2D g2d);

    @Override
    public abstract double computeDistance(double cameraX, double cameraY);
}
