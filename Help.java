import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Help extends JPanel{
    //------------------Properties------------------
    //Panel
    //JPanel thePanel = new JPanel();

    //Help Image
    BufferedImage img = null;
    InputStream imageclass = null;

    @Override
    public void paintComponent(Graphics theGraphics){
        theGraphics.drawImage(img, 0, 0, null);
    }

    //Method to load the image
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