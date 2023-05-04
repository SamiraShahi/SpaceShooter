import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class Main  {

    public static Background background;

    public static void main(String[] args) {
        JFrame frame = new JFrame(" Space Shooter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Constants.Window_width, Constants.Window_height);

         background = new Background();
        frame.setContentPane(background);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

}
