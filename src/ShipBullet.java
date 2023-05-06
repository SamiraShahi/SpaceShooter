import javax.swing.*;
import java.awt.*;

public class ShipBullet extends Entities{

    private boolean shooting = false;



    public ShipBullet(){
        super.xPos = 0;
        super.yPos = Constants.Y_POSITION_Spaceship;
        super.width = Constants.SPACESHIP_BULLET_WIDTH;
        super.height = Constants.SPACESHIP_BULLET_HEIGHT;
        super.dx = 0;
        super.dy = Constants.DY_BULLET;

        //Bullet Image location
        super.strImg1 = "/Resources/bullet.png";
        super.strImg2 = "";
        super.strImg3 = "";

        // Load Bullet image
        super.imgIcon = new ImageIcon(getClass().getResource(super.strImg1));
        super.img = this.imgIcon.getImage();
    }

    public boolean isShooting() {
        return shooting;
    }

    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }

    public int movementShooting() {
        if(this.shooting == true) {
            if(this.yPos > 0) {
                this.yPos = this.yPos - Constants.DY_BULLET;
            }
            else {
                this.shooting = false;
            }
        }
        return yPos;
    }

    public void DrawingBullet(Graphics g){
        if(this.shooting == true){
            g.drawImage(this.img,this.xPos,this.movementShooting(),null);
        }
    }

    public boolean killAlien(Alien alien) {
        // the shot from the ship destroys an alien
        if(this.yPos < alien.getyPos() + alien.getWidth()
                && this.yPos + this.width > alien.getyPos()
                && this.xPos + this.height > alien.getxPos()
                && this.xPos < alien.getxPos() + alien.getHeight()){
            return true;
        }
        else{return false;}
    }

}