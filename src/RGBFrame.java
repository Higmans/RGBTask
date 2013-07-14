import javax.swing.*;
import java.awt.*;

public class RGBFrame extends JFrame{
    public static ColorPanel cp = new ColorPanel();
    public RGBFrame(String title, int width, int height){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int xCenter = dim.width/2 - width/2;
        int yCenter = dim.height/2 - height/2;
        setTitle(title);
        setBounds(xCenter, yCenter, width, height);
        setResizable(false);
        setLayout(new GridLayout(2, 3));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        add(cp);
        add(new MenuPanel());
        setVisible(true);
    }
}
