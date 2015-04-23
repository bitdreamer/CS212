package twixt2;

import java.awt.*;

public class Computer extends Player
{
   public Computer( int me, Color letter1 )
   {
      super(me,letter1);
      name = "number5";
      System.out.println("Computer: ="+myIndex);
      
      // start();
   }
   
   
   // you can't tell the computer where to play
   public void play( int i, int j )
   {}
   
   @Override
   public void run()
   {
      // constantly check to see if it's your turn, play if so
      while ( true )
      {
         //System.out.println("Computer.run: player "+myIndex+"trying to play, whoseTurn="+theBoard.whoseTurn);
         if ( theBoard.whoseTurn == myIndex ) // my turn
         {
            int i = (int)( Math.random()*theBoard.boardSize );
            int j = (int)( Math.random()*theBoard.boardSize );
            
            theBoard.play( this, i, j );
         }
         try { sleep(1000); } catch ( Exception e ) { System.out.println("insomnia"); }
      }
   }
}
