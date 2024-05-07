import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Quiz implements ActionListener{

    // Properties
    JPanel thePanel = new JPanel();
    JLabel[] theQuestion = new JLabel[15];
    JRadioButton[] theAnswers = new JRadioButton[15];
    int intQuestionNumber = 0;

    Font fntDialog15 = new Font("Dialog", 1, 15);

    JScrollPane theScroll = new JScrollPane(thePanel);

    // Methods
    @Override
    public void actionPerformed(ActionEvent evt){

    }
    
    //Completes all the functionality to set up a question
    public final void setQuestion(String strQuestion, int intQuestionY){
        //Sets up the question
        theQuestion[intQuestionNumber] = new JLabel(strQuestion);
        theQuestion[intQuestionNumber].setFont(fntDialog15);
        theQuestion[intQuestionNumber].setBounds(40, intQuestionY, 940, 30);
        theQuestion[intQuestionNumber].setForeground(Color.white);
        thePanel.add(theQuestion[intQuestionNumber]);

        //Sets up the button
        theAnswers[intQuestionNumber] = new JRadioButton();
        theAnswers[intQuestionNumber].setBounds(10, intQuestionY-2, 35, 35);
        theAnswers[intQuestionNumber].setForeground(Color.white);
        theAnswers[intQuestionNumber].setOpaque(false);
        thePanel.add(theAnswers[intQuestionNumber]);

        //Adds the action listener
        theAnswers[intQuestionNumber].addActionListener(this);

        //Increments the question number
        intQuestionNumber++;
    }

    //Constructor
    public Quiz(){
        //Sets up the panel
        thePanel.setLayout(null);
        thePanel.setPreferredSize(new Dimension(960, 810));
        theScroll.setPreferredSize(new Dimension(960, 540));
        thePanel.setBackground(Color.black);

        //Sets up the questions
        setQuestion("Impulse increases if the change in velocity of a system due to an outside force increases", 10); //True
        setQuestion("Colliding objects will always conserve energy in elastic collisions only", 40); // False
        setQuestion("Momentum doesn't transfer to other forms", 70);//True
        setQuestion("LOCP and LOCE both verify that an object will maintain its state of motion unless otherwise acted upon by an external force", 100); // True
        setQuestion("An object colliding with a stationary structure such as the wall of a building will be equivalent to a lightweight object colliding with a heavier object", 130); // True
        setQuestion("As the momentum of an object increases the more time it takes to decrease momentum if the same amount of force is applied to do so", 160); // True
        setQuestion("Momentum in a system is mathematically conserved in the velocity of the objects. Therefore, calculations summing velocity vectors is equivalent to calculations summing momentum vectors", 190); // False
        setQuestion("Colliding objects result in energy transfers that still obey LOCE in inelastic and elastic collisions", 220); // True
        setQuestion("NL1 but not LOCE (due to inelastic colllisions) both describe the same outcomes in the analysis of systems as the LOCP", 250); // True
        setQuestion("Momentum and mass are directly proportional to each other, as are mass and velocity in the context of momentum", 280); // False
        setQuestion("According to the LOCP, momentum of a system can never change in closed or open systems", 310); // False
        setQuestion("Elastic collisions conserve kinetic energy but not other forms of energy", 340); // True
        setQuestion("In a collision, if one object is at rest, the object at rest post collision will always move in the same direction as pre collison velocity of the object that collides into the object at rest", 370); // True
        setQuestion("Both LOCE and LOCP confirm NL1", 400); // True
        setQuestion("Force and impulse are inversely proportional to each other", 430); // False
    }
    
}
