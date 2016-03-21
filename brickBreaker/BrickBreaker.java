// BrickBreaker.java

// CS-212 2016
// basically brickout/breakout

package brickBreaker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BrickBreaker extends JFrame
{
   CannonBall theBall; // goes around and wrecks bricks
   
   Brick[] wall;
   int brickCount;
   Paddle thePaddle;

   public static void main( String[] args )
   {
      new BrickBreaker();
   }
   
   // constructor
   public BrickBreaker()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Brick Breaker");
      
      theBall = new CannonBall(this);
      thePaddle = new Paddle(this);
      
      wall = new Brick[50];
      for ( int i=0; i<8; i++ )
      {
         for ( int j=0; j<3; j++ )
         {
            wall[brickCount++] = new Brick( 38 + i*65, 80 + j*50 );
         
         }
         
      }
      
      setSize(600,600);
      
      addMouseMotionListener(thePaddle);
      
      setVisible(true);
   }
   
   // erase the ith brick
   public void killBrick( int i )
   {
      wall[i] = wall[--brickCount];
   }
   
   
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      
      theBall.drawMe(g);
      thePaddle.drawMe(g);
      
      for ( int i=0; i<brickCount; i++ )
      {
         wall[i].drawMe(g);
      }
   }

}
