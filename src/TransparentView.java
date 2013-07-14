import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TransparentView extends JFrame implements ComponentListener, WindowFocusListener, WindowListener {
    TransparentPanel bg;
    Toolkit kit = Toolkit.getDefaultToolkit();
    JLabel labelX;
    JLabel labelY;

    TransparentView() {
        super("Transparent Frame");
        setSize(400, 300);
        setLayout(new BorderLayout(0,150));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bg = new TransparentPanel();
        MouseHandler mh = new MouseHandler();
        labelX = new JLabel("X: ");
        labelY = new JLabel("Y: ");
        addMouseListener(mh);
        addMouseListener(mh);

        //add(colorPanel, BorderLayout.CENTER);
        add(bg, BorderLayout.CENTER);
        //add(menuPanel, BorderLayout.SOUTH);

        setSize(300, 300);

        setVisible(true);
        setLocation(kit.getScreenSize().width / 2 - (getWidth() / 2), kit.getScreenSize().height / 2 - (getHeight() / 2));
        addComponentListener(this);
        addWindowFocusListener(this);

    }
    private void refresh() {
        setVisible(false);
        try {
            Thread.sleep(315);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bg.updateBackground();
        requestFocus();
        updatePanel();
    }
    private void updatePanel() {
        setVisible(true);
        requestFocus();
        bg.repaint();
    }

    public void componentResized(ComponentEvent e) {
        updatePanel();
    }
    public void componentMoved(ComponentEvent e) {
        updatePanel();
    }
    public void componentShown(ComponentEvent e) {}
    public void componentHidden(ComponentEvent e) {}
    public void windowGainedFocus(WindowEvent e) {
        updatePanel();
    }
    public void windowLostFocus(WindowEvent e) {
        refresh();
    }
    public void windowOpened(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {
        updatePanel();
    }
    public void windowDeiconified(WindowEvent e) {
        refresh();
    }
    public void windowActivated(WindowEvent e) {
        updatePanel();
    }
    public void windowDeactivated(WindowEvent e) {}

    class TransparentPanel extends JPanel {

        private Image background;
        Robot rbt;

        TransparentPanel() {

            try {
                rbt = new Robot();
            } catch (AWTException ex) {
                ex.getStackTrace();
            }
            updateBackground();
            repaint();
        }

        public void updateBackground() {
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            background = rbt.createScreenCapture(new Rectangle(0, 0, dim.width, dim.height));
        }

        @Override
        public void paintComponent(Graphics g) {
            Point pos = this.getLocationOnScreen();
            Point offset = new Point(-pos.x, -pos.y);
            g.drawImage(background, offset.x, offset.y, null);
        }
    }
    class MouseHandler implements MouseListener {

        public void mouseClicked(MouseEvent e) {
            labelX.setText("X: " + e.getXOnScreen());
            labelY.setText("Y: " + e.getYOnScreen());
        }

        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}

    }
}

