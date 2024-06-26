/**
 * Soheil Rajabali and Jayred Robles
 * Momentum and Collisions Simulator
 * V1.0
 */

package Collisions;

import java.awt.event.*;
import javax.swing.*;

/**
 * <h1>Collisions Main</h1>
 * Class created to manage the main screen
 * 
 * @author Soheil Rajabali, Jayred Robles
 * @version 1.0
 * @since 2024-05-09
 */

public class Collisions implements ActionListener{
    //------------------PROPERTIES------------------

    //Panels and Frames
    JFrame theFrame = new JFrame("Collisions");
    Elastic theElasticSimulationPanel = new Elastic();
    Inelastic theInelasticSimulationPanel = new Inelastic();
    Quiz theQuizPanel = new Quiz();
    LeaderboardScreen theLeaderboardPanel;
    Help theHelpPanel = new Help();;
    About theAboutPanel = new About();

    //Menu Items
    JMenuBar theMenuBar = new JMenuBar();
    JMenu theFileMenu = new JMenu("File");
    JMenu theEvaluationsMenu = new JMenu("Evaluations");
    JMenu theMoreMenu = new JMenu("More");
    JMenuItem theElasticSimulation = new JMenuItem("Elastic Simulation");
    JMenuItem theInelasticSimulation = new JMenuItem("Inelastic Simulation");
    JMenuItem theQuiz = new JMenuItem("Quiz");
    JMenuItem theLeaderboard = new JMenuItem("Leaderboard");
    JMenuItem theHelp = new JMenuItem("Help");
    JMenuItem theAbout = new JMenuItem("About");

    //------------------METHODS------------------
    
    /**
     * Handles the action events for menu items.
     * @param evt The ActionEvent object.
    */
    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == theElasticSimulation){
            theFrame.setContentPane(theElasticSimulationPanel);
        }else if(evt.getSource() == theInelasticSimulation){
            theFrame.setContentPane(theInelasticSimulationPanel);
        }else if(evt.getSource() == theQuiz){
            theFrame.setContentPane(theQuizPanel);
        }else if(evt.getSource() == theLeaderboard){
            theLeaderboardPanel = new LeaderboardScreen();
            theFrame.setContentPane(theLeaderboardPanel);
        }else if(evt.getSource() == theHelp){
            theFrame.setContentPane(theHelpPanel);
        }else if(evt.getSource() == theAbout){
            theFrame.setContentPane(theAboutPanel);
        }
        theFrame.pack();
    }

    //------------------CONSTRUCTOR------------------
    
    /**
     * Constructs a Collisions object and sets up the frame and menu.
    */
    public Collisions() {
        //Sets up the frame
        theFrame.setTitle("Collisions");
        theFrame.setContentPane(theAboutPanel);

        // Gets the Menu ready
        theFileMenu.add(theElasticSimulation);
        theFileMenu.add(theInelasticSimulation);
        theEvaluationsMenu.add(theQuiz);
        theEvaluationsMenu.add(theLeaderboard);
        theMoreMenu.add(theHelp);
        theMoreMenu.add(theAbout);
        theMenuBar.add(theFileMenu);
        theMenuBar.add(theEvaluationsMenu);
        theMenuBar.add(theMoreMenu);
        theFrame.setJMenuBar(theMenuBar);

        //Adds action listeners
        theElasticSimulation.addActionListener(this);
        theInelasticSimulation.addActionListener(this);
        theQuiz.addActionListener(this);
        theLeaderboard.addActionListener(this);
        theHelp.addActionListener(this);
        theAbout.addActionListener(this);

        //Packs the frame
        theFrame.setResizable(false);
        theFrame.pack();
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setVisible(true);
    }
    
    //Main Method
    /**
     * The entry point of the program.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        new Collisions();
    }
}