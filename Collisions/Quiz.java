package Collisions;
/*
 * Soheil Rajabali and Jayred Robles
 * Momentum and Collisions Simulator
 * V1.0
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class created to manage the quiz screen
 * 
 * @author Soheil Rajabali, Jayred Robles
 * @version 1.0
 * @since 2024-05-09
 */

public class Quiz extends JPanel implements ActionListener{
    //------------------Properties------------------

    //Labels
    JLabel[] theQuestion = new JLabel[15];
    JLabel theTitle = new JLabel("KNOWLEDGE: Select all those statements that are FALSE. COLOUR IN THE BOXES to indicate your selection");
    JLabel theQuizTitle = new JLabel("SPH 4U1 QUIZ 7: MOMENTUM AND COLLISIONS IN 1D AND 2D");
    JLabel theNameLabel = new JLabel("Name:");

    //Text Field
    JTextField theName = new JTextField("(Replace with your name)");

    //Buttons
    JButton theSubmit = new JButton("Submit");
    JRadioButton[] theAnswers = new JRadioButton[15];

    //Integer Variables
    int intQuestionNumber = 0;
    int intScore = 0;

    //Leaderboard
    LeaderboardClass theLeaderboard;

    //Fonts
    Font fntDialog10 = new Font("Dialog", 1, 10);
    Font fntSans17 = new Font("Sans", 1, 17);
    Font fntDialog13 = new Font("Dialog", 1, 13);

    //------------------METHODS------------------

