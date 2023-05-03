import java.awt.*;
import javax.swing.*;

public class Background extends JPanel {
    public void paintComponent(Graphics g) {
        // Set the color to black
        g.setColor(Color.BLACK);
        // Fill the entire panel with black
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}