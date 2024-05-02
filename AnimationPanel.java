import java.awt.*;
import javax.swing.*;

public class AnimationPanel extends JPanel {
    //------------------PROPERTIES------------------

    //Variables for the balls
    int intM1X = 300;
    int intM1Size = 50;
    int intM2X = 600;
    int intM2Size = 50;
 
    //------------------METHODS------------------

    //Paint Component Override
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(240, 400, 720, 5);
        g.setColor(Color.white);
        g.fillOval(intM1X, 400-intM1Size, intM1Size, intM1Size);
        g.fillOval(intM2X, 400-intM2Size, intM2Size, intM2Size);
    }
 
    //------------------CONSTRUCTOR------------------
    public AnimationPanel() {
        super();
    }
 } 