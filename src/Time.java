
public class Time implements Runnable{
    private final int PAUSE = 5;
    @Override
    public void run() {
        while (true) {
            Main.background.repaint();
            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
