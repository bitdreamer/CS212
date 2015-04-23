package twixt2;

import java.awt.*;

public class Human extends Player
{
   public Human( int me, Color c )
   {
      super(me, c);
   }
   public void play( int i, int j )
   {
      
      //theBoard.peg[i][j].owner = this;
      theBoard.play( this, i, j );
   }
}
