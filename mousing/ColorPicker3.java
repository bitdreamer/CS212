// ColorPicker3.java
// Barrett Koster CS-212 class spring 2013
// This program creates a grid of colored boxes.  When the user clicks on one,
// that color is displayed off to the side.  Thus the boxes have to know where 
// they are and which color they are.

package mousing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class ColorPicker3 extends JFrame implements MouseListener
{
   Swatch b; // this is the special box out to the side that shows the
          // chosen color
   Swatch[][] boxes; // 2-d array of Box objects, form a color pallet
   
   public static void main( String[] args )
   {
      System.out.println("hi there.");
      new ColorPicker3();
   }
   
   // constructor.  creates a 20x20 grid of random colors
   // Also makes this object a MouseListener
   // Creates box b in lower right corner to display the chosen color.
   public ColorPicker3()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      addMouseListener(this);
      b = new Swatch( 450, 450  );
      
      // declare array and fill with 400 boxes
      boxes = new Swatch[20][20];
      for ( int i=0; i<20; i++ )
      {
         for ( int j=0; j<20; j++ )
         {
            boxes[i][j] = new Swatch(10+20*i, 40+20*j );
         }
      }
      
      
      setSize( 500,500);
      setVisible( true);
      
   }
   
   
   // When the mouse is clicked, save the color that was clicked on in
   // the box down to the right.
   public void mouseClicked( MouseEvent e )
   {
      System.out.println("click at x="+e.getX()+" y="+e.getY());
      
      // convert window coords to box array indexes.
      // These were adjusted slightly after the video was made
      // (no more flakiness, these are right on target).
      int boxi = (e.getX()-10)/20; // convert mouse x to box index
      int boxj = (e.getY()-40)/20;
      System.out.println("click at boxi="+boxi+" boxj="+boxj);
     
      // set extra box to the color that we clicked on
      //b.color = boxes[boxi][boxj].color;
      b.setColor( boxes[boxi][boxj].getColor() );
      repaint();
   }
   public void mouseEntered( MouseEvent e ) {}
   public void mousePressed( MouseEvent e ) {}
   public void mouseExited( MouseEvent e ) {}
   public void mouseReleased( MouseEvent e ) {}
   
   // draw the grid of boxes and also the picke one lower right
   public void paint( Graphics g )
   {
      super.paint(g);
      
      b.drawMe(g);
      for ( int i=0; i<20; i++ )
      {
         for ( int j=0; j<20; j++ )
         {
            boxes[i][j].drawMe(g);
         }
      }

   }
   
   // This method lets someone from outside access the chosen color.
   public Color getColor() { return b.color; }
}
