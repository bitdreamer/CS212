// StickyPenLine.java
// Barrett Koster CS-212 class spring 2013
// This class shows how to make an app listen for mouse clicks in the window.

package mousing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class StickyPenLine extends JFrame implements MouseListener
   , MouseMotionListener
{
   // attributes
   Random randy;
   int oldx, oldy; // last mouse coordinates
   Line[] lines;
   int lineCount;
   boolean inMiddle; // true when we are in the middle of drawing
                     // a line segment
   
   public static void main( String[] args )
   {
      System.out.println("hi there.");
      new StickyPenLine();
   }
   
   // constructor, add the MouseListener
   public StickyPenLine()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      randy = new Random();
      
      addMouseListener(this);
      addMouseMotionListener(this);
      lines = new Line[100];  
      lineCount = 0;
      inMiddle = false; // not in the middle of drawing a line yet
      
      setSize( 500,500);
      setVisible( true);
      
   }
   
   // when the mouse is clicked, print out the coordinates.
   public void mouseClicked( MouseEvent e )
   {
      System.out.println("click at x="+e.getX()+" y="+e.getY());
      
      int mx = e.getX(); int my = e.getY();
      
      if ( inMiddle ) // if we have one click already, this click 
                      // finishes the line segment
      {
         lines[lineCount++] = new Line( mx, my, oldx, oldy );
         
      }
      
      inMiddle = !inMiddle; // 
      oldx = mx; oldy = my; // new coords become the old ones
      
      repaint();
   }
   public void mouseEntered( MouseEvent e ) {}
   public void mouseExited( MouseEvent e ) {}

   // mousePressed - should start a snapline
   public void mousePressed( MouseEvent e )
   {
      oldx = e.getX();  oldy = e.getY();
      lines[lineCount++] = new Line( oldx, oldy, oldx, oldy );
      
      repaint();
   }
   public void mouseReleased( MouseEvent e )
   {
   }
   
   // 
   public void mouseDragged( MouseEvent e )
   {
      int mx = e.getX(); int my = e.getY();
      lines[lineCount-1].bx = mx; // + randy.nextInt(20);
      lines[lineCount-1].by = my; // + randy.nextInt(20);
      
      repaint();
   }
   public void mouseMoved( MouseEvent e ) {}
   
   public void paint( Graphics g )
   {
      super.paint(g);
      
      for ( int i=0; i<lineCount; i++ )
      {
         lines[i].drawMe(g);
      }
   }
}
