import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class Main  {

    public static void main(String[] args) {
        JFrame frame = new JFrame(" Space Shooter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        Background background = new Background();
        frame.add(background);
        Spaceship spaceship = new Spaceship();
        frame.add(spaceship);
        Stars star=new Stars();
        frame.add(star);





        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

}
