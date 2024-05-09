/*
 * Soheil Rajabali and Jayred Robles
 * Momentum and Collisions Simulator
 * V1.0
 */

package Collisions;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * <h1>Help Panel</h1>
 * The Help class represents a JPanel that displays a help image.
 * It extends the JPanel class and overrides the paintComponent method to draw the image on the panel.
 */
public class Help extends JPanel{
    //------------------PROPERTIES------------------
    //Help Image
    BufferedImage img = null;
    InputStream imageclass = null;

    //------------------METHODS------------------

    /**
     * Overrides the paintComponent method to draw the image on the panel.
     * 
     * @param theGraphics the Graphics object used for drawing
     */
    @Override
    public void paintComponent(Graphics theGraphics){
        theGraphics.drawImage(img, 0, 0, null);
    }

    /**
     * Loads the image from the specified file name.
     * 
     * @param strFileName the file name of the image to be loaded
     */
    public void loadImage(String strFileName){
        imageclass = this.getClass().getResourceAsStream(strFileName);

        if(imageclass == null){
            System.out.println("Unable to load image file");
        }else{
            try{
                img = ImageIO.read(imageclass);
            }catch(IOException e){
                System.out.println(e.toString());
                System.out.println("Unable to load image file");
            }
        }

        try{
            img = ImageIO.read(new File(strFileName));
        }catch(IOException e){
            System.out.println("Unable to load local image file");
        }
    }

    //------------------CONSTRUCTOR------------------
    /**
     * Constructs a Help object.
     * Sets up the panel, loads the image, and repaints the panel to show the image.
    */
    public Help(){
        //Sets up the panel
        this.setLayout(null);
        this.setPreferredSize(new Dimension(960, 540));

        //Tries to load the image from the jar file
        loadImage("Help.png");

        //Repaints the panel to show the image
        this.repaint();
        System.out.println("Repainted");
    }
}