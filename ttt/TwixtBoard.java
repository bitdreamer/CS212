// TwixtBoard.java
// 2015 CS-212


package ttt;

import java.awt.*;

public class TwixtBoard extends Board
{
   public TwixtBoard( int gridSize )
   {
      super(gridSize);
   }
   
   public Square makeSquare( int i, int j ) { return new TSquare(i,j); }
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      
      g.setColor( Color.red );
      g.fillRect( Square.size, Square.size, 5 , Square.size*(boardSize-2));
      g.fillRect( (boardSize-1)*Square.size, Square.size, 5 , Square.size*(boardSize-2));
      g.setColor( Color.black );
      g.fillRect( Square.size, Square.size,  Square.size*(boardSize-2), 5);
      g.fillRect( Square.size, (boardSize-1)*Square.size,  Square.size*(boardSize-2), 5);
   }
}
