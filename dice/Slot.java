// Slot.java
// CS-212 2016

package dice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Slot extends JPanel implements ActionListener
{
   Random randy;
   
   JButton theButton; // press this to score this item
   JTextField theScoreField; // field that holds/displays the points
   int score; // the points from the dice for this slot
   static Font f;
   String whatFor;  // this slot scores whatFor
   
   boolean used = false; // true means you scored this, can't use again
   
   static Die[] dice; // points to the dice up in main class


   public Slot( String wf )
   {
      whatFor = wf;
      randy = new Random();
      setPreferredSize( new Dimension(300, 30 ) );
      setBackground( doPastel() );
      
      if (f==null)
      {      f= new Font("TimesNewRoman",0,20); }

      
      setLayout( new GridLayout(1,2) );
      theButton = new JButton(whatFor);
      theButton.setFont(f);
      add(theButton);
      theButton.addActionListener(this);
      
      theScoreField = new JTextField("",5);
      theScoreField.setFont(f);
      theScoreField.setHorizontalAlignment(JTextField.RIGHT);
      theScoreField.setEditable(false);
      theScoreField.setBackground( Color.white );
      add(theScoreField);
      
   }
   
   public Color doPastel()
   {
      int   red = 150 + randy.nextInt(100);
      int green = 150 + randy.nextInt(100);
      int  blue = 150 + randy.nextInt(100);
      
      return new Color( red, green, blue );
   }
   
   @Override
   public void actionPerformed( ActionEvent e )
   {
      // figure out the score and put it in the score field
      // only do IF you haven't already
      
      if ( !used) 
      {
         score = computeScore();
         theScoreField.setText(""+score);
         used = true;
      }
      repaint();
   }
   
   // return the value of the score for this slot
   public int computeScore()
   {
      // this is just the total on the dice.  (fix)
      int total = 0;
      for ( int i=0; i<5; i++ )
      {
         total += dice[i].faceUp;
      }
      return total;
   }
   
}
