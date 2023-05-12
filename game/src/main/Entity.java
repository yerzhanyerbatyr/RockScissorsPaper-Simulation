package main;

import java.awt.*;
import java.util.ArrayList;

public abstract class Entity {
    private int x, y;
    private int speedX, speedY;
    private Image image;
    private String name;
    private GamePanel gp;

    public Entity(GamePanel drawArea, String imageFile) {
        Image image = Toolkit.getDefaultToolkit().getImage(imageFile);
        this.setImage(image);
        setDrawArea(drawArea);
    }
    public abstract void initialize();
    public abstract void draw(Graphics g);
    public abstract void moveOneStep();
    public abstract void handleCollisions(ArrayList<Entity> items);
    public int getWindowWidth() {
        return this.getDrawArea().getWidth();
    }

    public int getWindowHeight() {
        return this.getDrawArea().getHeight();
    }

    private GamePanel getDrawArea() {
        return gp;
    }

    private void setDrawArea(GamePanel drawArea) {
        this.gp = drawArea;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
    public int getSpeedY() {
        return speedY;
    }
    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return this.image;
    }

}
