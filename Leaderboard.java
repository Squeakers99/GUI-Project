import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

// Leaderboard Object Created to manage the leaderboard
public class Leaderboard {
    // Properties
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

    // Methods

    // Reads a line from the file
    public String readLine() {
        String strOldLine;
        try {
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
    public void leaderboardEntry(String strName, int intScore) {
        this.thePrintWriter.println(strName);
        this.thePrintWriter.println(intScore);
        this.thePrintWriter.flush();
        if (this.blnFileOpen == false) {
            System.out.println("Attempted to write to a file that is already closed");
        }
    }

    // Closes the file
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

    // Calculates the length of the leaderboard file
    public void leaderboardLength() {
        while (this.blnEOF == false) {
            intLineCount++;
            this.readLine();
        }

        this.close("read");
        this.openFile();

        intLineCount /= 2;
    }

    // Returns the length of the leaderboard
    public int getLength() {
        return this.intLineCount;
    }

    // Loads the leaderboard data into the strLeaderboard array
    public void LoadArray() {
        this.leaderboardLength();
        strLeaderboard = new String[intLineCount][2];
        for (int intLineNumber = 0; intLineNumber < intLineCount; intLineNumber++) {
            this.strLeaderboard[intLineNumber][0] = this.readLine();
            this.strLeaderboard[intLineNumber][1] = this.readLine();
        }
        this.sortLeaderboard();
    }

    // Sorts the leaderboard in descending order based on scores
    public void sortLeaderboard() {
        String strTempName;
        String strTempScore;
        for (int intOuter = 0; intOuter < this.strLeaderboard.length; intOuter++) {
            for (int intInner = 0; intInner < this.strLeaderboard.length; intInner++) {
                if (Integer.parseInt(this.strLeaderboard[intOuter][1]) > Integer.parseInt(this.strLeaderboard[intInner][1])) {
                    strTempName = this.strLeaderboard[intOuter][0];
                    strTempScore = this.strLeaderboard[intOuter][1];
                    this.strLeaderboard[intOuter][0] = this.strLeaderboard[intInner][0];
                    this.strLeaderboard[intOuter][1] = this.strLeaderboard[intInner][1];
                    this.strLeaderboard[intInner][0] = strTempName;
                    this.strLeaderboard[intInner][1] = strTempScore;
                }
            }
        }
    }

    // Returns the leaderboard data
    public String[][] getLeaderboard() {
        this.LoadArray();
        return this.strLeaderboard;
    }

    // Opens the leaderboard file for reading
    private void openFile() {
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
    }

    // Constructors

    // Constructor that opens the leaderboard file for reading
    public Leaderboard(String strFileName) {
        this.strFileName = strFileName;
        this.openFile();
    }

    // Constructor that opens the leaderboard file for writing
    public Leaderboard(String strFileName, boolean blnAppend) {
        try {
            this.theFileWriter = new FileWriter(strFileName, blnAppend);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        this.thePrintWriter = new PrintWriter(this.theFileWriter);
        this.blnFileOpen = true;
    }
}
