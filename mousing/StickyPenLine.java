// StickyPenLine.java
// Barrett Koster CS-212 class spring 2013
// This class shows how to make an app listen for mouse clicks in the window.

package mousing;

import java.awt.event.*;
import javax.swing.JFrame;

public class StickyPenLine extends JFrame implements MouseListener
{
   public static void main( String[] args )
   {
      System.out.println("hi there.");
      new StickyPenLine();
   }
   
   // constructor, add the MouseListener
   public StickyPenLine()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      addMouseListener(this);
      
      setSize( 500,500);
      setVisible( true);
      
   }
   
   // when the mouse is clicked, print out the coordinates.
   public void mouseClicked( MouseEvent e )
   {
      System.out.println("click at x="+e.getX()+" y="+e.getY());
   }
   public void mouseEntered( MouseEvent e ) {}
   public void mousePressed( MouseEvent e ) {}
   public void mouseExited( MouseEvent e ) {}
   public void mouseReleased( MouseEvent e ) {}
   
}
