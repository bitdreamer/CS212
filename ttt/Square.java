// Square.java

package ttt;

import java.awt.*;

public class Square
{
   static int boardSize; // grid size of board (like chess is 8, tic tac toe is 3)
   static int size; // size in pixels
   int ih, jv; // coordinate in grid of Board
   int x, y; // coordinates in pixels from upper left of panel
   char letter; // ' ', 'x', 'o' 
   
   // send it the indexes of it in the array of Squares.
   public Square( int ih1, int jv1  )
   {
      ih = ih1; 
      jv = jv1;
      x = ih * size;
      y = jv * size; 
      //if ( (ih+jv)%2==0 ) { letter = 'x'; }
      //else { letter = 'o'; }
      letter = ' ';
   }
   
   public void drawMe( Graphics g )
   {
      g.setColor( Color.black );
      g.drawRect( x, y, size, size );
      
      if ( letter == 'x' )
      {
         g.drawLine( x, y, x+size, y+size );
         g.drawLine( x+size, y, x, y+size );
      }
      else if ( letter == 'o' )
      {
         g.drawOval( x, y, size, size);
      }
      //g.drawString(""+letter, x+20, y+20 );
   }
}
