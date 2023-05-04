public abstract class Constants {

    //Screen Size
    public static final int Window_height = 800;
    public static final int Window_width = 800;

    //    Dimension of spaceship
    public static final int SPACESHIP_WIDTH = 0;
    public static final int SPACESHIP_HEIGHT = 0;

    //Position initial of Spaceship
    public final static int X_POSITION_Spaceship = (Window_width- SPACESHIP_WIDTH)/2;
    public final static int Y_POSITION_Spaceship = 650;

    //
    public final static int DX_Spaceship = 3;
//    public final static int DY_Spaceship = 1;


    // Limit movement of spaceship
    public final static int limit_left_ship = 40;
    public final static int limit_right_ship = 700;
    public static final int NUM_CIRCLES = 100;

    //Star

    public static final int CIRCLE_SIZE = 2;

    public static int[] xC = new int[NUM_CIRCLES];

    public static int[] yC = new int[NUM_CIRCLES];

    public static boolean[] blink = new boolean[NUM_CIRCLES];

}
