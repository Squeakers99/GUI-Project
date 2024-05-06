import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class Quiz implements ActionListener{

    // Properties
    JPanel thePanel = new JPanel();
    JRadioButton theAnswer1 = new JRadioButton(); 
    JRadioButton theAnswer2 = new JRadioButton(); 
    JRadioButton theAnswer3 = new JRadioButton(); 
    JRadioButton theAnswer4 = new JRadioButton(); 
    JRadioButton theAnswer5 = new JRadioButton(); 
    JRadioButton theAnswer6 = new JRadioButton(); 
    JRadioButton theAnswer7 = new JRadioButton(); 
    JRadioButton theAnswer8 = new JRadioButton(); 
    JRadioButton theAnswer9 = new JRadioButton(); 
    JRadioButton theAnswer10 = new JRadioButton(); 
    JRadioButton theAnswer11 = new JRadioButton(); 
    JRadioButton theAnswer12 = new JRadioButton(); 
    JRadioButton theAnswer13 = new JRadioButton(); 
    JRadioButton theAnswer14 = new JRadioButton(); 
    JRadioButton theAnswer15 = new JRadioButton(); 
    JScrollPane theScroll = new JScrollPane(thePanel);


    // Methods
    public void actionPerformed(ActionEvent evt){

    }
    //Constructor
    public Quiz(){
        //Sets up the panel
        thePanel.setLayout(null);
        thePanel.setPreferredSize(new Dimension(960, 540));
        thePanel.setBackground(Color.black);
        theAnswer1.setBounds(100, 70, 40, 40);
        theAnswer2.setBounds(100, 140, 40, 40);
        theAnswer3.setBounds(100, 210, 40, 40);
        theAnswer4.setBounds(100, 280, 40, 40);
        theAnswer5.setBounds(100, 350, 40, 40);
        theAnswer6.setBounds(100, 420, 40, 40);
        theAnswer7.setBounds(100, 490, 40, 40);
        theAnswer8.setBounds(100, 560, 40, 40);
        theAnswer9.setBounds(100, 630, 40, 40);
        theAnswer10.setBounds(100, 700, 40, 40);
        theAnswer11.setBounds(100, 770, 40, 40);
        theAnswer12.setBounds(100, 840, 40, 40);
        theAnswer13.setBounds(100, 910, 40, 40);
        theAnswer14.setBounds(100, 980, 40, 40);
        theAnswer15.setBounds(100, 1050, 40, 40);
        
    }
    
}
