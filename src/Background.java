import java.awt.*;
import javax.swing.*;


public class Background extends JPanel {
    public Spaceship spaceShip = new Spaceship();
    public Stars stars = new Stars();


    public Background() {
        super();

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Keyboard());
        Thread timer = new Thread(new Time());
        timer.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the color to black
        g.setColor(Color.BLACK);
        // Fill the entire panel with black
        g.fillRect(0, 0, getWidth(), getHeight());


//      // SpaceShip Design

        g.drawImage(this.spaceShip.getImg(),this.spaceShip.movementSpaceShip(),this.spaceShip.getyPos(),null);

        //Star Genereate
        g.setColor(Color.WHITE);
        for (int i = 0; i < Constants.NUM_CIRCLES; i++) {
            if (Constants.blink[i]) {
                g.fillOval(Constants.xC[i], Constants.yC[i], Constants.CIRCLE_SIZE, Constants.CIRCLE_SIZE);
            }
        }
    }
}