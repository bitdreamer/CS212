// Twixt.java
// 2015 CS-212

package ttt;

public class Twixt extends TicTacToe
{
   public static void main (String[] args )
   {
      new Twixt();
   }
   
   public Twixt()
   {
      //theBoard = new TwixtBoard(5);
      //add(theBoard);
   }
   
   // return new Board
   public Board makeBoard() { return new TwixtBoard(24); }

}
