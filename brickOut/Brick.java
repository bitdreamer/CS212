// Brick.java
// 2014 CS-212 

package brickOut;

import java.awt.*;

import javax.swing.*;

public class Brick
{
   int width = 50; // width in pixels
   int height = 20; // in pixels
   int x; // position of brick from upper left, in pixels
   int y;
   boolean hit = false; // says if this brick has been hit
   static int left; // number of bricks left un-hit
   
   // constructor
   public Brick( int x1, int y1)
   {
      x = x1; y = y1;
   }
   
   // if this brick is being hit by the Jimmy then ...
   // note that is has been hit.  
   public void smash( Jimmy theJimmy )
   {
      double jx = theJimmy.x;
      double jy = theJimmy.y;
      if ( jx>=x && jx<x+width && jy>=y && jy<y+height && !hit )
      {
         hit = true;
         theJimmy.vy = -theJimmy.vy;
         left--;
         if ( left<=0) { JOptionPane.showMessageDialog(null,"yippe!");}
      }
   }
   
   public void drawMe( Graphics g )
   {
      if ( !hit )
      {
         g.setColor( Color.red );
         g.fillRect( x, y, width, height );
      }
   }
}
