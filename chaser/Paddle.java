// Paddle.java
// CS-212 2014 
// This is the paddle at the bottom of the screen that bounces the bricks.

package chaser;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paddle implements MouseMotionListener
{
   Jimmy theJimmy;  // the wrecking ball, Paddle needs to know to bounce it
   BrickOut theBrickOut; // needed to redraw when position changes
   int x; // position of the middle of the paddle
   int y; // middle on this one too
   int height; // pixels
   int width; // pixels
   
   // constructor
   public Paddle( BrickOut b, Jimmy j )
   {
      y = 450;
      x = 250;
      height = 5;
      width = 50;
      theBrickOut = b;
      theJimmy = j;
   }
   
   // when mouse moves, set paddle center to mouse position and repaint whole window
   public void mouseMoved( MouseEvent e )
   {
      x = e.getX();
      
      theBrickOut.repaint();
   }
   public void mouseDragged( MouseEvent e ) {}
   
   // if theJimmy is hitting the Paddle then make it bounce
   public void bounce()
   {
      if (    x-width/2<theJimmy.x && theJimmy.x < x+width/2 
           && y-height<theJimmy.y && theJimmy.y < y+height
         )
      {
         theJimmy.vy = -theJimmy.vyraw; // 
         double xdif = theJimmy.x - x; // position of Jimmy relative to paddle center
         theJimmy.vx = 7*xdif; // move Jimmy in that direction
      }
   }
   
   public void drawMe( Graphics g )
   {
      g.setColor( new Color(150, 180, 245) );
      g.fillRect( x-width/2, y-height/2, width, height );
   }
}
