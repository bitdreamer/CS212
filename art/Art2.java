// Art2.java
// Barrett Koster for CS-212 class 2013

package art;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Art2 extends JFrame
{
   public static void main( String[] args )
   {
      System.out.println("hi there.");
      new Art2();
   }
   
   // constructor
   public Art2()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      setSize( 500,500);
      setVisible( true);
   }
   
   public void paint( Graphics g )
   {
      super.paint(g);
      /*
      g.drawLine( 50, 50, 250, 100 );
      g.drawRect( 50, 150, 100, 30 );
      g.drawOval( 50, 150, 100, 30 );
      g.setColor( Color.pink );
      g.fillRect(200,200,50,50 );
      g.drawString("blah",300,300);
      */
      notebook(g);
      
   }
   
   // draw a fan shaped bunch of lines
   public void notebook(Graphics  g)
   {
      g.setColor( new Color(150,150,250) );
      for ( int y=100; y<500; y=y+20 )
      {
         //g.drawLine( 20, y, 480, y );
         int x = y;
         g.drawLine( x, 50, 480, y );
      }
   }
}
