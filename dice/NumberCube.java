
// NumberCube.java
// CS-212 class 2015
// panel that displays a 6-sided dice

package dice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class NumberCube  extends JPanel implements MouseListener
{
   int display; // the number showing on the cube as it rests
   Random randy;
   int ds = 10; // dot size
   boolean stuck; // true means don't roll it

   // constructor
   public NumberCube()
   {
      setPreferredSize( new Dimension(100,100) );
      stuck = false;
      
      randy = new Random();
      
      setBackground( randomColor() );
      
      display = 0; // 1+randy.nextInt(6);
      
      addMouseListener(this);
   }
   
   // generates a new 'display' (rolls the die)
   // only changes display if not stuck
   public void roll()
   {
      if ( !stuck) { display = 1+randy.nextInt(6); }
   }
   
   
    //return a random color - paste.
   public Color randomColor()
   {
      Color c;
      c = new Color(
                      150 + randy.nextInt(100),
                      150 + randy.nextInt(100),
                      150 + randy.nextInt(100)
                   );
      return c;
   }
   
   // click sticks or un-sticks the numberCube
   public void mouseClicked( MouseEvent e )
   {
      //roll();
      stuck = !stuck;
      repaint();
   }
   public void mousePressed( MouseEvent e ) {}
   public void mouseReleased( MouseEvent e ) {}
   public void mouseEntered( MouseEvent e ) {}
   public void mouseExited( MouseEvent e ) {}
   
   public void reset()
   {
      stuck = false;
      display = 0;	
   }
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      
      g.setColor( Color.black );
      if ( stuck ) { g.setColor(Color.white); }
      //g.drawString( ""+display, 50, 50  );
      
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
         g.fillOval(80,80,ds,ds);
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
