// Layouts.java
// practice with basic GUI elements
// CS-212 2014 with Barrett Koster

package guis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Layouts2 extends JFrame implements ActionListener
{
   JButton dogButton;
   JButton catButton;
   
   public static void main( String[] args )
   {
      new Layouts2();
   }
   
   // constructor
   public Layouts2()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Layout practice");
      
      setLayout( new FlowLayout() );
      
      dogButton = new JButton("dog");
      add(dogButton);
      dogButton.addActionListener(this);
      
      catButton = new JButton("cat");
      add(catButton);
      catButton.addActionListener(this);
      
      setSize( new Dimension( 800,600 ) );
      setVisible(true);
   }
   
   public void actionPerformed( ActionEvent e )
   {
      System.out.println("you rang?");
      if      ( e.getSource()==dogButton ) { System.out.println("bow wow"); }
      else if ( e.getSource()==catButton ) { System.out.println("meow"); }
   }
}
