import java.awt.*;
import java.awt.event.MouseEvent;

public interface Drawable {
    void drawObject(Graphics2D g2d);

    double computeDistance(double cameraX, double cameraY);
}
