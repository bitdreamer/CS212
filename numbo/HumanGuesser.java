// HumanGuesser.java
// CS-212 

package numbo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class HumanGuesser extends Guesser implements ActionListener
{
   String name; // person's name
   
   JTextField guessField; 

   public HumanGuesser( Teaser t )
   {
      super(t);
      
      name = JOptionPane.showInputDialog("your name? ");
      
      guessField = new JTextField(10);
      add( new JLabel("enter digist separated by spaces ") );
      add( guessField );
      guessField.addActionListener( this );
   }
   
   // assume that user just made a guess, process it
   public void actionPerformed ( ActionEvent e )
   {
      System.out.println("guess processing ....");
      String whole = guessField.getText();
      StringTokenizer st = new StringTokenizer( whole );
      
      int[] oneGuess = new int[Pattern.patternLength];
      int i=0;
      while ( i < Pattern.patternLength )
      {
         oneGuess[i++] = Integer.parseInt( st.nextToken() );
      }
   
      Pattern p;
      p = already[alreadyCount++] = new Pattern( oneGuess );
      
      Score theScore = theTeaser.scoreGuess( p );
      
      p.setScore( theScore );
      
      repaint();
   }
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      
      for( int i=0; i< alreadyCount; i++ )
      {
         System.out.println( already[i].toString() );
      }
      
   }
   
}
