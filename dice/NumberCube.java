
// NumberCube.java
// CS-212 class 2015
// panel that displays a 6-sided dice

package dice;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class NumberCube  extends JPanel
{
   int display; // the number showing on the cube as it rests
   Random randy;
   int ds = 10; // dot size

   // constructor
   public NumberCube()
   {
      setPreferredSize( new Dimension(100,100) );
      
      randy = new Random();
      
      setBackground( randomColor() );
      
      display = 1+randy.nextInt(6);
   }
   
   
    //return a random color
   public Color randomColor()
   {
      Color c;
      c = new Color(
                      randy.nextInt(255),
                      randy.nextInt(255),
                      randy.nextInt(255)
                   );
      return c;
   }
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      
      g.setColor( Color.black );
      g.drawString( ""+display, 50, 50  );
      
      if ( display==1 )
      {
         g.fillOval( 50, 50, ds, ds );
      }
      else if (display==2)
      {
         g.fillOval(20,20,ds,ds);
         g.fillOval(80,80,ds,ds);
      }
      else if (display==3)
      {
         g.fillOval(20,20,ds,ds);
         g.fillOval( 50, 50, ds, ds );
         g.fillOval(40,40,ds,ds);
      }
      else if (display==4)
      {
         g.fillOval(20,20,ds,ds);
         g.fillOval(80,80,ds,ds);
         g.fillOval(20,80,ds,ds);
         g.fillOval(80,20,ds,ds);
      }
      else if (display==5)
      {
         g.fillOval(20,20,ds,ds);
         g.fillOval(80,80,ds,ds);
         g.fillOval(20,80,ds,ds);
         g.fillOval(80,20,ds,ds);
         g.fillOval( 50, 50, ds, ds );
      }
      else if (display==6)
      { 
         g.fillOval(20,20,ds,ds);
         g.fillOval(20,50,ds,ds);
         g.fillOval(80,80,ds,ds);
         g.fillOval(20,80,ds,ds);
         g.fillOval(80,20,ds,ds);
         g.fillOval(80,50,ds,ds);
      }
   }
}