    //Mandatory override to read component states
    /**
     * Mandatory override to read component states
     * @param evt 
     */
    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == theSubmit){
            calculateScore();
            theLeaderboard = new LeaderboardClass("leaderboard.txt", true);
            try {
                theLeaderboard.entry(theName.getText(), intScore);
            } catch (NullPointerException e) {
                theLeaderboard.entry("N/A", intScore);
            }
            theLeaderboard.close("write"); 
            JOptionPane.showMessageDialog(null, "You scored: " + intScore + "/15", "Score", JOptionPane.INFORMATION_MESSAGE);
            intScore = 0;
        }
    }

    //Calculates the score that the user got
    /**
     * Calculates the score that the user got
    */
    public void calculateScore(){
        if(theAnswers[0].isSelected() == false){
            intScore++;
        }
        if(theAnswers[1].isSelected() == true){
            intScore++;
        }
        if(theAnswers[2].isSelected() == false){
            intScore++;
        }
        if(theAnswers[3].isSelected() == false){
            intScore++;
        }
        if(theAnswers[4].isSelected() == false){
            intScore++;
        }
        if(theAnswers[5].isSelected() == false){
            intScore++;
        }
        if(theAnswers[6].isSelected() == true){
            intScore++;
        }
        if(theAnswers[7].isSelected() == false){
            intScore++;
        }
        if(theAnswers[8].isSelected() == false){
            intScore++;
        }
        if(theAnswers[9].isSelected() == true){
            intScore++;
        }
        if(theAnswers[10].isSelected() == true){
            intScore++;
        }
        if(theAnswers[11].isSelected() == true){
            intScore++;
        }
        if(theAnswers[12].isSelected() == false){
            intScore++;
        }
        if(theAnswers[13].isSelected() == false){
            intScore++;
        }
        if(theAnswers[14].isSelected() == true){
            intScore++;
        }
    }

    //Completes all the functionality to set up a question
    /**
     * Completes all the functionality to set up a question
     * @param strQuestion the question to be asked
     * @param intQuestionY the y position of the question
     */
    public void setQuestion(String strQuestion, int intQuestionY){
        //Sets up the button
        theAnswers[intQuestionNumber] = new JRadioButton();
        theAnswers[intQuestionNumber].setBounds(10, intQuestionY-2, 35, 35);
        theAnswers[intQuestionNumber].setForeground(Color.white);
        theAnswers[intQuestionNumber].setOpaque(false);
        add(theAnswers[intQuestionNumber]);
        
        //Sets up the question
        theQuestion[intQuestionNumber] = new JLabel(strQuestion);
        theQuestion[intQuestionNumber].setFont(fntDialog10);
        theQuestion[intQuestionNumber].setBounds(40, intQuestionY, 1450, 30);
        theQuestion[intQuestionNumber].setForeground(Color.white);
        add(theQuestion[intQuestionNumber]);

        //Adds the action listener
        theAnswers[intQuestionNumber].addActionListener(this);

        //Increments the question number
        intQuestionNumber++;
    }

    //------------------CONSTRUCTOR------------------
    /**
     * Constructor for the Quiz class
    */
    public Quiz(){
        //Sets up the panel
        setLayout(null);
        setPreferredSize(new Dimension(960, 540));
        setBackground(Color.black);

        //Sets up the quiz title
        theQuizTitle.setFont(fntSans17);
        theQuizTitle.setBounds(10, 5, 950, 30);
        theQuizTitle.setForeground(Color.white);
        add(theQuizTitle);

        //Sets up the name label
        theNameLabel.setFont(fntDialog10);
        theNameLabel.setBounds(715, 5, 50, 30);
        theNameLabel.setForeground(Color.white);
        add(theNameLabel);

        //Sets up the name text box
        theName.setBounds(750, 5, 200, 30);
        theName.setFont(fntDialog10);
        theName.setForeground(Color.white);
        theName.setOpaque(false);
        theName.setBorder(null);
        add(theName);

        //Sets up the title
        theTitle.setFont(fntSans17);
        theTitle.setBounds(20, 35, 950, 30);
        theTitle.setForeground(Color.white);
        add(theTitle);

        //Sets up the questions
        setQuestion("Impulse increases if the change in velocity of a system due to an outside force increases.", 65); //True
        setQuestion("Colliding objects will always conserve energy in elastic collisions only.", 95); // False
        setQuestion("Momentum doesn't transfer to other forms.", 125);//True
        setQuestion("LOCP and LOCE both verify that an object will maintain its state of motion unless otherwise acted upon by an external force.", 155); // True
        setQuestion("An object colliding with a stationary structure such as the wall of a building will be equivalent to a lightweight object colliding with a heavier object.", 185); // True
        setQuestion("As the momentum of an object increases the more time it takes to decrease momentum if the same amount of force is applied to do so.", 215); // True
        setQuestion("Momentum in a system is mathematically conserved in the velocity of the objects. Therefore, calculations summing velocity vectors is equivalent to calculations summing momentum vectors.", 245); // False
        setQuestion("Colliding objects result in energy transfers that still obey LOCE in inelastic and elastic collisions.", 275); // True
        setQuestion("NL1 but not LOCE (due to inelastic colllisions) both describe the same outcomes in the analysis of systems as the LOCP.", 305); // True
        setQuestion("Momentum and mass are directly proportional to each other, as are mass and velocity in the context of momentum.", 335); // False
        setQuestion("According to the LOCP, momentum of a system can never change in closed or open systems", 365); // False
        setQuestion("Elastic collisions conserve kinetic energy but not other forms of energy.", 395); // False
        setQuestion("In a collision, if one object is at rest, the object at rest post collision will always move in the same direction as pre collison velocity of the object that collides into the object at rest.", 425); // True
        setQuestion("Both LOCE and LOCP confirm NL1.", 455); // True
        setQuestion("Force and impulse are inversely proportional to each other.", 485); // False

        //Adds the submit button
        theSubmit.setBounds(443, 510, 75, 20);
        theSubmit.setFont(fntDialog13);
        theSubmit.setForeground(Color.white);
        theSubmit.setBackground(Color.black);
        theSubmit.setBorder(BorderFactory.createLineBorder(Color.white));
        add(theSubmit);

        //Adds the action listener for the submit button
        theSubmit.addActionListener(this);
    }
}