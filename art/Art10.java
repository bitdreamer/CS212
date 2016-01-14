
// Art10.java
// CS-212 class 2016

package art;

import java.awt.*;
import javax.swing.*;

public class Art10 extends JFrame
{
   public static void main( String [] args )
   {
      System.out.println("Hi!");
      Art10 george = new Art10();
      // george.demoStuff( g ); 
   }
   
   // constructor
   public Art10()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      setTitle("Art10");
      
      setSize( 500,500 );
      setVisible( true );
      
      
   }
   
   @Override
   public void paint( Graphics g ) 
   {
      super.paint( g ); 
      demoStuff(g);
      
      
   }
   
   // bunch of primitive stuff from class 
   public void demoStuff( Graphics g )
   {
      g.drawLine( 100,100, 200, 300 );
      
      g.setColor( Color.green  );
      g.fillRect( 100,200, 100, 50 );
      
      g.setColor( new Color( 200, 57, 210 ) );
      g.fillRect( 300,300, 100, 100);
      
      g.setFont( new Font("TimesRoman",Font.PLAIN, 30) );
      g.drawString("amazing", 300, 100);
      
      g.drawOval(250, 50, 50, 100 ); 
      Shape sh = g.getClip();
      System.out.println("clip:"+sh);
      
      int[] xvals = new int[] { 3,6,9 };
   }
}
