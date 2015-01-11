// Art5Flower.java
// Barrett Koster for CS-212 class 2013
// This draws a flower

package art;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Art6Gasket extends JFrame
{
   public static void main( String[] args )
   {
      System.out.println("hi there.");
      new Art6Gasket();
   }
   
   // constructor
   public Art6Gasket()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      setSize( 500,500);
      setVisible( true);
   }
   
   public void paint( Graphics g )
   {
      super.paint(g);

      // notebook(g);
      //colorGrid(g);
      // randomBoxes(g);
      //flower(g, 200, 200 );
      //flower(g,300,350);
      //fieldOfFlowers(g);
      // randomWalk(g);
      Gasket(g);
   }
   
   // draw a random walk of 1000 steps, each step 10 pixels or less.
   public void randomWalk(Graphics g)
   {   g.setColor( Color.black );
      
      int x = 250; // current position of walker
      int y = 250;
      int oldx = 250; // what x was last time
      int oldy = 250;
      
      for ( int i=0; i<100000; i++ )
      {
         g.drawLine( x,y,oldx,oldy);
         
         oldx = x; oldy = y;
         //x = x + (int)(Math.random()*10-5);
        // y = y + (int)(Math.random()*10-5);
         x = x + (int)(Math.random()*10-5);
         y = y + (int)(Math.random()*10-5);
      }
   }
   
   // draws a field of 30 randomly placed flowers
   public void fieldOfFlowers( Graphics g )
   {
      for ( int i=0; i<30; i++ )
      {
         int x = (int)(Math.random()*400);
         int y = (int)(Math.random()*400);
         flower(g,x,y);
      }
   }
   
   // draws a flower at coordinates centerX centerY (pixels from
   // upper left).  flower radius is 80 pixels.
   public void flower( Graphics g, int centerX, int centerY )
   {
      double radius = 80; 
      
      setRandomColor(g);
      
      for ( double angle=0; angle<6.28; angle += .25 )
      {
         double petalX = centerX + radius * Math.cos(angle);
         double petalY = centerY + radius * Math.sin(angle);
         double leadX  = centerX + 0.8*radius * Math.cos(angle+.2);
         double leadY  = centerY + 0.8*radius * Math.sin(angle+.2);

         // draw one petal as a polygon, in this case triangle
         int[] x = new int[3]; // array to hold x coords of points for polygon
         int[] y = new int[3]; // matching array for y of said points
         x[0] = (int) centerX; x[1] = (int) petalX; x[2] = (int) leadX;
         y[0] = (int) centerY; y[1] = (int) petalY; y[2] = (int) leadY;
         //g.setColor( Color.yellow );
         //setRandomColor(g);
         g.fillPolygon( x, y, 3);
      }
   }
   
   // randomBoxes will put a bunch of randomly sized boxes at
   // random places in the 500,500 window and with random colors.
   public void randomBoxes( Graphics g )
   {
      for ( int i=0; i<1000; i++ )
      {
         // set random color
         g.setColor( new Color(
               (int) (150 + Math.random()*100),
               (int) (150 + Math.random()*100),
               (int) (Math.random()*55) 
                              )
                   );
         g.fillRect(
               (int) (Math.random()*450),
               (int) (Math.random()*450),
               (int) (Math.random()*50),
               (int) (Math.random()*50)
                   );
      }
   }
   
   public void setRandomColor(Graphics g)
   {
      g.setColor( new Color(
            (int) (Math.random()*250),
            (int) (Math.random()*250),
            (int) (Math.random()*250) 
                           )
                );
   }
   
   // colorGrid draws a 2d array boxes of various colors
   public void colorGrid( Graphics g )
   {
      int y;
      for ( y=100; y<460; y = y + 40 )
      {
         oneRow( g, y );
      }
   }
   
   // oneRow draws a horizontal row of boxes 30x30 starting at 
   // x=100 and top of boxes is y (argument).  spacing is 10,
   // so 40 total from left corner to left corner
   public void oneRow( Graphics g, int y )
   {
      for ( int x=100; x<460; x = x+ 40 )
      {
         g.setColor(  new Color( x/2, y/2, 250 )  );
         g.fillRect( x, y, 30, 30 );
      }
   }
   
   public void notebook(Graphics  g)
   {
      g.setColor( new Color(150,150,250) );
      for ( int y=100; y<500; y=y+30 )
      {
         g.drawLine( 20, y, 480, y );
      }
   }
   


   public void Gasket( Graphics g )
   {
       int cornerX[], cornerY[];
       cornerX = new int[3]; cornerX[0] = 200; cornerX[1] = 50; cornerX[2] = 480;
       cornerY = new int[3]; cornerY[0] =  50; cornerY[1] =400; cornerY[2] = 450;
       
       g.drawLine( cornerX[0], cornerY[0], cornerX[1], cornerY[1] );
       g.drawLine( cornerX[2], cornerY[2], cornerX[1], cornerY[1] );
       g.drawLine( cornerX[0], cornerY[0], cornerX[2], cornerY[2] );
       
       double zX, zY; zX = 50; zY = 50;
       for ( int i=0; i<100000; i++ )
       {
           int red   = 78;  //(int) (Math.random()*255);
           int blue  = 211; //(int) (Math.random()*255);
           int green = 188; //(int) (Math.random()*255);
        
           g.setColor( new Color( red, green, blue ) );

           int which = (int) ( Math.floor(Math.random()*3) ); 
           //System.out.println(which);
           zX = 0.5 * ( zX + cornerX[which] );
           zY = 0.5 * ( zY + cornerY[which] );
           g.drawRect( (int)zX, (int)zY, 1, 1 );
       }
   }
}
