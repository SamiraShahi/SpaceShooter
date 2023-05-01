import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame(" Space Shooter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 800);
        frame.add(new Background());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }



}
