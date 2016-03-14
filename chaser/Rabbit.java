// Rabbit.java
// 

package chaser;

import java.awt.*;

public class Rabbit
{
   double x, y; // location in the window from upper left, in pixels
   double vx, vy; // velocity of rabbit, pixels per second
   
   public Rabbit()
   {
      x = Math.random() * 500 ;
      y = Math.random() * 500 ;
      
      vx = 25 - Math.random() * 50;
      vy = 25 - Math.random() * 50;
      
   }
   
   // move amount for deltat seconds
   public void move( double deltat )
   {
      x = x + vx * deltat;
      y = y + vy * deltat;
      stayInPen();
   }
   
   // don't let the rabbit move out of the window.
   public void stayInPen()
   {
      if ( x>580 ) {  vx = - Math.random()*50; }
      
      if ( y>580 ) {  y = 580; vy = - vy; } // still sticks?
      
      
   }
     
   
   public void drawMe( Graphics g )
   {
      g.setColor( Color.LIGHT_GRAY );
      g.fillOval( (int)x, (int)y, 10, 10 );
   }
}
