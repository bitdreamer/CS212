// City.java 

package art;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class City extends JFrame
{
   int buildingCount = 50 ; // number of building in my city
   Random randy;
   
   public static void main ( String[] args )
   {
      new City();
   }
   
   public City()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE);
      setTitle("City");
      
      randy = new Random();
   
      setSize( new Dimension(900,600) );
      setVisible(true);
   }
   
   public void paint( Graphics g )
   {
      super.paint(g);
      
      g.setColor( Color.black ); // set the night sky
      g.fillRect(0,0,900,600);
      
      for ( int i=0; i<buildingCount; i++ )
      {
         building(g);
      }
   }
   
   // draws one building on the window 
   // (do a night scene, so ... bunch of squares in a grid, like
   // windows at night)
   public void building(Graphics g )
   {
      int cornerx, cornery; // top left corner of building in pixels from upper left
      int glassWidth, glassHeight; // one little lit up rectangle
      int buildingWidth, buildingHeight; // for the grid of lit up windows
      
      glassWidth = randy.nextInt(10) + 5 ;
      glassHeight = glassWidth + randy.nextInt(5) ; // always taller than wide
      buildingWidth = randy.nextInt(100)+50;
      buildingHeight = randy.nextInt( 500) +75;
      
      cornerx = randy.nextInt(800);
      cornery = getHeight() - buildingHeight;  
      
      // black background, then one color for whole building
      g.setColor( Color.black );
      g.fillRect( cornerx-5, cornery-5, buildingWidth+5, buildingHeight+5 );
      g.setColor( new Color( 150 + randy.nextInt(100), 
                     150 + randy.nextInt(100),
                     100 + randy.nextInt(100)
                   ) 
        );

            
      // we draw windows at wx wy.  they go width of the building (but not
      // hanging off the edge of the building) and spacing is twice the
      // window width
      int wx, wy; // corner of each window
      int windowHeight = getHeight();
      for ( wx = cornerx; wx < cornerx + buildingWidth - glassWidth; wx += 2 * glassWidth )
      {
         // draws one verticle column of windows (colored boxes)
         for ( wy = cornery; wy< windowHeight - glassHeight; wy += 2 * glassHeight )
         {
            g.fillRect( wx, wy, glassWidth, glassHeight);
         }
      }
   }
   
}
