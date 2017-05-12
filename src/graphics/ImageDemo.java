package graphics;

import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
public class ImageDemo extends Sprite
{
  public static void main(String[] args) throws Exception
  {
    new ImageDemo("C:/Users/S516830/Desktop/Robit/images.jpg");
  }

  public ImageDemo(final String filename) throws Exception
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        JFrame editorFrame = new JFrame("Image Demo");
        editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Sprite i =new Sprite();
        Image image = null;
        try
        {
          image = (Image)ImageIO.read(new File(filename));
          i.addImage(image);
          
        }
        catch (Exception e)
        {
          e.printStackTrace();
          System.exit(1);
        }
        i.setSize(.5);
        i.setAngle(-90);
        ImageIcon imageIcon = new ImageIcon(i.getImage());
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);

        editorFrame.pack();
        editorFrame.setLocationRelativeTo(null);
        editorFrame.setVisible(true);
      }
    });
  }
}