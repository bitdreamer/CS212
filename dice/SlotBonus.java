package dice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SlotBonus extends Slot
{
   public SlotBonus()
   {
      super("bonus");
      used = true;
   }
   
   /*
   @Override
   public void actionPerformed( ActionEvent e )
   {
      score = computeScore();
      theScoreField.setText(""+score);
   }
   */
   
   // add up slots 0 - 5 and put 35 here IFF sum is >= 63
   @Override
   public int computeScore()
   {
      int sum = 0;
      for ( int i=0; i<6; i++ )
      {
         sum += theYahtzee.slots[i].score;
      }
      if ( sum >= 63 ) { score = 35; }
      else { score = 0; }
      theScoreField.setText(""+score);
      
      return score;
   }
}
