package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animator implements ActionListener {
    private Game game;

    public Animator(Game g) {
        this.setGame(g);
    }

    public void actionPerformed(ActionEvent arg0) {

        Game game = this.getGame();
        GamePanel gPanel = game.getGamePanel();

        gPanel.addByUser();
        gPanel.moveEverythingOneStep();
        gPanel.repaint();
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game g) {
        this.game = g;
    }
}
