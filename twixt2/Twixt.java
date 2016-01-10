// Twixt.java
// 2014 CS-212 class

package twixt2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Twixt extends JFrame implements ActionListener
{
   Board theBoard;
   Player[] player;
   JTextField sizeTF; // BEK set the edge length of the board, including home rows
   
   public static void main( String[] args )
   {
      new Twixt();
   }
   
   public Twixt()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Twixt");
      
      setLayout( new FlowLayout() );
      theBoard = new Board(8);
      add( theBoard );
      Player.theBoard = theBoard;
      
      player = new Player[2];
      player[0] = choosePlayer(0,Color.RED);   //  new Computer ( 0, Color.RED );
      player[1] = choosePlayer(1,Color.BLACK); //  new Human( 1, Color.BLACK );
      Board.player = player;
      
      //System.out.println("Twixt: theBoard="+theBoard);
      
      sizeTF = new JTextField("board size here ");
      add(sizeTF);
      sizeTF.addActionListener(this);
      
      setSize( new Dimension(600,600) );
      setVisible(true);
      
      if ( player[0] instanceof Computer ) { player[0].start(); }
      if ( player[1] instanceof Computer ) { player[1].start(); }

   }
   
   // returns a player, either Human or Computer, to play this letter
   public Player choosePlayer( int id, Color c )
   {
      Player p=null;
      
      while( p==null)
      {
         String answer = 
         JOptionPane.showInputDialog("human or computer plays"+c+"?(h,c): ");
         if      ( answer.equals("h") ) { p = new Human(id, c);  }
         else if ( answer.equals("c") ) { p = new Computer(id, c); }
         else  { JOptionPane.showMessageDialog( null, "oops");    }
      }
      
      return p;
   }
   

   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource()==sizeTF )
      {
         remove(theBoard);
         String ss = sizeTF.getText(); System.out.println("ss="+ss);
         double d = Double.parseDouble( ss ); System.out.println("d="+d);
         int s =  (int) d;
         theBoard = new Board( s );
         add(theBoard);
         Player.theBoard = theBoard;
         theBoard.player = player;
      }
      validate();
      repaint();
   }
}
