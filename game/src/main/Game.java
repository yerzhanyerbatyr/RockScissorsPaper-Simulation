package main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Game extends JFrame{
    private GamePanel gamePanel;

    public static void main(String[] arguments) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Game panel = new Game();
                    panel.setVisible(true);
                    panel.addContents();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Game() {
        setTitle("Yerzhan Yerbatyr n! incubator 2023");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        gamePanel = new GamePanel();
        add(gamePanel);
        pack();
        setLocationRelativeTo(null);
        Animator animator = new Animator(this);
        Timer timer = new Timer(50, animator);
        timer.start();
    }

    public void addContents() {
        GamePanel gamePanel = this.getGamePanel();
        Random random = new Random();
        int numScissors = random.nextInt(2,4);
        int numPaper = random.nextInt(2,4);
        int numRock = random.nextInt(2,4);

        for (int i = 0; i < numScissors; i++){
            gamePanel.addGameEntity(new GameItem(gamePanel, "scissors.png"));
        }
        for (int i = 0; i < numPaper; i++){
            gamePanel.addGameEntity(new GameItem(gamePanel, "paper.png"));
        }
		for (int i = 0; i < numRock; i++){
			gamePanel.addGameEntity(new GameItem(gamePanel, "rock.png"));
		}

        gamePanel.initializeEverything();
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

}

