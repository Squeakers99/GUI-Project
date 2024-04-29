import javax.swing.JFrame;
import javax.swing.JPanel;

public class Collisions extends JFrame {
    
    private JPanel panel;
    
    public Collisions() {
        setTitle("Collisions");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        add(panel);
        
        // Add your GUI components and event listeners here
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Collisions();
    }
}