import java.awt.*;
import javax.swing.*;

public class LeaderboardScreen {
   //------------------PROPERTIES------------------ 

    JPanel thePanel = new JPanel();

    //Labels
    JLabel theNameHeading = new JLabel("Name");
    JLabel theScoreHeading = new JLabel("Score");
    JLabel[] theNames;
    JLabel[] theScores;

    //Fonts
    Font fntDialog13 = new Font("Dialog", 1, 13);
    Font fntDialog20 = new Font("Dialog", 1, 20);

    //Leaderboard
    LeaderboardClass theLeaderboard;

    //Integers
    int intEntryY = 30;
    int intLoopCount;

    //Strings
    String strLeaderboard[][];

    //------------------CONSTRUCTOR------------------
    public LeaderboardScreen(){
        //Sets up the panel
        thePanel.setLayout(null);
        thePanel.setPreferredSize(new Dimension(960, 540));
        thePanel.setBackground(Color.black);

        //Loads the leaderboard into an array
        theLeaderboard = new LeaderboardClass("leaderboard.txt");
        strLeaderboard = new String[theLeaderboard.getLength()][2];
        strLeaderboard = theLeaderboard.getLeaderboard();
        theNames = new JLabel[theLeaderboard.getLength()];
        theScores = new JLabel[theLeaderboard.getLength()];
        theLeaderboard.close("read");

        System.out.println("done");

        //Prints the headings
        theNameHeading.setBounds(20, 0, 300, 50);
        theNameHeading.setFont(fntDialog20);
        theNameHeading.setForeground(Color.white);
        thePanel.add(theNameHeading);

        theScoreHeading.setBounds(850, 0, 300, 50);
        theScoreHeading.setFont(fntDialog20);
        theScoreHeading.setForeground(Color.white);
        thePanel.add(theScoreHeading);

        //Prints the leaderboard
        for(int intLoopCount = 0; intLoopCount < theLeaderboard.getLength(); intLoopCount++){
            theNames[intLoopCount] = new JLabel(strLeaderboard[intLoopCount][0]);
            theNames[intLoopCount].setBounds(20, intEntryY, 300, 50);
            theNames[intLoopCount].setFont(fntDialog13);
            theNames[intLoopCount].setForeground(Color.white);
            thePanel.add(theNames[intLoopCount]);

            theScores[intLoopCount] = new JLabel(strLeaderboard[intLoopCount][1]);
            theScores[intLoopCount].setBounds(850, intEntryY, 300, 50);
            theScores[intLoopCount].setFont(fntDialog13);
            theScores[intLoopCount].setForeground(Color.white);
            thePanel.add(theScores[intLoopCount]);

            intEntryY += 20;
        }
    }
}