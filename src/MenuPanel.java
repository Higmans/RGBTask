import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    public static SlidersCenter sliderR = new SlidersCenter("R");
    public static SlidersCenter sliderG = new SlidersCenter("G");
    public static SlidersCenter sliderB = new SlidersCenter("B");
    public static SlidersCenter sliderA = new SlidersCenter("A");

    public MenuPanel(){
        setVisible(true);
        setLayout(new GridLayout(4, 3));
        setBackground(Color.BLACK);

        add(new ButtonsLeft("R"));
        add(sliderR);
        add(new ButtonsRight("R"));
        add(new ButtonsLeft("G"));
        add(sliderG);
        add(new ButtonsRight("G"));
        add(new ButtonsLeft("B"));
        add(sliderB);
        add(new ButtonsRight("B"));
        add(new Picker());
        add(sliderA);
        add(new JPanel());
    }
}

class ButtonsLeft extends JPanel{
    public ButtonsLeft(String color){
        Button jbMinus = new Button("-" + color);
        jbMinus.addActionListener(new Buttons());
        add(jbMinus);
        setVisible(true);
    }
}
class SlidersCenter extends JPanel{
    Sliders js = new Sliders();
    public SlidersCenter(String color){
        js.setName(color);
        js.setValues(color);
        js.addChangeListener(js);
        add(js);
        setVisible(true);
    }
}
class ButtonsRight extends JPanel{
    public ButtonsRight(String color){
        Button jbPlus = new Button("+" + color);
        jbPlus.addActionListener(new Buttons());
        add(jbPlus);
        setVisible(true);
    }
}
class Picker extends JPanel{
    static ComboBox cb = new ComboBox();
    public Picker(){
        add(cb);
        setVisible(true);
    }
}