// Art1.java
// Barrett Koster for CS-212 class 2013

package art;

import java.awt.*;
import javax.swing.*;

public class Art1 extends JFrame
{
   public static void main( String[] args )
   {
      new Art1(); // declares one of these objects
   }
   
   // constructor
   public Art1()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      setSize( 500,500);
      setVisible( true);
   }
   
   // get called automatically any time the window needs to be redrawn
   public void paint( Graphics g )
   {
      super.paint(g); // call to JFrame paint()
      
      g.drawLine( 50, 50, 250, 100 );
      g.drawRect( 50, 150, 100, 30 );
      g.drawOval( 50, 150, 100, 300 );
      g.setColor( Color.pink );
      g.fillRect(200,200,50,50 );
      g.drawString("blah",300,300);
      
   }
}
