// TSquare.java

package ttt;

import java.awt.*;

public class TSquare extends Square
{
   boolean invisible = false;
   
   public TSquare( int i1, int j1 )
   {
      super(i1,j1);
      if      ( i1==0           && j1==0           ) { invisible = true; }
      else if ( i1==0           && j1==boardSize-1 ) { invisible = true; }
      else if ( i1==boardSize-1 && j1==0           ) { invisible = true; }
      else if ( i1==boardSize-1 && j1==boardSize-1 ) { invisible = true; }
   }

   @Override
   public void drawMe( Graphics g )
   {
      if ( !invisible )
      {
         g.setColor( Color.black );
         g.drawOval( x+size/2, y+size/2, 6, 6 );
      }
      
   }
}
