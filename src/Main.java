import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame(" Space Shooter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Background background = new Background();
        Spaceship spaceship = new Spaceship();


        frame.setSize(800, 800);
        frame.add(background);
        frame.add(spaceship);



        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);


        
    }



}
