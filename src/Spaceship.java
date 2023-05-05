import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

public class Spaceship extends Entities{


    public Spaceship() {
        super.xPos = Constants.X_POSITION_Spaceship;
        super.yPos = Constants.Y_POSITION_Spaceship;
        super.width = Constants.SPACESHIP_WIDTH;
        super.height = Constants.SPACESHIP_HEIGHT;
        super.dx = 0;
        super.dy = 0;

        super.shipImage = "/Resources/Spaceship.png";


        super.imgIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(super.shipImage)));
        super.img = this.imgIcon.getImage();

    }

    public int movementSpaceShip() {

        if (this.dx < 0) {
            if (this.xPos > Constants.limit_left_ship) {
                this.xPos = this.xPos + this.dx;
            }
        } else if (dx > 0) {
            if (this.xPos + this.dx < Constants.limit_right_ship) {
                this.xPos = this.xPos + this.dx;
            }

        }
        return this.xPos;

    }

    public void DesignAlienShip(Graphics g){
        g.drawImage(this.img,this.movementSpaceShip(), this.yPos, null);
    }



}

