// Layouts.java
// practice with basic GUI elements
// CS-212 2014 with Barrett Koster

package guis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Layouts3 extends JFrame implements ActionListener
{
   JButton dogButton; // just a button
   JButton catButton; 
   JPanel panel0; // upper left of 2x2 main grid
   JPanel panel1; // upper right of 2x2 main grid
   JPanel panel2; // lower left of 2x2 main grid
   
   public static void main( String[] args )
   {
      new Layouts3();
   }
   
   // constructor
   public Layouts3()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Layout practice");
      
      //setLayout( new FlowLayout() );
      setLayout( new GridLayout( 2,2 ));
      
      panel0 = new JPanel();
      panel0.setBackground( Color.yellow );
      add(panel0);
      panel0.setLayout( new BorderLayout() );
      panel0.add( new JButton("CA"), BorderLayout.WEST );
      panel0.add( new JButton("MN"), BorderLayout.NORTH );
      
      panel1 = new JPanel();
      panel1.setBackground( Color.pink );
      add(panel1);
      
         dogButton = new JButton("dog");
         panel1.add(dogButton);
         dogButton.addActionListener(this);
         
         catButton = new JButton("cat");
         panel1.add(catButton);
         catButton.addActionListener(this);
         
         
      panel2 = new JPanel();
      panel2.setBackground( new Color( 200, 100, 200 ) );
      add(panel2);
      panel2.setLayout( new GridLayout( 4, 3 ) );
      panel2.add( new JButton("0") );
      
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
