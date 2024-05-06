import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class Quiz implements ActionListener{

    // Properties
    JPanel thePanel = new JPanel();
    JLabel[] theQuestion = new JLabel[15];
    JRadioButton[] theAnswers = new JRadioButton[15];
    int intQuestionNumber = 0;

    JScrollPane theScroll = new JScrollPane(thePanel);

    // Methods
    @Override
    public void actionPerformed(ActionEvent evt){

    }
    
    //Completes all the functionality to set up a question
    public void setQuestion(String strQuestion, int intQuestionY){
        //Sets up the question
        theQuestion[intQuestionNumber] = new JLabel(strQuestion);
        theQuestion[intQuestionNumber].setBounds(10, intQuestionY, 940, 30);
        theQuestion[intQuestionNumber].setForeground(Color.white);
        thePanel.add(theQuestion[intQuestionNumber]);

        //Sets up the button
        theAnswers[intQuestionNumber] = new JRadioButton();
        theAnswers[intQuestionNumber].setBounds(10, intQuestionY, 20, 20);
        theAnswers[intQuestionNumber].setForeground(Color.white);
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
        setQuestion("What is the capital of France?", 10);
        setQuestion("What is the capital of Germany?", 40);
        setQuestion("What is the capital of Italy?", 70);
        setQuestion("What is the capital of Spain?", 100);
        setQuestion("What is the capital of Portugal?", 130);
        setQuestion("What is the capital of Belgium?", 160);
        setQuestion("What is the capital of the Netherlands?", 190);
        setQuestion("What is the capital of Luxembourg?", 220);
        setQuestion("What is the capital of Switzerland?", 250);
        setQuestion("What is the capital of Austria?", 280);
        setQuestion("What is the capital of Poland?", 310);
        setQuestion("What is the capital of the Czech Republic?", 340);
        setQuestion("What is the capital of Slovakia?", 370);
        setQuestion("What is the capital of Hungary?", 400);
        setQuestion("What is the capital of Romania?", 430);
    }
    
}
