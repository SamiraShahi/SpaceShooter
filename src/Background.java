import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Background extends JPanel implements ActionListener {
    private final int DELAY = 30;  //kati bistarai move hunxa bhanera
    private final Image backgImage = new ImageIcon("C:\\Java All\\SpaceShooter\\Resources\\SpaceShooter-Background.jpg").getImage();


    private int y1 = 0;  // current y position of 1 backing
    private int y2 = backgImage.getHeight(null);  // current y position of 2 back img




    public Background() {

         setPreferredSize(new Dimension(50, 50));

        Timer timer = new Timer(DELAY, this);
        timer.start();



    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //2 copies banauxa bich ma gap audaina
        g.drawImage(backgImage, 0, y1, null);
        g.drawImage(backgImage, 0, y2, null);


    }

    public void actionPerformed(ActionEvent e) {

        y1++;
        y2++;
        // If the first copy has moved off the screen, move it to the bottom
        if (y1 >= getHeight()) {
            y1 = y2 - backgImage.getHeight(null);
        }
        // If the second copy has moved off the screen, move it to the bottom
        if (y2 >= getHeight()) {
            y2 = y1 - backgImage.getHeight(null);
        }

        repaint();
    }





}
