import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class Quiz implements ActionListener{

    // Properties
    JPanel thePanel = new JPanel();
    // Methods
    public void actionPerformed(ActionEvent evt){

    }
    //Constructor
    public Quiz(){
        //Sets up the panel
        thePanel.setLayout(null);
        thePanel.setPreferredSize(new Dimension(960, 540));
        thePanel.setBackground(Color.black);
    }
    
}
