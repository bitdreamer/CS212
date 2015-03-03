// Roller.java
// This class creates a bunch of Dice objects 
// The user can roll them individually.


package olddice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Roller extends JFrame implements ActionListener
{
   Dice[] diceArray; // 
   // JTextField tf;
   JButton rollAllButton;
   ScoreLine[] scores;
   JPanel dicePanel, upperPanel, lowerPanel;
   int rollCount; // number of rolls done in this round, 0 to 3.
   
   public static void main( String [] args )
   {
      new Roller();
   }
   
   // construct window, put in 5 dice
   public Roller()
   {
      setTitle("Roller");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      // set the layout and put the main panels in place
      setLayout( new BorderLayout() );
      
      dicePanel = new JPanel();
      add( dicePanel, BorderLayout.NORTH );
      dicePanel.setBackground( Color.BLACK );
      
      upperPanel = new JPanel();
      add(upperPanel,BorderLayout.WEST);
      upperPanel.setBackground( Color.yellow );
      upperPanel.setLayout( new GridLayout(10,1) );
   
      
      lowerPanel = new JPanel();
      add(lowerPanel,BorderLayout.EAST);
      lowerPanel.setBackground( new Color(250, 230, 190) );
      lowerPanel.setLayout( new GridLayout(10,1) );
      
      
      diceArray = new Dice[5];
      ScoreLine.diceArray = diceArray;
      for ( int i=0; i<5; i++ )
      {
         diceArray[i] = new Dice();
         dicePanel.add(diceArray[i]);
         diceArray[i].reset();
      }
      
      
      rollCount = 0;
      
     rollAllButton = new JButton("roll all dice");
     add(rollAllButton, BorderLayout.CENTER );
     rollAllButton.addActionListener(this);
     
     ScoreLine.theRoller = this;
     scores = new ScoreLine[19];
     int i=0;
     scores[i++] = new ScoreLine("1s");          upperPanel.add(scores[i-1]);
     scores[i++] = new ScoreLine("2s");          upperPanel.add(scores[i-1]);
     scores[i++] = new ScoreLine("3s");          upperPanel.add(scores[i-1]);
     scores[i++] = new ScoreLine("4s");          upperPanel.add(scores[i-1]);
     scores[i++] = new ScoreLine("5s");          upperPanel.add(scores[i-1]);
     scores[i++] = new ScoreLine("6s");          upperPanel.add(scores[i-1]);
     scores[i++] = new ScoreLine("sub total");   upperPanel.add(scores[i-1]);
     scores[i++] = new ScoreLine("bonus");       upperPanel.add(scores[i-1]);
     scores[i++] = new ScoreLine("upper total"); upperPanel.add(scores[i-1]);
     
     scores[i++] = new ScoreLine("3 of a kind");    lowerPanel.add(scores[i-1]);
     scores[i++] = new ScoreLine("4 of a kind");    lowerPanel.add(scores[i-1]);
     scores[i++] = new ScoreLine("full house");     lowerPanel.add(scores[i-1]);
     scores[i++] = new ScoreLine("small straight"); lowerPanel.add(scores[i-1]);
     scores[i++] = new ScoreLine("large straight"); lowerPanel.add(scores[i-1]);
     scores[i++] = new ScoreLine("Yahtzee");        lowerPanel.add(scores[i-1]);
     scores[i++] = new ScoreLine("chance");         lowerPanel.add(scores[i-1]);
     scores[i++] = new ScoreLine("lower total");    lowerPanel.add(scores[i-1]);
     scores[i++] = new ScoreLine("grand total");    lowerPanel.add(scores[i-1]);
     
      
      setSize( new Dimension(500,500) );
      setVisible(true);
   }
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource()==rollAllButton && rollCount<3 )
      {
         for (int i=0; i<5; i++ ) { diceArray[i].roll(); }
         rollCount++;
      }
      repaint();
   }
}
