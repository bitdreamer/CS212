// BrickOut.java
// 2014 CS-212
// This is the game of brickout, where there's a wall of bricks
// and a ball that delets them.  You keep the ball in play with
// a paddle.  

package brickOut;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BrickOut extends JFrame implements ActionListener
{
   //Brick theBrick;
   Brick[] wall; // holds all of the Brick objects we want to hit.
   int brickCount; // number of bricks in the wall
   Jimmy theJimmy; // this is the dot that runs around and wrecks the bricks
   javax.swing.Timer timeyWimey; // creates pulses that drive the animation
   double deltat = 0.04; // seconds, time between pulses
   int jimmySupply = 5; // you get 5 to start, lose one each time you miss with
                        // the paddle
   
   Paddle thePaddle; // at the bottom of the window, slides horizontally ...
   
   public static void main ( String [] args )
   {
      new BrickOut();
   }
   
   // constructor, the usual window prep, makes the bricks, the Jimmy,
   // starts the timer, directs mouse motion events to the Paddle
   public BrickOut()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
            
      // make the array of bricks
      wall = new Brick[1000]; // more than enough, sue me
      brickCount = 0;
      for ( int i=0; i<32; i++ )
      {
         wall[brickCount++] = new Brick( 20 + (i%8)*55,  100 + (i/8) * 25 );
      }
      Brick.left = brickCount;
      
      // make the Jimmy, Paddle and set mouseMotionListener 
      theJimmy = new Jimmy();
      thePaddle = new Paddle(this,theJimmy);
      addMouseMotionListener( thePaddle );

      // get the timer going
      timeyWimey = new javax.swing.Timer( (int) (deltat * 1000), this );
      timeyWimey.start();
      
      // window stuff
      setSize( new Dimension(500,500) );
      setVisible(true);
   }
   
   // take clicks from the timer and call doClick(),
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource()==timeyWimey ) { doClick(); }
      repaint();
   }
   
   // If the bricks are all gone, stop.
   // Move the Jimmy, if it falls off the bottom, make a new one (or quit if
   // supply has run out).
   // Check to see if the Jimmy hits any bricks.
   // Bounce the Jimmy off the Paddle.
   public void doClick()
   {
      if ( Brick.left<=0) { timeyWimey.stop(); }
      theJimmy.move(deltat);
      
      // off screen at bottom? make a new one, 
      // if supply has run out, stop game
      if ( theJimmy.y > 600 ) 
      {
         if ( jimmySupply <= 0 ) { JOptionPane.showMessageDialog(null, "oops"); timeyWimey.stop();}
         else
         {
            theJimmy = new Jimmy();
            jimmySupply--;
            thePaddle.theJimmy = theJimmy;
         }
      }
      
      // check each brick to see if the Jimmy is hitting it.
      for ( int i=0; i<brickCount; i++ )
      {
         wall[i].smash( theJimmy  );
      }
      thePaddle.bounce();
      
   }
   
   // draw the Jimmy, the Paddle and all of the bricks
   public void paint( Graphics g )
   {
      super.paint(g);
      
      theJimmy.drawMe(g);
      thePaddle.drawMe(g);
      
      for ( int i=0; i<brickCount; i++ )
      {
         wall[i].drawMe(g);
      }
      
      g.drawString(""+jimmySupply, 10, 480 );
   }
}
