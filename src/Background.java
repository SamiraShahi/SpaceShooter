import java.awt.*;
import javax.swing.*;


public class Background extends JPanel {
    public Spaceship spaceShip = new Spaceship();
    public Stars stars = new Stars();
    public AlienGroups groupAliens = new AlienGroups();
    public ShipBullet shipBullet = new ShipBullet();

    public AlienBullet alienBullet1, alienBullet2, alienBullet3;


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

        // Dessin des tirs des aliens
        if(Time.countSteps % 700 == 0) {
            alienBullet1 = new AlienBullet(this.groupAliens.AlienRandomShot());}
        if(this.alienBullet1 != null) {this.alienBullet1.DrawingShootingAlien(g);}
        if(Time.countSteps % 800 == 0) {
            alienBullet2 = new AlienBullet(this.groupAliens.AlienRandomShot());}
        if(this.alienBullet2 != null) {this.alienBullet2.DrawingShootingAlien(g);}
        if(Time.countSteps % 900 == 0) {
            alienBullet3 = new AlienBullet(this.groupAliens.AlienRandomShot());}
        if(this.alienBullet3 != null) {this.alienBullet3.DrawingShootingAlien(g);}



    }
}