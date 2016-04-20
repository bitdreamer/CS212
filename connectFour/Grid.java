// Grid.java
// this is the array where all the pieces go.
// It's a 2D array of slots


package connectFour;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import java.io.*;

public class Grid extends JPanel implements MouseListener, MouseMotionListener,
   ActionListener
{
   Slot[][] theSlots; // 0,0 is lower left, 1,0 is to the right
                      // 0,1 is up one.
                      
   int columns = 7;
   int rows = 6;
   boolean whoseTurn=true; // true=black, false=red
   
   ConnectFour theGame;  
   
   int mouseX, mouseY; // mouse last seen at ... pixel from upper left
  // boolean gameOver = false;
   
   public Grid( ConnectFour tg)
   {
      theGame = tg; 
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
    
   @Override
   public void actionPerformed( ActionEvent e )
   {
      if      ( e.getSource()==theGame.saveButton ) { save(); }
      else if ( e.getSource()==theGame.loadButton ) { load(); }
   }

   // save the state of the game to a file
   // save format is ..
   // chip 2 3 red
   // where 2 is the column number, 3 is row, color is chip color
   // 
   public void save()
   {
      JFileChooser fc;
      fc = new JFileChooser();
      int result = fc.showSaveDialog(this);
      if( result==JFileChooser.APPROVE_OPTION )
      {
         File file = fc.getSelectedFile();
         try
         {
            FileWriter fw = new FileWriter( file );
            //fw.write("stub");
            
             for ( int i=0; i<columns; i++ )
		      {
		         for ( int j=0; j<rows; j++ )
		         {
		            String word = theSlots[i][j].getColorWord();
		            if ( !word.equals("") )
		            {
		               fw.write("chip "+i+" "+j+" "+word+"\n" );
		            }
		          
		         }
		      }

            fw.flush();
            fw.close();

         }
         catch (IOException e) { System.out.println("splat");  }
      }
   }
   
   // load the state of the game from a file
   public void load()
   {
      JFileChooser fc;
      fc = new JFileChooser();
      try
      {
         int result = fc.showOpenDialog(this);
         if ( result==JFileChooser.APPROVE_OPTION );
         {
            File file = fc.getSelectedFile();
            FileReader fr = new FileReader(file);
            BufferedReader bfr = new BufferedReader( fr );
            
            String line;
	        line = bfr.readLine();
            while (line!=null) // will run until EOF exception
            {
	            System.out.println("read:"+line);
	            // yeah, ok, DO something with the line ...
	            dealWith( line );
	            
	            line = bfr.readLine(); // ready for next loop    
            }
         }
      }
      catch ( EOFException e ) { System.out.println("end of file.  good?" ); }
      catch ( IOException e ) { System.out.println("load error?"+e); }
      catch ( Exception e   ) { System.out.println("other load error?"+e); }
   }
   
   // this processes a line from the load file
   public void dealWith( String line )
   {
      StringTokenizer st = new StringTokenizer( line );
      
      String cmd = st.nextToken();
      if ( cmd.equals("chip") )
      {
         int i = Integer.parseInt( st.nextToken() );
         int j = Integer.parseInt( st.nextToken() );
         String colorWord = st.nextToken();
         Color c = null;
         if      ( colorWord.equals("black") ) { c = Color.black; }
         else if ( colorWord.equals("red"  ) ) { c = Color.red; }
         
         theSlots[i][j].chip = c;
         whoseTurn = !whoseTurn;
      }
   }
   
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
