// Snappy.java

package guis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Snappy extends JFrame 
   implements MouseListener, MouseMotionListener
{
   // attributes
   int downX, downY; // where the mouse is when button is pressed
   int mouseX, mouseY; // mouse last seen at
   int upX, upY; // where mouse is when button is released

   public static void main ( String [] args )
   {
      new Snappy();
   }
   
   // constructor
   public Snappy()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("SnapLines");
      
      addMouseListener(this);
      addMouseMotionListener(this);
      
      setSize(500,500);
      setVisible(true);
   }
   
   @Override public void mouseEntered ( MouseEvent m ) {}
   @Override public void mouseExited  ( MouseEvent m ) {}
   
   // record position of mouse when mouse button is pressed
   @Override public void mousePressed ( MouseEvent m )
   {
      mouseX = downX = m.getX(); 
      mouseY = downY = m.getY();
      repaint();
   }
   @Override public void mouseReleased( MouseEvent m )
   {
      mouseX = upX = m.getX();
      mouseY = upY = m.getY();
      repaint();
   }
   @Override public void mouseClicked ( MouseEvent m ) {}
   
   // when the mouse is dragged, update the mouseXY position
   @Override public void mouseDragged ( MouseEvent m )
   {
      mouseX = m.getX();
      mouseY = m.getY();
      repaint();
   }
   
   @Override public void mouseMoved   ( MouseEvent m ) {}
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      //g.drawLine( downX, downY, upX, upY );
      
      g.drawLine( downX, downY, mouseX, mouseY );
      //g.drawLine( downY, downX, mouseY, mouseX );
      g.drawLine( 500-downX, downY, 500-mouseX, mouseY );
      g.drawLine( downX, 500-downY, mouseX, 500-mouseY );
      g.drawLine( 500-downX, 500-downY, 500-mouseX, 500-mouseY );
      
      
      int boxWidth = Math.abs( mouseX-downX);
      int boxHeight = Math.abs( mouseY-downY );
      int boxX = (downX<mouseX)? downX : mouseX ;
      int boxY = (downY<mouseY)? downY : mouseY ;
      //int z = Math.min( downY, mouseY );
      
      //g.drawRect( boxX, boxY, boxWidth, boxHeight );
      
      
      
   }
}
