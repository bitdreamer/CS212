// ImageDemo.java
// Barrett Koster and the CS-212 class 2015

package guis;

import java.awt.*;
import javax.swing.*;

public class ImageDemo extends JFrame
{
   ImageIcon ma; // = new ImageIcon(("player.png"));
   
   JButton nielButton;

   public static void main ( String [] args )
   {
      new ImageDemo();
   }
   
   public ImageDemo()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      setLayout(new FlowLayout());
      
      ma = new ImageIcon("5-hanlon.jpg" );
      
      nielButton = new JButton( ma );
      add( nielButton );
      
      setSize( 500, 500 );
      setVisible( true );
   }
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      
      //  g.drawImage(getPimage(), x, y, null);
      
      g.drawImage( ma.getImage(), 100, 100, null   );
   }
}
