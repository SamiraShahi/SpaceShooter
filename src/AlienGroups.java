


import java.awt.*;

public class AlienGroups {

    //Variable

    // Table containing all aliens

    private final Alien[][] arrAlien = new Alien[5][10];
    private boolean goARight,pos1;
    private int speed;

    //Constructor
    public AlienGroups() {
        this.initArrayAliens();
        this.goARight = true;
        this.pos1 = true;
        this.speed = Constants.ALIEN_SPEED;
    }



    private void initArrayAliens() {
        //Method that fills the full array of aliens
        for(int i=0; i<10; i++) {
            this.arrAlien[0][i] = new Alien(Constants.X_POS_INIT_ENEMY + (Constants.WIDTH_ENEMY + Constants.GAP_COLUMNS_ALIEN) * i,
                    Constants.INIT_ALIEN, "/Resources/alien1.png", "/Resources/alien2.png");
            for(int j=1; j<3; j++) {
                this.arrAlien[j][i] = new Alien(Constants.X_POS_INIT_ENEMY + (Constants.WIDTH_ENEMY + Constants.GAP_COLUMNS_ALIEN) *
                        i, Constants.INIT_ALIEN + Constants.GAP_LINES_ALIEN * j, "/Resources/alien2.png", "/Resources/enemy2.png");
            }
            for(int j=3; j<5; j++) {
                this.arrAlien[j][i] = new Alien(Constants.X_POS_INIT_ENEMY + (Constants.WIDTH_ENEMY + Constants.GAP_COLUMNS_ALIEN)
                        * i, Constants.INIT_ALIEN + Constants.GAP_LINES_ALIEN * j, "/Resources/alien3.png", "/Resources/greenbat.png");
            }
        }
    }

    public void designAlien(Graphics g){
        if(Time.countSteps % (100 - 10 * this.speed) == 0) {this.displacementAliens();}
// Draw the aliens contained in the arrAlien array
        for(int i = 0; i <10; i++){
            for (int j =0; j<5;j++){
                g.drawImage(this.arrAlien[j][i].getImg(),this.arrAlien[j][i].getxPos(),this.arrAlien[j][i].getyPos(),null);
            }
        }
    }

    private boolean LeftEdgeKey() {
        // Method that detects the left edge of the window
        boolean response = false;
        for(int i=0; i<10; i++) {
            for(int j=0; j<5; j++) {
                if(this.arrAlien[j][i].getxPos() < Constants.Window_margin){
                    response = true;
                    break;
                }
            }
        }
        return response;
    }

    private boolean rightEdgeKey() {
        // Method that detects the right edge of the window
        boolean response = false;
        for(int i=0; i<10; i++) {
            for(int j=0; j<5; j++) {
                if(this.arrAlien[j][i].getxPos() >
                        Constants.Window_width - Constants.HEIGHT_ENEMY - Constants.DX_ENEMY - Constants.Window_margin) {
                    response = true;
                    break;
                }
            }
        }
        return response;
    }

    public void alienRotatesAndDescends() {
        // Method that changes the direction of movement of the alien and lowers it by one notch
        if(this.rightEdgeKey() == true) {
            for(int i=0; i<10; i++) {
                for(int j=0; j<5; j++) {
                    this.arrAlien[j][i].setyPos(this.arrAlien[j][i].getyPos() + Constants.DY_ENEMY);
                }
            }
            this.goARight = false;
            if(this.speed < 5) {this.speed++;}
        } else {
            if(this.LeftEdgeKey() == true) {
                for(int i=0; i<10; i++) {
                    for(int j=0; j<5; j++) {this.arrAlien[j][i].setyPos(
                            this.arrAlien[j][i].getyPos() + Constants.DY_ENEMY);
                    }
                }
                this.goARight = true;
                if(this.speed < 9) {this.speed++;}
            }
        }
    }

    public void displacementAliens() {
        // Method that manages the movement of aliens
        if(this.goARight == true) { // Move to the right
            for(int i=0; i<10; i++) {
                for(int j=0; j<5; j++) {
                    this.arrAlien[j][i].setxPos(this.arrAlien[j][i].getxPos() + Constants.DX_ENEMY);
                }
            }
        }else{ // Move left
            for(int i=0; i<10; i++) {
                for(int j=0; j<5; j++) {
                    this.arrAlien[j][i].setxPos(this.arrAlien[j][i].getxPos() - Constants.DX_ENEMY);
                }
            }
        }

        // Change the alien's image
        if(this.pos1 == true) {this.pos1 = false;}
        else {this.pos1 = true;}
        // Update the direction of movement if an alien reaches the edge of the window
        this.alienRotatesAndDescends();
    }

}
