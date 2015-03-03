// Line.java
// 2014 CS-212 

package scope;

import java.awt.*;

public class Line extends Shape
{
   //Point[] ends;
   
   public Line( Point p1, Point p2 )
   {
      ends = new Point[2];
      
      ends[0] = p1; ends[1] = p2;
   }
   
   @Override
   public void drawMe( Graphics g )
   {
     // g.drawLine( ends[0].getX(), ends[0].getY(), ends[1].getX(), ends[1].getY());
      
      for ( int r=0; r<8; r++ )
      {
         g.drawLine( ends[0].getX(r),
                     ends[0].getY(r),
                     ends[1].getX(r), 
                     ends[1].getY(r)
                   );
         
      }
   }
}
