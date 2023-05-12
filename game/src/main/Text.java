package main;
import java.awt.*;

public class Text {
    public String text;
    public Font font;
    public double x,y;

    public Text (String text, Font font, double x, double y){
        this.font = font;
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public void draw (Graphics g2){
        g2.setColor(Color.BLACK);
        g2.setFont(font);
        g2.drawString(text, (int) x, (int) y);
    }
}
