// Mousie2.java
// Barrett Koster CS-212 class spring 2013
// This class shows how to make an app respond to mouse DRAGGED events.
//  This need the MouseMotionListener

package mousing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Mousie2 extends JFrame implements MouseListener, MouseMotionListener
{
   int x=0, y=0; // last mouse location
   
   public static void main( String[] args )
   {
      System.out.println("hi there.");
      new Mousie2();
   }
   
   // constructor, add MouseListener and MouseMotionListener
   public Mousie2()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      addMouseListener(this);
      addMouseMotionListener(this);
      
      setSize( 500,500);
      setVisible( true);
      
   }
   
   // note position of mouse xy globally, when clicked
   public void mouseClicked( MouseEvent e )
   {
      x = e.getX(); y = e.getY();
      System.out.println("click at x="+x+" y="+y);
   }
   public void mouseEntered( MouseEvent e ) {}
   public void mousePressed( MouseEvent e ) {}
   public void mouseExited( MouseEvent e ) {}
   public void mouseReleased( MouseEvent e ) {}
   
   public void mouseMoved( MouseEvent e ) {}
   // note postion of mouse xy globally, when dragging
   public void mouseDragged( MouseEvent e )
   {
      x = e.getX(); y = e.getY();
      System.out.println("dragged to x="+x+" y="+y);
      repaint();
   }
        
   public void paint(Graphics g )
   {
      super.paint(g); // is no super.paint(), then lines stay on screen 
      g.drawLine(200,200, x, y );
   }
   
}
