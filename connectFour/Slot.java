// Slot.java
// CS-212 2016
// a place to play a chip (whether or not we actually
// have a Chip class.

package connectFour;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Slot 
{
   static int size = 80; // width and height of slot in pixels
   int i,j; // indexes in the array of THIS slot
   int xpix, ypix; // upper left corner of box in window
   Color chip = null; // this is what is in this slot, starts null
                      // gets Color.red or Color.blue
   
   public Slot( int x1, int y1 )
   {
      //System.out.println("Slot: x="+x1+" y="+y1);
      i = x1; j = y1;
      
      xpix = 115 + size*i; 
      ypix = 450 - size*j;
      
      //addMouseListener(this);
   }
   
   // returns true iff xmouse,ymouse is in bounds for this Slot
   public boolean zatYou( int xmouse, int ymouse )
   {
      return (   xpix+5<xmouse && xmouse<xpix+size-7
              && ypix+5<ymouse && ymouse<ypix+size-7
             );
   }

   // draws outline of slot
   public void drawMe( Graphics g )
   {
      //System.out.println("Slot.drawMe: x="+i+" y="+j);
      g.setColor( Color.black );
      g.drawRect( xpix, ypix, size-5, size-5 );
      
      if ( chip!=null )
      {
         g.setColor( chip );
         g.fillOval( xpix+2, ypix+2, size-8, size-8 );
      }
   }
   
   // returns "red", "black" or ""
   public String getColorWord()
   {
      if ( chip==null ) { return ""; }
      else
      {
	      if      ( chip.equals(Color.red)   ) { return "red"; }
	      else if ( chip==Color.black )        { return "black"; }
	      else {return ""; }
      }
   }
}
