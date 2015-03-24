// Sorry.java
// CS-212 2015
// This is for starters just a way to call NumberCube.

package dice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sorry extends JFrame implements ActionListener
{
   NumberCube[] cubies;  // holds two dice
   int cubieCount=0; // number in above array
   JButton rollAllButton;  // click to roll all dice
   int tossCount; // number of times you've rolled dice in this turn.
   JButton resetButton;

   public static void main ( String [] args )
   {
      new Sorry();
   }
   
   // constructor
   public Sorry()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      setLayout( new FlowLayout() );
      
      getContentPane().
      setBackground( Color.yellow );
      
      rollAllButton = makeButton( "roll all");
      resetButton   = makeButton("reset");
      /*
      rollAllButton = new JButton("roll all");
      add(rollAllButton);
      rollAllButton.addActionListener(this);
      */
      
      
      tossCount = 0;
      
      cubies = new NumberCube[20];
      while ( cubieCount < 5 )
      //for ( int i=0; i<5; i++ )
      {
         add( cubies[cubieCount++] = new NumberCube() );
      }
      
      setSize( 500,500 );
      setVisible(true);
   }
   
   // makes a button with given label, puts it in the window
   // and connects to actionListener(this)
   public JButton makeButton( String s )
   {
      JButton b = new JButton(s );
      add(b);
      b.addActionListener(this);
      return b;
   }
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource()==rollAllButton ) { rollAll(); }
      if ( e.getSource()==resetButton   ) { reset(); }
      repaint();
   }
   
   // roll all of the dice
   public void rollAll()
   {
      if ( tossCount<3 )
      {
	      for ( int i=0; i<cubieCount; i++ )
	      {
	         cubies[i].roll();
	      }
	      tossCount++;
      }
   }
   
   public void reset()
   {
      for ( int i=0; i<cubieCount; i++ )
      {
          cubies[i].reset();
      }
      tossCount = 0;
   }
}
