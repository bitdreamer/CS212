// Kal.java
// Barrett Koster CS-212 class spring 2014
// This class shows how to make an app respond to mouse DRAGGED events.
//  We are adding kaleidescope lines

package scope;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Kal extends JFrame implements MouseListener, MouseMotionListener,
   ActionListener
{
   int x=0, y=0; // last mouse location
   int pressx, pressy; // coords where the mouse is pressed
   Line theLine;
   JButton boxButton; // press this to put program in box-drawing mode
   int mode = 0; // 0=line, 1=box, 2=ovals ..... 
   Box theBox;
   Shape theShape;
   ColorPicker3 theColorPicker;
   
   Shape[] allTheShapes; // this will hold everything on the window
   int allTheShapesCount = 0; // number of things in above array
   
   public static void main( String[] args )
   {
      System.out.println("hi there.");
      new Kal();
   }
   
   // constructor, add MouseListener and MouseMotionListener
   public Kal()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      setLayout( new FlowLayout() );
      
      allTheShapes = new Shape[1000];
      
      boxButton = new JButton("box");
      add(boxButton);
      boxButton.addActionListener(this);
      
      addMouseListener(this);
      addMouseMotionListener(this);
      
      setSize( 500,500);
      setVisible( true);
      
      theColorPicker = new ColorPicker3();
      
   }
   
   // note position of mouse xy globally, when clicked
   public void mouseClicked( MouseEvent e )
   {
      x = e.getX(); y = e.getY();
      System.out.println("click at x="+x+" y="+y);
      repaint();
   }
   public void mouseEntered( MouseEvent e ) {}
   
   // record where the mouse gets pressed
   public void mousePressed( MouseEvent e )
   {
      x = pressx = e.getX(); y = pressy = e.getY();
      
      Point p0 = new Point( x, y );
      Point p1 = new Point( pressx, pressy );
      
      if      ( mode==0 ) { theShape = theLine = new Line( p0, p1 ); }
      else if ( mode==1 ) { theShape = theBox = new Box( p0, p1 ); }
      
      allTheShapes[ allTheShapesCount++ ] = theShape;
      
      theShape.color = theColorPicker.b.color;
   }
   public void mouseExited( MouseEvent e ) {}
   public void mouseReleased( MouseEvent e )
   {
      /*
      Point p0 = new Point( x, y );
      Point p1 = new Point( pressx, pressy );
      
      theLine = new Line( p0, p1 );
      repaint();
      */
   }
   
   public void mouseMoved( MouseEvent e ) {}
   // note postion of mouse xy globally, when dragging
   public void mouseDragged( MouseEvent e )
   {
      x = e.getX(); y = e.getY();
      
      theShape.ends[0].x = x;
      theShape.ends[0].y = y;
      /*
      if ( mode==0 ) // Line
      {
         theLine.ends[0].x = x; 
         theLine.ends[0].y = y; 
      }
      else if ( mode==1 ) // Box
      {
         theBox.ends[0].x = x;
         theBox.ends[0].y = y;
      }
      */
      
      System.out.println("dragged to x="+x+" y="+y);
      repaint();
   }
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource()==boxButton ) { mode = 1; }
   }
        
   // draw all the shapes on the list
   public void paint(Graphics g )
   {
      super.paint(g); // is no super.paint(), then lines stay on screen 
      
      for ( int i=0; i<allTheShapesCount; i++ )
      {
         allTheShapes[ i ] . drawMe(g);
      }
   }
}
