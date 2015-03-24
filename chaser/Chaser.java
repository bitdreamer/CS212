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
   JButton modeButton; // changes mode below
   int mode = 0; // 0=move to random buddy, 1=move to nearest buddy,
                 // 2=move away from nearest
   
   
   public static void main( String [] args )
   {
      new Chaser();
      
   }
   
   // constructor
   public Chaser()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(500,500);
      
      setLayout(new FlowLayout());
      modeButton = new JButton("all clump");
      add(modeButton);
      modeButton.addActionListener(this);
      
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
      if      ( e.getSource()==clicky     ) { doClick(); }
      else if ( e.getSource()==modeButton ) { doMode(); }
      repaint();
   }
   
   // increments mode, sets text of button, also sets Pong.mode so
   // Pongs know how to move
   public void doMode()
   {
      mode = (mode+1)%3; 
      if      ( mode==0 ) { modeButton.setText("all clump");   }
      else if ( mode==1 ) { modeButton.setText("local clump"); }
      else if ( mode==2 ) { modeButton.setText("space out");    }
      Pong.mode = mode;
      
      //pings[7].x = 345;
     // pings[7].mode = mode;
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
