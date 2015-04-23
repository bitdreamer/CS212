// Board.java
// 2014 CS-212 

package twixt2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements MouseListener
{
   Peg[][] peg;
   int boardSize =24;
   int spacing;
   int xoffset = 15; // scoot the pegs this much from left edge
   int yoffset = 15; // scoot the pegs this much from top edge
   int whoseTurn; // 0 or 1, index of player in player array
   static Player[] player;
   int pegWidth = 10;
   boolean gameOver = false;
   
   public Board( int size )
   {
      boardSize = size; 
      pegWidth = 5 + 100 / boardSize;
      Peg.pegWidth = pegWidth;
      Link.pegWidth = pegWidth;
      whoseTurn = 0;
      
      setPreferredSize( new Dimension(500,500) );
      //setBackground( Color.yellow );
      Peg.theBoard = this; 
      Link.theBoard = this;
      
      spacing = 500 / boardSize;
      
      // declare array for pegs and fill with pegs 
      peg = new Peg[boardSize][boardSize];
      for ( int i=0; i<boardSize; i++ ) // i horizontal from left
      {
         for ( int j=0; j<boardSize; j++ ) // j vertical from top
         {
            peg[i][j] = new Peg( i, j );
         }
      }
      
      // go through the Pegs again and add all of the links
      for ( int i=0; i<boardSize; i++ ) // i horizontal from left
      {
         for ( int j=0; j<boardSize; j++ ) // j vertical from top
         {
            if(peg[i][j].showing) { peg[i][j].addLinks(); }
         }
      }
      
      
      addMouseListener(this);  // board listens to you click on pegs
   }
   
   public void mouseClicked( MouseEvent e )
   {
      int x = e.getX();
      int y = e.getY();
      
      int i = (x - xoffset/2) / spacing; // figures the array index from the pixels
      int j = (y - yoffset/2) / spacing;
      
      if ( 0<=i && i<boardSize && 0<=j && j<boardSize )
      {
         //System.out.println("Board.mouseClicked: whoseTurn="+whoseTurn);
         //System.out.println("Board.mouseClicked: player="+player);
         player[whoseTurn].play( i, j );
         //peg[i][j].owner = new Player();
         
      }  // stub
      
      repaint();
   }
   
   // when a Player object wants to make a move, it calls this method.
   public void play( Player p, int i, int j )
   {
      if ( gameOver ) { return; }
      if ( player[whoseTurn] == p && peg[i][j].owner==null )
      {
         if (   (player[whoseTurn].color == Color.RED && i>0 && i<boardSize-1 )
             || ( player[whoseTurn].color == Color.BLACK && j>0 && j<boardSize-1 )
            )
         {
            peg[i][j].owner = p;
            whoseTurn = (whoseTurn+1)%2;
            peg[i][j].connect();
         }
         
      }
      propogate();
      repaint();
   }
   
   // set win=true on all pegs connected to starting row that are owned
   public void propogate()
   {
      for ( int i=0; i<boardSize; i++ ) // i horizontal from left
      {
         for ( int j=0; j<boardSize; j++ ) // j vertical from top
         {
            peg[i][j].win=false;
         }
      }

      for ( int k=1; k<boardSize-1; k++ )
      {
         if ( peg[0][k].owner!=null ) { peg[0][k].prop(); }
         if ( peg[k][0].owner!=null ) { peg[k][0].prop(); }
      }
      
      // check for winner
      for ( int k=1; k<boardSize-1; k++ )
      {
         if ( !gameOver )
         {
            if ( peg[boardSize-1][k].win ) { JOptionPane.showMessageDialog(null,"black wins"); gameOver = true; }
            if ( peg[k][boardSize-1].win ) { JOptionPane.showMessageDialog(null,"red wins"); gameOver = true; }
         }
      }
   }
   
   
   public void mousePressed( MouseEvent e ) {}
   public void mouseReleased( MouseEvent e ) {}
   public void mouseEntered( MouseEvent e ) {}
   public void mouseExited( MouseEvent e ) {}
   
   
   @Override
   public void paintComponent( Graphics g )
   {
      super.paintComponent(g);
      
      for ( int i=0; i<boardSize; i++ ) // i horizontal from left
      {
         for ( int j=0; j<boardSize; j++ ) // j vertical from top
         {
            peg[i][j].drawMe(g);
         }
      }
      
      int barLength =  (boardSize-3)*spacing + pegWidth  ;
      
      g.setColor( Color.BLACK );
      g.fillRect( xoffset+spacing/2+3 , yoffset+spacing, pegWidth-4, barLength );
      g.fillRect( xoffset + (boardSize-2)*spacing + spacing/2 +3 , yoffset+spacing, pegWidth-4, barLength );
      
      g.setColor( Color.RED );
      g.fillRect( xoffset+spacing, yoffset+spacing/2 + 3, barLength, pegWidth-4); 
      g.fillRect( xoffset+spacing, xoffset+(boardSize-2)*spacing+spacing/2 + 3, barLength, pegWidth-4); 
      
               
      //g.fillRect( 50, 50, 5, 300 );
      
   }
   
   // access
   // return the peg with index ij
   // return null if no peg
   public Peg getPeg( int i, int j )
   {
      Peg p = null;
      
      if ( i>=0 && i<boardSize && j>=0 && j<boardSize )
      {
         p = peg[i][j];
         if ( !p.showing ) { p = null; }
      }
      
      return p;
   }
}
