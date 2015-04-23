// TicTacToe.java
// 2014 CS-212
// This program plays tic tac toe

package ttt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame
{
   Board theBoard;
   Player[] player; // will be 2 of them
   
   public static void main( String[] args)
   {
      new TicTacToe();
   }
   
   public TicTacToe()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Tic Tac Toe");
      setLayout( new FlowLayout() );
      
      theBoard = makeBoard();
      add(theBoard);
      Player.theBoard = theBoard;
     
      player = new Player[2];
      player[0] = choosePlayer('x'); // new Human('x');
      player[1] = choosePlayer('o'); // new Human('o');
      
      theBoard.player = player;
      
      setSize( new Dimension(500,500) );
      setVisible(true);
      
      if ( player[0] instanceof Computer ) { player[0].start(); }
      if ( player[1] instanceof Computer ) { player[1].start(); }
   }
   
   // return new Board
   public Board makeBoard() { return new Board(3); }
   
   // returns a player, either Human or Computer, to play this letter
   public Player choosePlayer( char letter )
   {
      Player p=null;
      
      while( p==null)
      {
         String answer = 
         JOptionPane.showInputDialog("human or computer plays "+letter+"?(h,c): ");
         if      ( answer.equals("h") ) { p = new Human(letter);  }
         else if ( answer.equals("c") ) { p = new Computer(letter); }
         else  { JOptionPane.showMessageDialog( null, "oops");    }
      }
      
      return p;
   }
   
}
