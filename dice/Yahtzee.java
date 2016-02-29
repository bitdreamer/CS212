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

   //Die theDie; // for testing
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
      dice = new Die[5];    
      Slot.dice = dice;
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
      
      slots = new Slot[16];
      
      slots[0] = new SlotOnes(); // Slot("1s"); 
      slots[1] = new Slot("2s"); 
      slots[2] = new Slot("3s"); 
      slots[3] = new Slot("4s"); 
      slots[4] = new Slot("5s"); 
      slots[5] = new Slot("6s"); 
      slots[6] = new Slot("bonus"); 
      slots[7] = new Slot("upper total"); 
      
      for ( int i=0; i<8; i++ ) { upperPanel.add( slots[i] ); }
      
      slots[ 8] = new Slot("3 of a kind");
      slots[ 9] = new Slot("4 of a kind");
      slots[10] = new Slot("full hosue");
      slots[11] = new Slot("small straight");
      slots[12] = new Slot("large straight");
      slots[13] = new Slot("yahtzee");
      slots[14] = new Slot("chance");
      slots[15] = new Slot("lower total");
      
      for ( int i=8; i<16; i++ ) { lowerPanel.add( slots[i] ); }
            
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
