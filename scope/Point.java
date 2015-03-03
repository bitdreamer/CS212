// Point.java
// Barrett Koster
// represents a point in 3 space


package scope;

import java.awt.*;

public class Point
{
   int x,y; // coordinates in pixels from upper left
   
   public Point( int x1, int y1 )
   {
      x = x1; y = y1;
   }
   
   public void drawMe( Graphics g )
   {
      g.drawOval(x,y,2,2);
   }
   
   // access
   public int getX() { return x; } 
   public int getY() { return y; }
   
   // r is the reflection number 
   public int getX( int r )
   {
      if      ( r == 0 ) { return x; }
      else if ( r == 1 ) { return x; } 
      else if ( r == 2 ) { return 500-x; } 
      else if ( r == 3 ) { return 500-x; } 
      else if ( r == 4 ) { return y; } 
      else if ( r == 5 ) { return 500-y; } 
      else if ( r == 6 ) { return y; } 
      else if ( r == 7 ) { return 500-y; } 
      else { return 0; }
   }
   
   // r is the reflection number 
   public int getY( int r )
   {
      if      ( r == 0 ) { return y; }
      else if ( r == 1 ) { return 500-y; } 
      else if ( r == 2 ) { return y; } 
      else if ( r == 3 ) { return 500-y; } 
      else if ( r == 4 ) { return x; } 
      else if ( r == 5 ) { return 500-x; } 
      else if ( r == 6 ) { return 500-x; } 
      else if ( r == 7 ) { return x; } 
      else { return 0; }
   }
}
