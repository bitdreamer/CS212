// CannonBall.java

// CS-212 2016

// the thing that moves around and break the bricks

package brickBreaker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.util.*;

public class CannonBall implements ActionListener
{
   double x, y; // location of the center of the ball
                // from upper left of window, in pixels
   double vx, vy; // velocity of CannonBall, pixels per second
   
   double speed=150; // velocity
   
   javax.swing.Timer clicky;
   
   BrickBreaker theGame; // points up to main program
   
   public static void main( String[] args )
   {
      new BrickBreaker();
   }
   
   public CannonBall( BrickBreaker bb )
   {
      theGame = bb;
   
      x = 300 ;
      y = 200 ;
      
      vx = speed/3;
      vy = speed;
      
      clicky = new Timer(100,this);
      clicky.start();
   }
   
   public void actionPerformed( ActionEvent e )
   {
      move(0.1);
      theGame.repaint();
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
      if ( x>580 ) {  x = 580; vx = - vx; }
      
      if ( y>580 ) {  y = 580; vy = - vy; } // still sticks?
      
      if ( x<10 ) { x = 10; vx = -vx; }
      
      if ( y<40 ) { y = 40; vy = -vy;}
   }
     
   
   // 
   public void drawMe( Graphics g )
   {
      g.setColor( Color.BLUE );
      g.fillOval( (int)(x-10), (int)(y-10), 20, 20 );
   }
}
