package mousing;

import java.awt.*;

public class Line
{
   int ax, ay, bx, by; // xy for two end points


   public Line( int x1, int y1, int x2, int y2 )
   {
      ax = x1; ay = y1; bx = x2; by = y2;
   }
   
   public void drawMe( Graphics g )
   {
      g.setColor( Color.black );
      g.drawLine( ax, ay, bx, by ); // drag line / snap line
      //g.drawLine( ay, ax, bx, by ) ; // first two coord switched
      
      String s = "wefiwjeofijwefo";
      int x = s.length();
   }
}
