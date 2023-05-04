import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.http.WebSocket;

public class Keyboard implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode==KeyEvent.VK_RIGHT){
            Main.background.spaceShip.setDx(Constants.DX_Spaceship);
        }
        if (keyCode == KeyEvent.VK_LEFT){
            Main.background.spaceShip.setDx(- Constants.DX_Spaceship);
        }
        if (keyCode == KeyEvent.VK_UP) {
            Main.background.spaceShip.setDy(  5);
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            Main.background.spaceShip.setDy( -5);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) {
            Main.background.spaceShip.setDx(0);
        }
        else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
            Main.background.spaceShip.setDy(0);
        }
    }
}
