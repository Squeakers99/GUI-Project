import java.awt.event.*;
import javax.swing.*;

public class Collisions implements ActionListener{
    //Properties
    JFrame theFrame = new JFrame("Collisions");

    //Methods
    @Override
    public void actionPerformed(ActionEvent evt){}

    //Constructor
    public Collisions() {
        theFrame.setTitle("Collisions");

        theFrame.add(new Quiz().thePanel);
        theFrame.setJMenuBar(new MenuBar().theMenuBar);

        theFrame.setResizable(false);
        theFrame.pack();
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setVisible(true);
    }
    
    //Main Method
    public static void main(String[] args) {
        new Collisions();
    }
}