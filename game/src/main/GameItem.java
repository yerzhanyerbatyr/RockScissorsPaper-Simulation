package main;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameItem extends Entity{
    KL keyListener;
    Random random;

    public GameItem(GamePanel gp, String imageFile){
        super(gp, imageFile);
        if (imageFile == "paper.png"){
            this.setName("paper");
        }
        if (imageFile == "scissors.png"){
            this.setName("scissors");
        }
        if (imageFile == "rock.png"){
            this.setName("rock");
        }
    }
    public void initialize() {
        int xPos, yPos;
        Random rand = new Random();
        yPos = rand.nextInt(this.getWindowHeight() - 48);
        xPos = rand.nextInt(this.getWindowWidth()-48);
        this.setX(xPos);
        this.setY(yPos);
        this.setSpeedX(3);
        this.setSpeedY(4);
    }
    public void newInitialize() {
        Random rand = new Random();
        if (this.getName() == "scissors"){
            this.setX(0);
            this.setY(0);
        }
        if (this.getName() == "rock"){
            this.setX(this.getWindowWidth()-48);
            this.setY(0);
        }
        if (this.getName() == "paper"){
            this.setX(this.getWindowWidth()-48);
            this.setY(this.getWindowHeight()-48);
        }
        this.setSpeedX(rand.nextInt(2,6));
        this.setSpeedY(rand.nextInt(3,7));
    }
    public void moveOneStep() {
        int nextX = this.getX()+this.getSpeedX();
        int nextY = this.getY()+this.getSpeedY();


        if (nextX < 0 || nextX >= this.getWindowWidth() - 48){
            this.setSpeedX(-this.getSpeedX());
        }
        if (nextY < 0 || nextY >= this.getWindowHeight() - 48){
            this.setSpeedY(-this.getSpeedY());
        }

        this.setX(nextX);
        this.setY(nextY);
    }

    public void handleCollisions(ArrayList<Entity> items) {
        for (Entity otherItem : items){
            if (otherItem != this && collidesWith(otherItem)){
                this.setSpeedX(-this.getSpeedX());
                this.setSpeedY(-this.getSpeedY());
                if (this.getName() == "scissors" && otherItem.getName() == "paper"){
                    otherItem.setImage(Toolkit.getDefaultToolkit().getImage("scissors.png"));
                    otherItem.setName("scissors");
                }
                if (this.getName() == "scissors" && otherItem.getName() == "rock"){
                    this.setImage(Toolkit.getDefaultToolkit().getImage("rock.png"));
                    this.setName("rock");
                }
                if (this.getName() == "paper" && otherItem.getName() == "rock"){
                    otherItem.setImage(Toolkit.getDefaultToolkit().getImage("paper.png"));
                    otherItem.setName("paper");
                }
            }
        }
    }
    public boolean collidesWith(Entity otherItem){
        int size = 45;

        int left1 = this.getX();
        int right1 = this.getX() + size;
        int top1 = this.getY();
        int bottom1 = this.getY() + size;

        int left2 = otherItem.getX();
        int right2 = otherItem.getX()+size;
        int top2 = otherItem.getY();
        int bottom2 = otherItem.getY() + size;

        boolean xOverlap = (left1 < right2) && (right1 > left2);
        boolean yOverlap = (top1 < bottom2) && (bottom1 > top2);
        return xOverlap && yOverlap;
    }


    public void draw(Graphics g2){
        Image scissorsImg = this.getImage();
        g2.drawImage(scissorsImg, this.getX(), this.getY(), 48, 48, null);

    }

}
