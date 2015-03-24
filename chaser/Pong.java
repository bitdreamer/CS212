// Pong.java
// a dot to run around the screen

package chaser;

import java.awt.*;
import java.util.*;

public class Pong
{
   double x, y; // coords of thie Pong from upper left in pixels
   double vx, vy ; // velocity in x and y in pixels per second 
   static Random randy; 
   static Pong[] pings;  // list of all Pongs
   static int pingsCount; // number actually on the above list
   
   // constructor
   //public Pong()
   public Pong( Pong[] pings1, int pingsCount1 )
   {
      pings = pings1; 
      pingsCount = pingsCount1;
      
      randy = new Random();
      x = randy.nextInt(500); 
      y = randy.nextInt(500); 
      
      vx = randy.nextInt(20) - 10;
      vy = randy.nextInt(20) - 10;
   }
   
   // take a step in direction of velocity vx, vy
   // deltat is how long in time you should go
   public void move( double deltat )
   {
      // run away from the closest other Pong
      //Pong stalker = findClosePong();
      Pong stalker = findRandomPong();   
      vx = -(x - stalker.x);
      vy = -(y - stalker.y);
      
      bounce();
   
      x += vx * deltat;
      y += vy * deltat;
      bounce();
   }
   
   // returns random Pong
   public Pong findRandomPong()
   {
      return pings[randy.nextInt(pingsCount)];
   }
   
   // returns the closest Pong to this one (but not itself)
   public Pong findClosePong()
   {
      double bestDist = 10000000; // 
      Pong closestPong = null ;
      
      for ( int i=0; i<pingsCount; i++ )
      {
         Pong p = pings[i];
         if ( p != this )
         {
         
            double xdif = x - p.x;
            double ydif = y - p.y;
            double dist = Math.sqrt( xdif*xdif + ydif*ydif );
            if ( dist < bestDist ) { bestDist = dist; closestPong = p;  }
         }
      }
      return closestPong;
   }
   
   // keeps the Pong in the window (turns velocity around if it 
   // hits the wall
   public void bounce()
   {
      if ( x>480 ) { vx = - randy.nextInt(20); }
      if ( x<20   ) { vx =   randy.nextInt(20); }
      if ( y>480 ) { vy = - randy.nextInt(20); }
      if ( y<50   ) { vy =   randy.nextInt(20); }
   }
   
   public void drawMe( Graphics g )
   {
      g.setColor( Color.blue );
      g.fillOval( (int)x, (int)y, 10, 10 );
   }
}
