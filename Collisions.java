import java.awt.event.*;
import javax.swing.*;

public class Collisions implements ActionListener{
    //------------------PROPERTIES------------------

    //Panels and Frames
    JFrame theFrame = new JFrame("Collisions");
    Elastic theElasticSimulationPanel = new Elastic();
    Inelastic theInelasticSimulationPanel = new Inelastic();
    Quiz theQuizPanel = new Quiz();
    LeaderboardScreen theLeaderboardPanel = new LeaderboardScreen();

    //Menu Items
    JMenuBar theMenuBar = new JMenuBar();
    JMenu theFileMenu = new JMenu("File");    
    JMenuItem theElasticSimulation = new JMenuItem("Elastic Simulation");
    JMenuItem theInelasticSimulation = new JMenuItem("Inelastic Simulation");
    JMenuItem theQuiz = new JMenuItem("Quiz");
    JMenuItem theLeaderboard = new JMenuItem("Leaderboard");

    //------------------METHODS------------------
    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == theElasticSimulation){
            theFrame.setContentPane(theElasticSimulationPanel.thePanel);
        }else if(evt.getSource() == theInelasticSimulation){
            theFrame.setContentPane(theInelasticSimulationPanel.thePanel);
        }else if(evt.getSource() == theQuiz){
            System.out.println("Quiz");
            theFrame.setContentPane(theQuizPanel.thePanel);
        }else if(evt.getSource() == theLeaderboard){
            theFrame.setContentPane(theLeaderboardPanel.thePanel);
        }
        theFrame.pack();
    }

    //------------------CONSTRUCTOR------------------
    public Collisions() {
        //Sets up the frame
        theFrame.setTitle("Collisions");
        theFrame.setContentPane(theElasticSimulationPanel.thePanel);

        // Gets the Menu ready
        theFileMenu.add(theElasticSimulation);
        theFileMenu.add(theInelasticSimulation);
        theMenuBar.add(theFileMenu);
        theMenuBar.add(theQuiz);
        theMenuBar.add(theLeaderboard);
        theFrame.setJMenuBar(theMenuBar);

        //Adds action listeners
        theElasticSimulation.addActionListener(this);
        theInelasticSimulation.addActionListener(this);
        theQuiz.addActionListener(this);
        theLeaderboard.addActionListener(this);

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