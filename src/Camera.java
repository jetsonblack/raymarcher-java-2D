import java.awt.*;
import java.awt.event.*;

public class Camera implements Drawable, MouseMotionListener, MouseListener, KeyListener {
    private double x;
    private double y;
    private final double radius = 5;
    private double angle;

    public Camera(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Initial getters for the class
    public double getRadius() {
        return radius;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    // Initial setters for the class
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    // Algorithm for drawing the camera circle
    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        double diameter = radius * 2;
        double xPos = x;
        double yPos = y;
        g2d.drawOval((int) ((int) xPos - radius), (int) ((int) yPos - radius), (int) diameter, (int) diameter);
    }

    @Override
    public double computeDistance(double cameraX, double cameraY) {
        return cameraX;
    }

    // MouseMotionListener methods
    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point position = e.getPoint();
        setX(position.x);
        setY(position.y);
    }

    // MouseListener methods
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e){
        if(e.getButton() == MouseEvent.BUTTON1){
            angle ++;
        }else if(e.getButton() == MouseEvent.BUTTON3){
            angle --;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    // Angle getter that is used to calculate angle of line seg. in march() of RaymarcherPanel
    double getAngle(){
        return angle;
    }

    // Keylistener methods
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            angle ++;
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            angle --;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
