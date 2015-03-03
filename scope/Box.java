// Box.java
// 2014 CS-212 

package scope;

import java.awt.*;

public class Box extends Shape
{
   //Point[] ends; is defined in Shape
   
   public Box( Point p1, Point p2 )
   {
      ends = new Point[2];
      
      ends[0] = p1; ends[1] = p2;
   }
   
   public void drawMe( Graphics g )
   {
     // g.drawLine( ends[0].getX(), ends[0].getY(), ends[1].getX(), ends[1].getY());
      
      int width = ends[1].x - ends[0].x; if (width<0) { width *= -1; }
      int height = ends[1].y - ends[0].y; if ( height<0 ) { height *= -1; }
      
      //g.drawRect( ends[0].x, ends[0].y, width, height );
      
      for ( int r=0; r<8; r++ )
      {
         g.drawRect( ends[0].getX(r),
                     ends[0].getY(r),
                     ends[1].getX(r), 
                     ends[1].getY(r)
                   );
         
      }
      
   }
}
