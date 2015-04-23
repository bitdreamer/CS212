package twixt2;

import java.awt.*;

public class Player extends Thread
{
   Color color;
   static Board theBoard;
   String name;
   int myIndex; // which one I am in the Board.player array
   
   public Player( int me, Color c )
   {
      color = c;
      myIndex = me;
   }
   
   // call this method when you want this player to play 
   // 
   public void play( int i, int j )
   {
      System.out.println("Player.play: this should never get called.");
   }
}
