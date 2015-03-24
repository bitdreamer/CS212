// Chaser.java
// 2015 CS-212 class
// program for dots (Pongs) to chase each other around the screen


package chaser;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Chaser extends JFrame implements ActionListener
{
   //Pong ping; // holds one Pong to run around the screen
   Pong[] pings; // more Pongs
   int pingsCount = 40; // number of Pongs in the array
   Timer clicky;
   double timeStep = 0.1; // click duration in seconds
   
   
   public static void main( String [] args )
   {
      new Chaser();
      
   }
   
   // constructor
   public Chaser()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(500,500);
      
      // make array of Pongs
      pings = new Pong[pingsCount];
      for ( int i=0; i<pingsCount; i++ )
      {
         pings[i] = new Pong( pings, pingsCount );
      }
      
      //ping = new Pong();
      
      clicky = new Timer( (int)(1000*timeStep), this  ); // click every 0.10 second, 
      clicky.start();      
      setVisible(true);
   }
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource()==clicky ) { doClick(); }
      repaint();
   }
   
   // move the Pong
   public void doClick()
   {
      for ( int i=0; i<pingsCount; i++ )
      {
         //pings[i].x = pings[i].x + 10;
         pings[i].move(timeStep); // tenth of a second
      }
   }
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      
      for ( int i=0; i<pingsCount; i++ )
      { pings[i].drawMe(g); }
   }
}
