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
   
   /// The following are commented out because we get to them in theChaser (instead
   // of making copies here.
   //static Pong[] pings;  // list of all Pongs
   //static int pingsCount; // number actually on the above list
   
   public static int mode; // same as in PongAnimation
   boolean imit=false; // true=this one chases the others in mode 3
   protected static PongAnimationStuff thePongAnimation;
   
   //Paddle thePaddle;
   
   int whichami; // my index in the array

   // constructor, this one is new, assumes that theChaser is already set
   // Takes this Pong's index in the array.
   // set random position and velocity
   public Pong( int i  )
   {
      whichami = i; // record which Pong this one is
      
      randy = new Random();
      x = randy.nextInt(500); 
      y = randy.nextInt(500); 
      
      vx = randy.nextInt(20) - 10;
      vy = randy.nextInt(20) - 10;
   }
   
   // take a step in direction of velocity vx, vy (at the very bottom of the method).
   // deltat is how long in time you should go
   // vx, vy is computed by mode, to move toward or away from others ...
   public void move( double deltat )
   {
      if ( mode==0 ) // move toward random buddy
      {
	      Pong crush = findRandomPong();   
	      vx = -(x - crush.x);
	      vy = -(y - crush.y);
      }
      else if (mode==1) // local clump
      {
	      Pong crush = findClosePong();
	      vx = -(x - crush.x);
	      vy = -(y - crush.y);
      }
      else if (mode==2)
      {
	      // run away from the closest other Pong
	      Pong stalker = findClosePong();
	      vx = (x - stalker.x);
	      vy = (y - stalker.y);
      }
      else if (mode==3)  // chaser
      {
         if ( imit && thePongAnimation.pingsCount>1 )
         {
            // this Pong is the Chaser, so find food move toward it, eat if close enough.
            Pong food = findClosePong();
            
		      vx = -(x - food.x);
		      vy = -(y - food.y);
		      double dist;
		      if ( (dist=distance(food))<10) //close enough to eat?  eat this food Pong
		      {
		         thePongAnimation.delete(food.whichami);
		      } 
		      else // not close enough to eat, just chase
		      { vx *= 100/dist; vy *= 100/dist; } // chase at velocity 100
         }
         else
         {
		      // run away from the chaser Pong (pings[0]) max velocity 30ish
		      Pong stalker = thePongAnimation.pings[0];
		      vx = (x - stalker.x); vx = cap(vx,20);
		      vy = (y - stalker.y); vy = cap(vy,20);
         }
      }         
      bounce();
	  x += vx * deltat;
	  y += vy * deltat;
	  bounce();
   }
   
   // max should be positive, x capped at +/- max is returned
   public double cap( double x, double max )
   {
      if ( x>max ) { x = max; }
      else if ( x< -max ) { x = -max; }
      return x;
   }
   
   // returns random Pong
   public Pong findRandomPong()
   {
      return thePongAnimation.pings[randy.nextInt(thePongAnimation.pingsCount)];
   }
   
   // returns the closest Pong to this one (but not itself)
   public Pong findClosePong()
   {
      double bestDist = 10000000; // 
      Pong closestPong = null ;
      
      for ( int i=0; i<thePongAnimation.pingsCount; i++ )
      {
         Pong p = thePongAnimation.pings[i];
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
   
   public double distance( Pong p )
   {
           double xdif = x - p.x;
            double ydif = y - p.y;
            double dist = Math.sqrt( xdif*xdif + ydif*ydif );
            return dist;
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
      if ( mode==3 && imit ) { g.setColor(Color.red); }
      g.fillOval( (int)x, (int)y, 10, 10 );
   }
}
