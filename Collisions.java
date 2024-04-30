import javax.swing.*;
import java.awt.event.*;

public class Collisions implements ActionListener{
    //Properties
    JFrame theFrame = new JFrame("Collisions");

    //Methods
    public void actionPerformed(ActionEvent evt){}

    //Constructor
    public Collisions() {
        /*Leaderboard theLeaderboard = new Leaderboard("leaderboard.txt", true);
        theLeaderboard.leaderboardEntry("Cadawas", 4);
        theLeaderboard.leaderboardEntry("Soheil", 6);
        theLeaderboard.close("write");
        theLeaderboard = new Leaderboard("leaderboard.txt");
        String[][] strLeaderboard = new String[theLeaderboard.getLength()][2];
        strLeaderboard = theLeaderboard.getLeaderboard();
        System.out.println(strLeaderboard[0][0] + " " + strLeaderboard[0][1]);
        System.out.println(strLeaderboard[1][0] + " " + strLeaderboard[1][1]);*/

        theFrame.setTitle("Collisions");

        theFrame.add(new Elastic().theElasticPanel);
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