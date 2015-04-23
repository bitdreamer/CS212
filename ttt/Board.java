// Board.java
// CS-212 2014

package ttt;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Board extends JPanel implements MouseListener
{
   Square[][] cell; // cell[i][j] is numbered from upper left, i horiz, j vertical
   int boardSize; // length of edge of board, board is square
   int whoseTurn = 0; // which player's turn it is
   Player[] player;
   
   public Board( int boardSize1 )
   {
      Player.theBoard = this;
      boardSize = boardSize1;
      Square.boardSize = boardSize;
      
      setBackground( Color.pink );
      setPreferredSize( new Dimension(400,400) );
      
      cell = new Square[boardSize][boardSize];
      Square.size = 400 / boardSize;
      for ( int i=0; i<boardSize; i++ )
      {
         for ( int j=0; j<boardSize; j++ )
         {
            cell[i][j] = makeSquare(i,j);; 
         }
      }
      
      addMouseListener(this);
   }

   public Square makeSquare( int i, int j ) { return new Square(i,j); }
   
   public void mouseClicked( MouseEvent e )
   {
      int x = e.getX(); int y = e.getY();
      System.out.println("mouseClicked: x="+x+" y="+y);
      
      int i = x / Square.size;
      int j = y / Square.size;
      
      System.out.println("Board.mouseClicked: whoseTurn="+whoseTurn);
      player[whoseTurn].clickedOn = cell[i][j];
      player[whoseTurn].play( );
      
      
      //whoseTurn = (whoseTurn + 1) % 2;
      
      //validate();
      repaint();
   }
   public void mousePressed( MouseEvent e ) {}
   public void mouseReleased( MouseEvent e ) {}
   public void mouseEntered( MouseEvent e ) {}
   public void mouseExited( MouseEvent e ) {}
   
   // put letter into cell[i][j]
   public void play( int i, int j, char letter )
   {
      System.out.println("Board.play: whoseTurn="+whoseTurn+" i="+i+" j="+j+" letter="+letter );
      if ( cell[i][j].letter==' ' )
      {
         cell[i][j].letter = letter;
         doState();
         whoseTurn = (whoseTurn+1)%2;
         validate();
         repaint();
      }
      System.out.println("Board.play: leaving with whoseTurn="+whoseTurn);
   }
   
   // find out the state of the game and do the right thing declare winner
   // or draw if ... 
   public void doState()
   {
      char s = stateOfGame();
      if ( s==player[0].letter ) { JOptionPane.showMessageDialog(null,"player[0].name wins."); }
      if ( s==player[1].letter ) { JOptionPane.showMessageDialog(null,"player[1].name wins."); }
      if ( s=='d' ) { JOptionPane.showMessageDialog(null,"It's a draw."); }
      
      if ( s!=' ' ) { player[0].stop();      player[1].stop(); }
      validate();
      repaint();
   }
   
   
   // returns true iff there is an open space to play left on the board
   public boolean openSpace()
   {
     boolean opens = false;
     
     for( int i=0; i<boardSize; i++ )
     {
        for( int j=0; j<boardSize; j++ )
        {
           if ( cell[i][j].letter==' ' ) { opens = true; }
        }
     }

     return opens;
   }
   
   // return an open space (chosen randomly from the ones left)
   public Square getOpenSpace()
   {
     Square m=null;
     if ( openSpace() )
     {
        while( m==null )
        {
           int i = (int)(Math.random()*3);
           int j = (int)(Math.random()*3);
           if ( cell[i][j].letter==' ' ) { m = cell[i][j]; }
        }
     }
     
     return m;
   }
   
   // stateOfGame returns ' ' if game still in progress, letter of winning player if
   // somebody wins, 'd' if game is a draw (over without winner).
   public char stateOfGame()
   {
     char state=' ';
     
     char c;
     if ( win( c=player[0].letter ) )
     { JOptionPane.showMessageDialog(null,""+c+" wins!"); state = c; }
     else if ( win( c=player[1].letter ) )
     { JOptionPane.showMessageDialog(null,""+c+" wins!"); state = c; }
     else if ( !openSpace() )
     { JOptionPane.showMessageDialog(null,"draw"); state = 'd'; }
     
     return state;
   }
   
   // returns true if w has won 
   public boolean win( char w )
   {
     boolean won = false; // becomes true if w won the game, assume false unless we find
                          // a winning row (or whatever)
     
     // first go through the rows and look for a win
     for ( int i=0; !won && i<boardSize; i++ )
     {
        // if row[i] is a win for w, set won=true
        boolean rowwon=true; // assume win until we hit a non-w square
        for ( int j=0; rowwon && j<boardSize; j++ )
        {
           if ( cell[i][j].letter != w ) { rowwon = false; }
        }
        if ( rowwon ) { won = true; }
     }
     
     // go through the columns and look for a win
     for ( int j=0; !won && j<boardSize; j++ )
     {
        // if row[i] is a win for w, set won=true
        boolean colwon=true; // assume win until we hit a non-w square
        for ( int i=0; colwon && i<boardSize; i++ )
        {
           if ( cell[i][j].letter != w ) { colwon = false; }
        }
        if ( colwon ) { won = true; }
     }
     
     // check the diagonals
     boolean diag1 = true;
     boolean diag2 = true;
     for ( int i=0; i<boardSize; i++ )
     {
        if ( cell[i][i           ].letter != w ) { diag1 = false; }
        if ( cell[i][boardSize-i-1].letter != w ) { diag2 = false; }
     }
     if ( diag1 || diag2 ) { won = true; }
       // won = won || diag1 || diag2; 
     
     return won;
   }
   
   
   @Override
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      
      for ( int i=0; i<boardSize; i++ )
      {
         for ( int j=0; j<boardSize; j++ )
         {
            cell[i][j].drawMe(g); 
         }
      }
      
   }
}
