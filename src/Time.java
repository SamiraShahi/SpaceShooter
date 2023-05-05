
public class Time implements Runnable{
    private final int PAUSE = 5;
    public static int countSteps = 0;
    @Override
    public void run() {
        while (true) {
            countSteps++;
            Main.background.repaint();
            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
