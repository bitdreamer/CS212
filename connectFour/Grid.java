// Grid.java
// this is the array where all the pieces go.
// It's a 2D array of slots


package connectFour;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Grid extends JPanel
{
   Slot[][] theSlots; // 0,0 is lower left, 1,0 is to the right
                      // 0,1 is up one.
                      
   int columns = 7;
   int rows = 6;
   
   public Grid()
   {
      theSlots = new Slot[columns][rows];
      
      for ( int x=0; x<columns; x++ )
      {
         for ( int y=0; y<rows; y++ )
         {
            theSlots[x][y] = new Slot(x,y);
         }
      }
   }
   
   // draws the grid
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      for ( int x=0; x<columns; x++ )
      {
         for ( int y=0; y<rows; y++ )
         {
            theSlots[x][y].drawMe(g);
         }
      }
   }
}
