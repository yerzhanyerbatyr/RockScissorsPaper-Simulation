package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KL implements KeyListener {
    public boolean blankPressed, cPressed, vPressed, bPressed;

    @Override
    public void keyTyped(KeyEvent e) {    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.getExtendedKeyCodeForChar(32)){
            blankPressed = true;
        }
        if (code == KeyEvent.getExtendedKeyCodeForChar(67)){
            cPressed = true;
        }
        if (code == KeyEvent.getExtendedKeyCodeForChar(86)){
            vPressed = true;
        }
        if (code == KeyEvent.getExtendedKeyCodeForChar(66)){
            bPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.getExtendedKeyCodeForChar(32)){
            blankPressed = false;
        }
        if (code == KeyEvent.getExtendedKeyCodeForChar(67)){
            cPressed = false;
        }
        if (code == KeyEvent.getExtendedKeyCodeForChar(86)){
            vPressed = false;
        }
        if (code == KeyEvent.getExtendedKeyCodeForChar(66)){
            bPressed = false;
        }
    }

    public boolean isKeyPressed (int code){
        if (code == KeyEvent.getExtendedKeyCodeForChar(32)){
            return blankPressed;
        }
        if (code == KeyEvent.getExtendedKeyCodeForChar(67)){
            return cPressed;
        }
        if (code == KeyEvent.getExtendedKeyCodeForChar(86)){
            return vPressed;
        }
        if (code == KeyEvent.getExtendedKeyCodeForChar(66)){
            return bPressed;
        }
        return false;
    }

    // 32 - blank, 67 - C, 86 - V, 66 - B
}
