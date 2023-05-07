import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AlienBullet extends Entities{
    //Variable
    Random chance = new Random();

    public AlienBullet(int [] arrayPositionAlien) {
        // Initialisation des variables de la super classe
        super.xPos = arrayPositionAlien[0] + Constants.WIDTH_ENEMY /2 - 1;
        super.yPos = arrayPositionAlien[1] + Constants.HEIGHT_ENEMY;
        super.width = Constants.ALIEN_BULLET_WIDTH;
        super.height = Constants.ALIEN_BULLET_HEIGHT;
        super.dx = 0;
        super.dy = Constants.DY_BULLET_ALIEN;
        // Adresse des images du vaisseau
        super.strImg1 = "/Resources/shotAlien1.png";
        super.strImg2 = "/Resources/shotAlien2.png";
        super.strImg3 = "";
        // Chargement de l'image du tir de l'alien
        if(chance.nextInt(2) == 0) {
            super.imgIcon = new ImageIcon(getClass().getResource(super.strImg1));}
        else {super.imgIcon = new ImageIcon(getClass().getResource(super.strImg2));}
        super.img = this.imgIcon.getImage();
    }

    /**** METHODE ****/

    public int deplacementShotAlien() {
        if(Time.countSteps % 4 == 0) {
            if(this.yPos < 1200) {this.yPos = this.yPos + Constants.DY_BULLET_ALIEN;}
        }
        return yPos;
    }

    public void DrawingShootingAlien(Graphics g){
        g.drawImage(this.img, this.xPos, this.deplacementShotAlien(), null);
    }

}