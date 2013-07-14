import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel{
    static int r = 100;
    static int g = 100;
    static int b = 100;
    static int a = 255;
    public Color panelColor = new Color(r, g, b, a);

    public ColorPanel(){
        setOpaque(true);
        setVisible(true);
        setBackground(panelColor);
    }
}
