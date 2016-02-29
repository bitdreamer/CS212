// Word.java
// CS-212 2016

// This is string on the window somewhere

package guis;

import java.awt.*;

public class Word
{
   int x; // pixels from upper left
   int y;
   String theString;
   Color color;
   
   // contructor
   public Word( int x1, int y1, String s, Color c )
   {
      x = x1;
      y = y1;
      theString = s;
      color = c;
   }
   
   public void drawMe( Graphics g )
   {
      g.setColor( color );
      g.drawString( theString, x, y );
   }
}
