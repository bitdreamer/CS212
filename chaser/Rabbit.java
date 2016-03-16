// Rabbit.java
// 

package chaser;

import java.awt.*;

public class Rabbit
{
   double x, y; // location in the window from upper left, in pixels
   double vx, vy; // velocity of rabbit, pixels per second
   
   double maxVel=150; // maximum velocity
   
   public Rabbit()
   {
      x = Math.random() * 500 ;
      y = Math.random() * 500 ;
      
      vx = 25 - Math.random() * maxVel;
      vy = 25 - Math.random() * maxVel;
      
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
      if ( x>580 ) {  vx = - Math.random()*maxVel; }
      
      if ( y>580 ) {  y = 580; vy = - vy; } // still sticks?
      
      if ( x<10 ) { vx = Math.random()*maxVel; }
      
      if ( y<40 ) { vy = Math.random()*maxVel;}
   }
     
   
   public void drawMe( Graphics g )
   {
      g.setColor( Color.LIGHT_GRAY );
      g.fillOval( (int)x, (int)y, 10, 10 );
   }
}
