import java.awt.*;
import javax.swing.*;


public class Background extends JPanel {
    public Spaceship spaceShip = new Spaceship();
    public Stars stars = new Stars();
    public AlienGroups groupAliens = new AlienGroups();
    public ShipBullet shipBullet = new ShipBullet();


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


        //Star Genereate
        g.setColor(Color.WHITE);
        for (int i = 0; i < Constants.NUM_CIRCLES; i++) {
            if (Constants.blink[i]) {
                g.fillOval(Constants.xC[i], Constants.yC[i], Constants.CIRCLE_SIZE, Constants.CIRCLE_SIZE);
            }
        }

        //Design SpaceShip
        this.spaceShip.DesignAlienShip(g);

        this.groupAliens.designAlien(g);

        //Drawing of Bullet
        this.shipBullet.DrawingBullet(g);

        // Detect shipShot contact with alien
        this.groupAliens.ShipBulletTouchAlien(this.shipBullet);
    }
}