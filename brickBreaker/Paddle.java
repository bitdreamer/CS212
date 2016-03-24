// Paddle.java
// CS-212 2016

package brickBreaker;

import java.awt.*;
import java.awt.event.*;

public class Paddle implements MouseMotionListener
{
   double x; // coordinate of middle of paddle
   int y=570; // coord of the top of the paddle 
   int width; // all the way across
   int height=10;
   
   BrickBreaker theGame;
   
   Color color; 
   
   // constructor
   public Paddle( BrickBreaker bb)
   {
      theGame = bb;
      
      color = new Color( 185,122,87);
      
      x= 300; // start in the middle
      width = 100;
   }
   
      // returns true iff ball is hitting this paddle
   public boolean hit( int xball, int yball, int radius )
   {
      return (   x-width/2-radius < xball && xball < x+width/2+radius 
          && y-radius < yball && yball < y+height+radius
         );

         
   }

   
   public void mouseMoved( MouseEvent m )
   {
      x = m.getX();
      //theGame.repaint();
   }
   public void mouseDragged( MouseEvent m ) {}

   
   public void drawMe(Graphics g)
   {
     g.setColor(color);
     g.fillRect( (int)(x-width/2), y, width, height );
   }
   
}
