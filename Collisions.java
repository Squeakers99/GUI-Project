import java.awt.event.*;
import javax.swing.*;

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
    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == theElasticSimulation){
            theFrame.setContentPane(theElasticSimulationPanel.thePanel);
        }else if(evt.getSource() == theInelasticSimulation){
            theFrame.setContentPane(theInelasticSimulationPanel.thePanel);
        }else if(evt.getSource() == theQuiz){
            theFrame.setContentPane(theQuizPanel.thePanel);
        }else if(evt.getSource() == theLeaderboard){
            theLeaderboardPanel = new LeaderboardScreen();
            theFrame.setContentPane(theLeaderboardPanel.thePanel);
        }else if(evt.getSource() == theHelp){
            theFrame.setContentPane(theHelpPanel);
        }else if(evt.getSource() == theAbout){
            theFrame.setContentPane(theAboutPanel);
        }
        theFrame.pack();
    }

    //------------------CONSTRUCTOR------------------
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
    public static void main(String[] args) {
        new Collisions();
    }
}