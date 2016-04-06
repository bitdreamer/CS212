// Grid.java
// this is the array where all the pieces go.
// It's a 2D array of slots


package connectFour;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Grid extends JPanel implements MouseListener, MouseMotionListener
{
   Slot[][] theSlots; // 0,0 is lower left, 1,0 is to the right
                      // 0,1 is up one.
                      
   int columns = 7;
   int rows = 6;
   boolean whoseTurn=true; // true=black, false=red
   
   int mouseX, mouseY; // mouse last seen at ... pixel from upper left
  // boolean gameOver = false;
   
   public Grid()
   {
      setBackground( new Color(255,250,150) );
      setPreferredSize( new Dimension(800,600) );
      reset();      
      addMouseListener(this);
      addMouseMotionListener(this);
   }
   
   // ready to start game, new empty slots
   public void reset()
   {
      theSlots = new Slot[columns][rows];
      
      for ( int i=0; i<columns; i++ )
      {
         for ( int j=0; j<rows; j++ )
         {
            theSlots[i][j] = new Slot(i,j);
         }
      }

   }
   
   // returns color if winner, else returns null
   public Color win(  )
   {
      boolean redwin = winH( Color.red );     
      boolean blackwin = winH(Color.black);


      
      if ( redwin ) { return Color.red; }
      if ( blackwin ) { return Color.black; }
      return null;
   }
   
   // check for winH, winV, winD1, winD2 on this color
   public boolean win( Color c )
   {
      return false;
   }
   
   // return true iff color c is a horizontal winner 
   // (any starting position)
   public boolean winH( Color c )
   {
      boolean win = false; 
      
      for ( int i=0; i<columns-3; i++ )
      {
         for ( int j=0; j<rows; j++ )
         {
            win |= winH( i, j, c );
         }
      }
      return win;
   }
   
   // return true iff there's 4 in a row horizontally from
   // position, and c is the color of the winner.
   public boolean winH( int i, int j, Color c )
   {
      return
         (    theSlots[i  ][j].chip == c
           && theSlots[i+1][j].chip == c 
           && theSlots[i+2][j].chip == c 
           && theSlots[i+3][j].chip == c 
         );
   }
   
      
    public void mouseClicked( MouseEvent m )
    {
       int x = m.getX();
       int y = m.getY();
       
       Slot found = null;
      for ( int i=0; i<columns; i++ )
      {
         for ( int j=0; j<rows; j++ )
         {
            if ( theSlots[i][j].zatYou(x,y) ) { found = theSlots[i][j]; }
         }
      }
      
      if (found!=null)
      {  
         if (    found.chip==null
              && (found.j==0 || theSlots[found.i][found.j-1].chip!=null) 
            )
         {
	         System.out.println("clicked on slot i="+found.i+" j="+found.j);  
	      
	         found.chip = (whoseTurn)? Color.black : Color.red ;
	         
	         Color winner = win();
	         if ( winner!=null )
	         {
	            System.out.println("winner="+winner);
	            //gameOver = true;
	            JOptionPane.showMessageDialog(null,"game over");
	            reset();
	         }
	         
	         whoseTurn = !whoseTurn;
         }
      }
      repaint();
    }
	public void mousePressed( MouseEvent m ) {}
	public void mouseReleased( MouseEvent m ) {}
	public void mouseEntered( MouseEvent m ) {}
	public void mouseExited( MouseEvent m ) {}
	
    public void mouseMoved  ( MouseEvent m ) 
    {
       mouseX = m.getX(); mouseY = m.getY();
       repaint();
    }
    public void mouseDragged( MouseEvent m ) {}

   
   // draws the grid
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      
      //System.out.println("Grid.paint: entering ...");
      for ( int i=0; i<columns; i++ )
      {
         for ( int j=0; j<rows; j++ )
         {
            theSlots[i][j].drawMe(g);
         }
      }
      //if ( !gameOver )
      {
      if ( whoseTurn ) { g.setColor( Color.black ); } 
      else             { g.setColor( Color.red   ); }
     
      g.fillOval( mouseX-Slot.size/2, mouseY-Slot.size/2, Slot.size-9, Slot.size-9 );
      }
   }
}
