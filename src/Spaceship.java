import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Spaceship extends JPanel implements ActionListener {
    private final int DELAY = 10;
    private final Image spaceshipImage = new ImageIcon("C:\\Java All\\SpaceShooter\\Resources\\SpaceShip.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    private int x = 400;
    private int y = 400;
    private int dx = 0;
    private int dy = 0;

    public Spaceship() {
        Timer timer = new Timer(DELAY, this);
        timer.start();

        addKeyListener(new MyKeyListener());
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(spaceshipImage, x, y, null);
    }

    public void actionPerformed(ActionEvent e) {
        x += dx;
        y += dy;

        if (x < 0) {
            x = 0;
        } else if (x > getWidth() - spaceshipImage.getWidth(null)) {
            x = getWidth() - spaceshipImage.getWidth(null);
        }

        if (y < 0) {
            y = 0;
        } else if (y > getHeight() - spaceshipImage.getHeight(null)) {
            y = getHeight() - spaceshipImage.getHeight(null);
        }

        repaint();
    }

    private class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if (keyCode == KeyEvent.VK_LEFT) {
                dx = -5;
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                dx = 5;
            } else if (keyCode == KeyEvent.VK_UP) {
                dy = -5;
            } else if (keyCode == KeyEvent.VK_DOWN) {
                dy = 5;
            }
        }

        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) {
                dx = 0;
            } else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
                dy = 0;
            }
        }
    }
}

