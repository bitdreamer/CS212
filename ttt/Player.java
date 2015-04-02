// Player.java

// CS-212 2014

package ttt;

public class Player extends Thread
{
   String name; // what we call this player when it is their turn
   char letter; // the letter that this player is supposed to play
   int myIndex; // which one this is in the player array up in the main program
   static Board theBoard; // points to the board we are playing on
   Square clickedOn; // When a click on a square occurs, that info is put here for the player.
   
   // constructor.  You send it the letter that this player is playing.
   public Player( char letter1 )
   {
      letter = letter1;
      if ( letter=='x' ) { myIndex = 0; } 
      else { myIndex = 1; }
      
      name = "bob";
   }
   
   public void play()
   {
   }
   

}
