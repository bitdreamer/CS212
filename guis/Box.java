// Box.java

package guis;

import java.awt.*;

public class Box
{
   int x; // location of the upper left corner of the box relative 
   int y; // to the window (outer edge)
   Color color;
   
   // constructor
   // must give location of upper left corner of box
   public Box( int x1, int y1 )
   {
      x = x1;
      y = y1;
      
      color = new Color( (int)(Math.random()*255),
                         (int)(Math.random()*255),  
                         (int)(Math.random()*255)
                       );
   }
   /*
   public Box( int x, int y )
   {
      this.x = x;
      this.y = y;
   }
   */
   
   public void drawMe( Graphics g )
   {
      g.setColor( color );
      g.fillRect( x, y, 10, 10);
   }
   
   public void setColor( Color c ) { color = c; } 
   public Color getColor() { return color; }  

}
