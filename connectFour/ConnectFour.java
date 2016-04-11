// ConnectFour.java


package connectFour;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConnectFour extends JFrame
{
   Grid theGrid; // the place to play Chips in Slots
   
   JButton saveButton;
   JButton loadButton;

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
      
      theGrid = new Grid(this);
      saveButton = new JButton("save");
      saveButton.addActionListener(theGrid);  
      loadButton = new JButton("load");
      loadButton.addActionListener( theGrid );
      
      add( saveButton );
      add( loadButton );
      add(theGrid);
      
      setSize(800,700);
      setVisible(true);
   }
}
