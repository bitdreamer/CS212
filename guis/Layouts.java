// Layouts.java
// practice with basic GUI elements
// CS-212 2014 with Barrett Koster

package guis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Layouts extends JFrame implements ActionListener
{
   JButton dogButton; // just a button
   JButton catButton; 
   
   public static void main( String[] args )
   {
      new Layouts();
   }
   
   // constructor
   public Layouts()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Layout practice");
      
      //setLayout( new FlowLayout() );
      setLayout( new FlowLayout() );
      
      dogButton = new JButton("dog");
      add(dogButton);
      dogButton.addActionListener(this);
      
      catButton = new JButton("cat");
      add(catButton);
      catButton.addActionListener(this);
      
      setSize( new Dimension( 500,500 ) );
      setVisible(true);
      
   }
   
   // responds to events when they happen.
   public void actionPerformed( ActionEvent e )
   {
      System.out.println("you rang?");
      
      if      ( e.getSource()==dogButton ) { System.out.println("bow wow"); }
      else if ( e.getSource()==catButton ) { System.out.println("meow"); } 
   }
}
