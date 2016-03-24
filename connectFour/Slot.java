// Slot.java
// CS-212 2016
// a place to play a chip (whether or not we actually
// have a Chip class.

package connectFour;

import java.awt.*;

public class Slot
{
   static int size = 50; // width and height of slot in pixels
   int x,y; // indexes in the array of THIS slot
   
   public Slot( int x1, int y1 )
   {
      x = x1; y = y1;
   }

   public void drawMe( Graphics g )
   {
      
   }
}
