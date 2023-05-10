import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Background extends JPanel {
    private JLabel scoreLabel;

    private JButton restartButton;

    Main game = new Main();

    public Spaceship spaceShip = new Spaceship();
    public Stars stars = new Stars();
    public AlienGroups groupAliens = new AlienGroups();
    public ShipBullet shipBullet = new ShipBullet();

    public AlienBullet alienBullet1, alienBullet2;



    public int score = 0;
    private Font gameOverFont = new Font("Arial", Font.BOLD, 80);


    public Background() {
        super();
        //scorelable
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        scoreLabel.setBounds(10, 10, 150, 30);


        this.add(scoreLabel);

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


        //Drawing Alien bullet

        if(Time.countSteps % 900 == 0) {
            alienBullet1 = new AlienBullet(this.groupAliens.AlienRandomShot());}
        if(this.alienBullet1 != null) {
            this.alienBullet1.DrawingShootingAlien(g);
            if(this.alienBullet1.shipkey(spaceShip) == true) {this.spaceShip.setAlive(false);}
        }

        if(Time.countSteps % 1200 == 0) {
            alienBullet2 = new AlienBullet(this.groupAliens.AlienRandomShot());}
        if(this.alienBullet2 != null) {
            this.alienBullet2.DrawingShootingAlien(g);
            if(this.alienBullet2.shipkey(spaceShip) == true) {
                this.spaceShip.setAlive(false);}

        }

        if(this.groupAliens.getAlienNumber() == 0) {groupAliens = new AlienGroups();}


        if(this.groupAliens.positionAlienLowest() > Constants.Y_POSITION_Spaceship) {this.spaceShip.destructionSpaceShip();}

        scoreLabel.setText("Score: " +score);

        if(this.spaceShip.isAlive() == false) {

            g.setFont(gameOverFont);
            g.drawString("GAME OVER", 150, 400);

            restartButton = new JButton("Restart");
            restartButton.setPreferredSize(new Dimension(250, 50)); // customize the size of the button
            restartButton.setBackground(Color.green);
            restartButton.setForeground(Color.BLACK);
            restartButton.setFont(new Font("Arial", Font.BOLD, 18));

            // Set the position of the restart button
            restartButton.setBounds(250, 450, 250, 50);

            // Add the restart button to the panel
            this.add(restartButton);

            // Add an action listener to the restart button
            this.restartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    // Remove the restart button from the panel
                    remove(restartButton);

                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Main.background);

                     game.game = true;

                    // Call the main method of the Main class  to start the game
                    game.main(new String[0]);

                    currentFrame.dispose();

                }


            });

        }

    }
}