/*
 * Soheil Rajabali and Jayred Robles
 * Momentum and Collisions Simulator
 * V1.0
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Leaderboard Object Created to manage the leaderboard
/**
 * Class Created to manage the leaderboard functionality
 * This class is able to read and write to a file, sort the leaderboard, and return the leaderboard data
 * 
 * @author Soheil Rajabali, Jayred Robles
 * @version 1.0
 * @since 2024-05-09
*/
public class LeaderboardClass {
    //------------------PROPERTIES------------------
    private BufferedReader theBufferedReader = null; // Used to read from a file
    private String strLeaderboard[][] = null; // Stores the leaderboard data
    private String strFileName = null; // File name of the leaderboard file
    private FileReader theFileReader = null; // Used to read from a file
    private String strLine = null; // Stores the current line being read
    private boolean blnEOF = false; // Indicates if end of file has been reached
    private boolean blnFileOpen = false; // Indicates if the file is open for writing
    private FileWriter theFileWriter = null; // Used to write to a file
    private PrintWriter thePrintWriter = null; // Used to write to a file
    private int intLineCount = 0; // Stores the number of lines in the leaderboard file
    private String strFileData = ""; // Stores the file data

    //------------------METHODS------------------

    // Reads a line from the file
    /**
     * Reads a line from the file
     * @return the line that was read
     */
    public String readLine() {
        String strOldLine;
        try {
            if(this.blnEOF == true){
                System.out.println("Attempting to read past the end of the file");
            }
            strOldLine = this.strLine;
            this.strLine = this.theBufferedReader.readLine();
            if (this.strLine == null || this.strLine.length() == 0) {
                this.blnEOF = true;
            }
            return strOldLine;
        } catch (IOException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    // Adds an entry to the leaderboard
    /**
     * Adds an entry to the leaderboard
     * @param strName the name of the player
     * @param intScore the score of the player
     */
    public void entry(String strName, int intScore) {
        this.thePrintWriter.println(strName + "," + intScore);
        this.thePrintWriter.flush();
        if (this.blnFileOpen == false) {
            System.out.println("Attempted to write to a file that is already closed");
        }
    }

    // Closes the file
    /**
     * Closes the file from reading or writing
     * @param strReadOrWrite the type of file to close
     */
    public void close(String strReadOrWrite) {
        if (strReadOrWrite.equalsIgnoreCase("read")) {
            try {
                this.theBufferedReader.close();
                this.theFileReader.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
            blnEOF = true;
        } else {
            try {
                this.thePrintWriter.close();
                this.theFileWriter.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
            blnFileOpen = false;
        }
    }

    // Loads the leaderboard data into a string
    /**
     * Loads the leaderboard into a string
    */
    public void leaderboardDataLoading() {
        while (this.blnEOF == false) {
            intLineCount++;
            this.strFileData += this.readLine() + ";";
        }
        this.close("read");
    }

    // Returns the length of the leaderboard
    /**
     * Returns the length of the leaderboard
     * @return the length of the leaderboard
     */
    public int getLength() {
        return this.intLineCount;
    }

    // Loads the leaderboard data into the strLeaderboard array
    /**
     * Loads the leaderboard data into an array
    */
    public void LoadArray() {
        this.leaderboardDataLoading();
        strLeaderboard = new String[intLineCount][2];
        String[] strPlayerData = new String[intLineCount];
        String[] strPlayerData2 = new String[2];
        strPlayerData = this.strFileData.split(";");
        for (int intLineNumber = 0; intLineNumber < intLineCount; intLineNumber++) {
            strPlayerData2 = strPlayerData[intLineNumber].split(",");
            this.strLeaderboard[intLineNumber][0] = strPlayerData2[0];
            this.strLeaderboard[intLineNumber][1] = strPlayerData2[1];
        }
    }

    // Sorts the leaderboard in descending order based on scores
    /**
     * Sorts the leaderboard in descending order based on scores
    */
    public void sortLeaderboard() {
        String strTempName;
        String strTempScore;
        for (String[] leaderboardEntry : this.strLeaderboard) {
            for (String[] innerEntry : this.strLeaderboard) {
                if (Integer.parseInt(leaderboardEntry[1]) > Integer.parseInt(innerEntry[1])) {
                    strTempName = leaderboardEntry[0];
                    strTempScore = leaderboardEntry[1];
                    leaderboardEntry[0] = innerEntry[0];
                    leaderboardEntry[1] = innerEntry[1];
                    innerEntry[0] = strTempName;
                    innerEntry[1] = strTempScore;
                }
            }
        }
    }

    // Returns the leaderboard data
    /**
     * Returns the leaderboard data
     * @return the leaderboard data
     */
    public String[][] getLeaderboard() {
        return this.strLeaderboard;
    }

    //------------------CONSTRUCTORS------------------

    // Opens the leaderboard file for reading
    /**
     * Opens the leaderboard file for reading
     * @param strFileName the name of the file to read
    */
    public LeaderboardClass(String strFileName) {
        this.strFileName = strFileName;
        try {
            this.theFileReader = new FileReader(this.strFileName);
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
        if (this.theFileReader != null) {
            this.theBufferedReader = new BufferedReader(this.theFileReader);
            try {
                this.strLine = this.theBufferedReader.readLine();
                if (this.strLine == null || this.strLine.length() == 0) {
                    this.blnEOF = true;
                }
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        } else {
            this.blnEOF = true;
        }
        this.LoadArray();
        this.sortLeaderboard();
    }

    // Opens the leaderboard file for writing
    
    public LeaderboardClass(String strFileName, boolean blnAppend) {
        try {
            this.theFileWriter = new FileWriter(strFileName, blnAppend);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        this.thePrintWriter = new PrintWriter(this.theFileWriter);
        this.blnFileOpen = true;
    }
}
