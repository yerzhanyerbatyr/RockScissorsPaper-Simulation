package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    public ArrayList<Entity> entities = new ArrayList<>();
    public final int tileSize = 48;
    final int maxScreenCol = 8;
    final int maxScreenRow = 13;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    int FPS = 60;
    KL keyListener = new KL();
    Sound sound = new Sound();
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        // this.setBackground(new Color(240,248,255));
        this.setBackground(Color.yellow);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyListener);
        this.setFocusable(true);
        playMusic(0);
    }

    public void initializeEverything() {
        for (Entity item : this.getEntities()) {
            item.initialize();
        }
    }
    public void moveEverythingOneStep() {
        for (Entity item : this.getEntities()) {
            item.moveOneStep();
            item.handleCollisions(this.getEntities());
        }
    }
    public void addGameEntity(Entity item) {
        this.getEntities().add(item);
    }
    public ArrayList<Entity> getEntities() {
        return entities;
    }
    public void paint(Graphics g) {
        super.paint(g);
        Font font = new Font("Monospaced>", Font.PLAIN, 14);
        Font font2 = new Font("Monospaced>", Font.BOLD, 16);
        Font fontInst = new Font("Monospaced>", Font.BOLD, 11);
        Text text = new Text("Hello! Welcome to the simulation game", font, 35,20);
        Text text2 = new Text("\"Rock. Scissors. Paper.\"", font2, 80,55);
        Text text3 = new Text("developed by Yerzhan Yerbatyr.", font, 22,35);
        Text textInstructions = new Text("Key controls:", fontInst, 10,565);
        Text textInstructions2 = new Text("C - add a random number of scissors", fontInst, 10,580);
        Text textInstructions3 = new Text("V - add a random number of stones", fontInst, 10,593);
        Text textInstructions4 = new Text("B - add a random number of paper", fontInst, 10,606);
        Text textInstructions5 = new Text("Space - delete all objects", fontInst, 10,619);
        text.draw(g);
        text2.draw(g);
        text3.draw(g);
        textInstructions.draw(g);
        textInstructions2.draw(g);
        textInstructions3.draw(g);
        textInstructions4.draw(g);
        textInstructions5.draw(g);
        for (Entity item : this.getEntities()) {
            item.draw(g);
        }
    }
    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void playSound(int i){
        sound.setFile(i);
        sound.play();
    }
    public void addByUser(){
        if (keyListener.cPressed == true){
            GameItem newItem = new GameItem(this, "scissors.png");
            newItem.initialize();
            this.addGameEntity(newItem);
            this.playSound(1);
        }
        if (keyListener.vPressed == true){
            GameItem newItem = new GameItem(this, "rock.png");
            newItem.initialize();
            this.addGameEntity(newItem);
            this.playSound(3);
        }
        if (keyListener.bPressed == true){
            GameItem newItem = new GameItem(this, "paper.png");
            newItem.initialize();
            this.addGameEntity(newItem);
            this.playSound(2);
        }
        if (keyListener.blankPressed == true){
            this.clear();
            this.playSound(4);
        }
    }

    public void stopMusic(){
        sound.stop();
    }
    public void clear(){
        this.getEntities().clear();
    }
