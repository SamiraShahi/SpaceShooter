import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Stars extends Spaceship implements Runnable {
    private static final long serialize= 1L;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int NUM_CIRCLES = 100;
    private static final int CIRCLE_SIZE = 2;

    private Random random = new Random();
    private int[] xC = new int[NUM_CIRCLES];
    private int[] yC = new int[NUM_CIRCLES];
    private boolean[] blink = new boolean[NUM_CIRCLES];

    public Stars() {
        setBackground(Color.BLACK);
        for (int i = 0; i < NUM_CIRCLES; i++) {
            xC[i] = random.nextInt(WIDTH - CIRCLE_SIZE);
            yC[i] = random.nextInt(HEIGHT - CIRCLE_SIZE);
            blink[i] = true;
        }
        Thread thread = new Thread(this);
        thread.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Paint stars
        g.setColor(Color.WHITE);
        for (int i = 0; i < NUM_CIRCLES; i++) {
            if (blink[i]) {
                g.fillOval(xC[i], yC[i], CIRCLE_SIZE, CIRCLE_SIZE);
            }
        }
    }

    public void run() {
        while (true) {
            // Blink stars
            for (int i = 0; i < NUM_CIRCLES; i++) {
                yC[i]+= 1;
                if (yC[i] > HEIGHT) {
                    yC[i] = 0;
                }
//               if (random.nextInt(100) < 5) {
//                   blink[i] = !blink[i];
        //        }
            }
            repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {

            }
        }
    }
}