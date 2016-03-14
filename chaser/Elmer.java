// Elmer.java
// CS-212 2016 
// fox chases rabbits ...


package chaser;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Elmer extends JFrame implements ActionListener
{
   Rabbit[] pen;
   int penCount = 50;
   
   Timer clicky;
   double speed=10; // number of clicks per second

   public static void main( String[] args )
   {
      new Elmer();
   }
   
   public Elmer()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Elmer");
      setSize( 600,600 );
      Container c = getContentPane();
      c.setBackground( new Color(2,145,56) );
      
      pen = new Rabbit[penCount];
      for ( int i=0; i<penCount; i++ )
      {
         pen[i] = new Rabbit();
      }
      
      clicky = new Timer( (int)(1000/speed), this );
      clicky.start();
      
      setVisible(true);
   }
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource()==clicky ) { hop(); }
      repaint();
   }
   
   // tell all the rabbits to move
   public void hop()
   {
      for ( int i=0; i<penCount; i++ )
      {
         pen[i].move( 1/speed );
      }
   }
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      
      for ( int i=0; i<penCount; i++ )
      {
         pen[i].drawMe(g);
      }
      
   }
   
}
