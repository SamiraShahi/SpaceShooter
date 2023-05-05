import javax.swing.*;
import java.awt.*;

public abstract class  Entities {
    protected int width, height , xPos , yPos, dx, dy;
    protected String shipImage, strImg1, strImg2, strImg3;
    protected ImageIcon imgIcon;
    protected boolean enemy;
    protected Image img;

    public String getStrImg1() {
        return strImg1;
    }

    public void setStrImg1(String strImg1) {
        this.strImg1 = strImg1;
    }

    public String getStrImg3() {
        return strImg3;
    }

    public void setStrImg3(String strImg3) {
        this.strImg3 = strImg3;
    }

    public String getStrImg2() {
        return strImg2;
    }

    public void setStrImg2(String strImg2) {
        this.strImg2 = strImg2;
    }

    public boolean isEnemy() {
        return enemy;
    }

    public void setEnemy(boolean enemy) {
        this.enemy = enemy;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public String getShipImage() {
        return shipImage;
    }

    public void setShipImage(String shipImage) {
        this.shipImage = shipImage;
    }

    public ImageIcon getImgIcon() {
        return imgIcon;
    }

    public void setImgIcon(ImageIcon imgIcon) {
        this.imgIcon = imgIcon;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
