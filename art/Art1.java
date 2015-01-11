// Art1.java
// Barrett Koster for CS-212 class 2013

package art;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Art1 extends JFrame
{
   public static void main( String[] args )
   {
      System.out.println("hi there.");
      new Art1();
   }
   
   // constructor
   public Art1()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      System.out.println("mod check "+((-1)%8));
      
      setSize( 500,500);
      setVisible( true);
   }
   
   public void paint( Graphics g )
   {
      super.paint(g);
      
      g.drawLine( 50, 50, 250, 100 );
      g.drawRect( 50, 150, 100, 30 );
      g.drawOval( 50, 150, 100, 300 );
      g.setColor( Color.pink );
      g.fillRect(200,200,50,50 );
      g.drawString("blah",300,300);
      
   }
}
