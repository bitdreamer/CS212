// ConnectFour.java


package connectFour;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConnectFour extends JFrame
{
   Grid theGrid; // the place to play Chips in Slots

   public static void main( String[] args )
   {
      new ConnectFour();
   }
   
   // main program constructor
   public ConnectFour()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      setTitle("Connect Four");
      
      setLayout( new FlowLayout() );
      
      theGrid = new Grid();
      add(theGrid);
      
      setSize(800,600);
      setVisible(true);
   }
}
