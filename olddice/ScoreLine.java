// ScoreLine

// This holds one line of the score in a Yahtzee game

package olddice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScoreLine extends JPanel implements ActionListener
{
   JButton category; // press to choose this score
   JTextField theScore; // number for this row
   int score; // integer to store your score for this (same as theScore)
   static Dice[] diceArray;
   protected int[] faceCount; // faceCount[3] is the number of 3s
   int product; // product of non-zero faceCounts
   static Roller theRoller;
   
   // constructor
   public ScoreLine( String s )
   {
      category = new JButton(s);
      add(category);
      category.addActionListener(this);
      
      theScore = new JTextField("",5);
      add(theScore);
      theScore.setEditable(false);
      
      faceCount = new int[7];
      
      setPreferredSize( new Dimension(200,30) );
      //setBorder( 1 );
   }
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource()==category ) { computeScore(); category.setEnabled(false); }
      //validate();
      theRoller.rollCount = 0;
      repaint();
   }
   
   // read the values of the dice, put the correct score in
   // this ScoreLine's theScore, and ... move the game along
   public void computeScore()
   {
      if      ( category.getText().equals("1s") ) { doNum(1); }
      else if ( category.getText().equals("2s") ) { doNum(2); }
      else if ( category.getText().equals("3s") ) { doNum(3); }
      else if ( category.getText().equals("4s") ) { doNum(4); }
      else if ( category.getText().equals("5s") ) { doNum(5); }
      else if ( category.getText().equals("6s") ) { doNum(6); }
      else if ( category.getText().equals("full house") ) { doFullHouse(); }
      
      resetDice();
   }
   
   // set the score according to full house rule
   public void doFullHouse()
   {
      basicCounts();
      score = 0;
      if ( product==5 || product==6 ) { score = 25; }
      theScore.setText(""+score);
      
   }
   
   // score this for 1s or 2s or 3s ... whichever is whichFace
   public void doNum( int whichFace )
   {
      basicCounts();
      score = faceCount[whichFace] * whichFace;
      theScore.setText(""+score);
      
      theRoller.scores[6].addToTotal( score );
      
   }
   
   // some other ScoreLine is telling us to add 'a' to THIS total
   public void addToTotal( int a )
   {
      score += a;
      theScore.setText(""+score);
   }
   
   // fills array with how many ones, how many twos ... 
   public void basicCounts()
   {
      // zero the faceCount array
      // i counts through the possible numbers on dice 1-6
      for( int i=1; i<=6; i++ ) { faceCount[i] = 0; }
      
      // j counts through the 5 dice
      for ( int j=0; j<5; j++ ) { faceCount[diceArray[j].face] += 1;}
      
      product = 1;
      for( int i=1; i<=6; i++ )
      {
         if ( faceCount[i]>0) { product *= faceCount[i]; }
      }
      
   }
   
   public void resetDice()
   {
      for ( int j=0; j<5; j++ ) { diceArray[j].reset(); }
   }
}
