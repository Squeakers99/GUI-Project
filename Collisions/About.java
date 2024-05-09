/*
 * Soheil Rajabali and Jayred Robles
 * Momentum and Collisions Simulator
 * V1.0
 */

package Collisions;

import java.awt.Dimension;

/**
 * <h1>About Panel</h1>
 * This class creates a JPanel to display the About Screen.
 * 
 * @author Soheil Rajabali, Jayred Robles
 * @version 1.0
 * @since 2024-05-09
 */

public class About extends Help{
    //------------------CONSTRUCTOR------------------

    /**
     * Constructor that creates the About Panel
    */
    public About(){
        //Sets up the panel
        this.setLayout(null);
        this.setPreferredSize(new Dimension(960, 540));

        //Tries to load the image from the jar file
        loadImage("About.png");

        //Repaints the panel to show the image
        this.repaint();
        System.out.println("Repainted");
    }
}