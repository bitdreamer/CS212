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

   public static void main( String[] args )
   {
      new BrickBreaker();
   }
   
   public BrickBreaker()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Brick Breaker");
      
      theBall = new CannonBall(this);
      
      setSize(600,600);
      
      setVisible(true);
   }
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      
      theBall.drawMe(g);
   }

}
