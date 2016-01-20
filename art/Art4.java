// Art4.java
// Barrett Koster for CS-212 class 2013
// Random colors and positions...

package art;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Art4 extends JFrame
{
   public static void main( String[] args )
   {
      System.out.println("hi there.");
      new Art4();
   }
   
   // constructor
   public Art4()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      setSize( 500,500);
      setVisible( true);
   }
   
   public void paint( Graphics g )
   {
      super.paint(g);
      /*
      g.drawLine( 50, 50, 250, 100 );
      g.drawRect( 50, 150, 100, 30 );
      g.drawOval( 50, 150, 100, 30 );
      g.setColor( Color.pink );
      g.fillRect(200,200,50,50 );
      g.drawString("blah",300,300);
      */
      // notebook(g);
      // colorGrid(g);
      randomBoxes(g);
   }
   
   // randomBoxes will put a bunch of randomly sized boxes at
   // random places in the 500,500 window and with random colors.
   // This also draws lines between each box and the next.
   public void randomBoxes( Graphics g )
   {
      int x=0,y=0;
      int oldx=0, oldy=0;
      
      for ( int i=0; i<10; i++ )
      {
         // set random color
         g.setColor( new Color(
               (int) (10 + Math.random()*50),
               (int) (150 + Math.random()*20),
               (int) (150+ Math.random()*55) 
                              )
                   );
         x = (int) (Math.random()*450);
         y = (int) (Math.random()*450);
         g.fillRect(  x,  y, 20, 20 );
          
         g.drawLine( oldx, oldy, x, y );
         
         oldx = x; 
         oldy = y;
      }
   }
   
   // colorGrid draws a 2d array boxes of various colors
   public void colorGrid( Graphics g )
   {
      int y;
      for ( y=100; y<460; y = y + 40 )
      {
         oneRow( g, y );
      }
   }
   
   // oneRow draws a horizontal row of boxes 30x30 starting at 
   // x=100 and top of boxes is y (argument).  spacing is 10,
   // so 40 total from left corner to left corner
   public void oneRow( Graphics g, int y )
   {
      for ( int x=100; x<460; x = x+ 40 )
      {
         g.setColor(  new Color( x/2, y/2, 250 )  );
         g.fillRect( x, y, 30, 30 );
      }
   }
   
   public void notebook(Graphics  g)
   {
      g.setColor( new Color(150,150,250) );
      for ( int y=100; y<500; y=y+30 )
      {
         g.drawLine( 20, y, 480, y );
      }
   }
}
