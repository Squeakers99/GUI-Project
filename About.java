/*
 * Soheil Rajabali and Jayred Robles
 * Momentum and Collisions Simulator
 * V1.0
 */

import java.awt.Dimension;

public class About extends Help{
    //------------------CONSTRUCTOR------------------
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