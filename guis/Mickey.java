// Mickey.java
// 2016 CS-212

package guis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mickey extends JFrame implements MouseListener
{
   int mouseX; // last place mouse was clicked
   int mouseY; // in pixels from upper left of outer edge of window
   
   Box[] boxes; // array of boxes
   int boxCount = 0;
   
   public static void main ( String [] args )
   {
      new Mickey();
   }
   
   // constructor
   public Mickey()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Mickey");
      
      boxes = new Box[100];
      addMouseListener(this);
      
      setSize( 500,500 );
      setVisible(true);
   }

	@Override public void mouseClicked( MouseEvent m)
	{
	   mouseX = m.getX(); // in pixels from upper left of outer edge of window
	   mouseY = m.getY();

	   boxes[boxCount++] = new Box( mouseX, mouseY );
	   
	   //System.out.println("x="+mouseX+" y="+mouseY);
	   repaint();
	}
	@Override public void mouseEntered( MouseEvent m) {}
	@Override public void mouseExited(  MouseEvent m ) {}
	@Override public void mousePressed( MouseEvent m ) {}
	@Override public void mouseReleased(MouseEvent m) {}
   
    @Override
    public void paint( Graphics g )
    {
       super.paint(g);
       
       //g.drawRect( mouseX, mouseY, 5, 5 );
       //b.drawMe(g);
       
       for ( int i=0; i<boxCount; i++ )
       {
          boxes[i].drawMe(g);
       }
    }
}
