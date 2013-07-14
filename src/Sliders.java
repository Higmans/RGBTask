import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Sliders extends JSlider implements ChangeListener {

    public Sliders(){
        setMinimum(0);
        setMaximum(255);
        setValues(getName());
        setPreferredSize(new Dimension(135, 20));
    }

    public void setValues(String name) {
        if ("R".equals(name)){
            setValue(ColorPanel.r);
        }
        else if ("G".equals(name)){
            setValue(ColorPanel.g);
        }
        else if ("B".equals(name)){
            setValue(ColorPanel.b);
        }
        else if ("A".equals(name)){
            setValue(ColorPanel.a);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if ("R".equals(getName())){
            ColorPanel.r = getValue();
            repaintColor();
        }
        else if ("G".equals(getName())){
            ColorPanel.g = getValue();
            repaintColor();
        }
        else if ("B".equals(getName())){
            ColorPanel.b = getValue();
            repaintColor();
        }
        else if ("A".equals(getName())){
            ColorPanel.a = getValue();
            repaintColor();
        }
    }

    private void repaintColor() {
        RGBFrame.cp.setBackground(new Color(ColorPanel.r, ColorPanel.g, ColorPanel.b));
    }
}
