import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends JButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("+R".equals(e.getActionCommand())){
            ColorPanel.r += getValue();
            if (ColorPanel.r > 255){
                ColorPanel.r = 255;
            }
            MenuPanel.sliderR.js.setValue(ColorPanel.r);
            repaintColor();
        }
        else if ("-R".equals(e.getActionCommand())){
            ColorPanel.r -= getValue();
            if (ColorPanel.r < 0){
                ColorPanel.r = 0;
            }
            MenuPanel.sliderR.js.setValue(ColorPanel.r);
            repaintColor();
        }
        else if ("+G".equals(e.getActionCommand())){
            ColorPanel.g += getValue();
            if (ColorPanel.g > 255){
                ColorPanel.g = 255;
            }
            MenuPanel.sliderG.js.setValue(ColorPanel.g);
            repaintColor();
        }
        else if ("-G".equals(e.getActionCommand())){
            ColorPanel.g -= getValue();
            if (ColorPanel.g < 0){
                ColorPanel.g = 0;
            }
            MenuPanel.sliderG.js.setValue(ColorPanel.g);
            repaintColor();
        }
        else if ("+B".equals(e.getActionCommand())){
            ColorPanel.b += getValue();
            if (ColorPanel.b > 255){
                ColorPanel.b = 255;
            }
            MenuPanel.sliderB.js.setValue(ColorPanel.b);
            repaintColor();
        }
        else if ("-B".equals(e.getActionCommand())){
            ColorPanel.b -= getValue();
            if (ColorPanel.b < 0){
                ColorPanel.b = 0;
            }
            MenuPanel.sliderB.js.setValue(ColorPanel.b);
            repaintColor();
        }
    }

    private int getValue() {
        return (Integer) Picker.cb.getSelectedItem();
    }

    private void repaintColor() {
        RGBFrame.cp.setBackground(new Color(ColorPanel.r, ColorPanel.g, ColorPanel.b));
    }
}
