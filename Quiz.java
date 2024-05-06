import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class Quiz implements ActionListener{

    // Properties
    JPanel thePanel = new JPanel();
    JLabel theAnswer1 = new JLabel("Answer 1");
    JLabel theAnswer2 = new JLabel("Answer 2");
    JLabel theAnswer3 = new JLabel("Answer 3");
    JLabel theAnswer4 = new JLabel("Answer 4");
    JLabel theAnswer5 = new JLabel("Answer 5");
    JLabel theAnswer6 = new JLabel("Answer 6");
    JLabel theAnswer7 = new JLabel("Answer 7");
    JLabel theAnswer8 = new JLabel("Answer 8");
    JLabel theAnswer9 = new JLabel("Answer 9");
    JLabel theAnswer10 = new JLabel("Answer 10");
    JLabel theAnswer11 = new JLabel("Answer 11");
    JLabel theAnswer12 = new JLabel("Answer 12");
    JLabel theAnswer13 = new JLabel("Answer 13");
    JLabel theAnswer14 = new JLabel("Answer 14");
    JLabel theAnswer15 = new JLabel("Answer 15");

    JScrollPane theScroll = new JScrollPane(thePanel);

    // Methods
    public void actionPerformed(ActionEvent evt){

    }
    //Constructor
    public Quiz(){
        //Sets up the panel
        thePanel.setLayout(null);
        thePanel.setPreferredSize(new Dimension(960, 810));
        theScroll.setPreferredSize(new Dimension(960, 540));
        thePanel.setBackground(Color.black);

        thePanel.add(theAnswer1);
        theAnswer1.setBounds(10, 10, 200, 30);

        thePanel.add(theAnswer2);
        theAnswer2.setBounds(10, 60, 200, 30);

        thePanel.add(theAnswer3);
        theAnswer3.setBounds(10, 110, 200, 30);

        thePanel.add(theAnswer4);
        theAnswer4.setBounds(10, 160, 200, 30);

        thePanel.add(theAnswer5);
        theAnswer5.setBounds(10, 210, 200, 30);

        thePanel.add(theAnswer6);
        theAnswer6.setBounds(10, 260, 200, 30);

        thePanel.add(theAnswer7);
        theAnswer7.setBounds(10, 310, 200, 30);

        thePanel.add(theAnswer8);
        theAnswer8.setBounds(10, 360, 200, 30);

        thePanel.add(theAnswer9);
        theAnswer9.setBounds(10, 410, 200, 30);

        thePanel.add(theAnswer10);
        theAnswer10.setBounds(10, 460, 200, 30);

        thePanel.add(theAnswer11);
        theAnswer11.setBounds(10, 510, 200, 30);

        thePanel.add(theAnswer12);
        theAnswer12.setBounds(10, 560, 200, 30);

        thePanel.add(theAnswer13);
        theAnswer13.setBounds(10, 610, 200, 30);

        thePanel.add(theAnswer14);
        theAnswer14.setBounds(10, 660, 200, 30);

        thePanel.add(theAnswer15);
        theAnswer15.setBounds(10, 710, 200, 30);
    }
    
}
