// Mousie2.java
// Barrett Koster CS-212 class spring 2013
// This program shows how to handle various events, mouse clicked,
// mouse dragged, and key clicked.  

package mousing;

import java.awt.event.*;
import javax.swing.JFrame;

public class KeyThingy extends JFrame implements MouseListener, MouseMotionListener
  , KeyListener
{
   public static void main( String[] args )
   {
      System.out.println("hi there.");
      new KeyThingy();
   }
   
   // constructor ... add the various listeners
   public KeyThingy()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      addMouseListener(this);
      addMouseMotionListener(this);
      
      addKeyListener(this);
      
      setSize( 500,500);
      setVisible( true);
      
   }
   
   // minimal responses to various events.
   public void keyPressed( KeyEvent e ) { }
   public void keyReleased( KeyEvent e ) {}
   public void keyTyped( KeyEvent e) { System.out.println("key:"+e.getKeyChar());}
   
   public void mouseClicked( MouseEvent e )
   {
      System.out.println("click at x="+e.getX()+" y="+e.getY());
   }
   public void mouseEntered( MouseEvent e ) {}
   public void mousePressed( MouseEvent e ) {}
   public void mouseExited( MouseEvent e ) {}
   public void mouseReleased( MouseEvent e ) {}
   
   public void mouseMoved( MouseEvent e ) {}
   public void mouseDragged( MouseEvent e )
   {
      System.out.println("dragged to x="+e.getX()+" y="+e.getY());
   }
         
   
}
