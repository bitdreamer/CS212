package ttt;

import javax.swing.*;

public class Human extends Player
{
   
   public Human( char letter1 )
   {
      super(letter1);
      name = JOptionPane.showInputDialog
            ( "Como te llamas? the person who plays "+letter+":" );
      System.out.println("Human: ="+myIndex);
   }
   
   // If there is a click in board, it sets the value of 
   // Square clickedOn and then calls play.  Presumably, we want
   // this player to play on that squre.
   public void play()
   {
      if (clickedOn!=null)
      {
         if ( clickedOn.letter == ' ' )
         {
            theBoard.play( clickedOn.ih, clickedOn.jv, letter );
         }
      }
   }
}
