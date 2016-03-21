// Brick.java
// CS-212 2016

// get hit by CannonBall

package brickBreaker;

import java.awt.*;

public class Brick
{
   int x, y;  // upper left corner of brick in pixel from upper
              // left of window.
   static int width=60, height=45; // size of brick
   
   Color color; // color to paint the brick
   
   // constructor
   public Brick( int x1, int y1 )
   {
      x = x1;
      y = y1;
      
      color = new Color( 210, 43, 54 );
   }
   
   // returns true iff ball is hitting this brick
   public boolean hit( int xball, int yball, int radius )
   {
      return (   x-radius < xball && xball < x+width+radius 
          && y-radius < yball && yball < y+height+radius
         );

         
   }
   
   // draw this brick in the window
   public void drawMe( Graphics g )
   {
      g.setColor( color );
      g.fillRect( x, y, width, height );
   }

}
