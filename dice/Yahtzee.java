// yahtzee.java
// CS-212 2016
// Starting to play the game Yahtzee, one player version.

package dice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Yahtzee extends JFrame
   implements ActionListener
{
   JPanel dicePanel; // top of the window, holds dice and roll button
   JPanel upperPanel; // holds 'upper' scores for Yahtzee, do west
   JPanel lowerPanel; // holds 'lower' scores, put in the east
   
   Slot[] slots;

   Die theDie; // for testing
   Die[] dice;
   int diceCount;
   JButton rollButton;

   public static void main ( String [] args )
   {
      new Yahtzee();
   }
   
   // constructor
   public Yahtzee()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Yahtzee sort of");
      
      setLayout( new BorderLayout() );
      
      dicePanel = new JPanel();
      add( dicePanel, BorderLayout.NORTH );

      diceCount = 0;
      dice = new Die[40];
      for ( int i=0; i<5; i++ )
      {
         dice[diceCount++] = new Die();
         dicePanel.add( dice[diceCount-1]);
      }
      
      rollButton = new JButton("roll");
      dicePanel.add( rollButton );
      rollButton.addActionListener( this );
      rollButton.setFont(Die.f);
      
      upperPanel = new JPanel(); upperPanel.setBackground(Color.pink);
      add( upperPanel, BorderLayout.WEST );
      upperPanel.setLayout( new GridLayout(8,1) );
      
      lowerPanel = new JPanel();lowerPanel.setBackground(Color.lightGray);
      add( lowerPanel, BorderLayout.EAST );
      lowerPanel.setLayout( new GridLayout(8,1) );
      
      slots = new Slot[17];
      for ( int i=0; i<8; i++ )
      {
         Slot s = new Slot();
         slots[i] = s;
         upperPanel.add( s ); 
      }
      for ( int i=8; i<16; i++ )
      {
         Slot s = new Slot();
         slots[i] = s;
         lowerPanel.add( s ); 
      }
            
      setSize(800,800);
      setVisible(true);
   }
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource()==rollButton ) { rollAll();  }
      repaint();
   }
   
   // tell all of the dice to roll themselves
   public void rollAll()
   {
      for ( int i=0; i<diceCount; i++ )
      {
         dice[i].roll();
      }
   }
}
