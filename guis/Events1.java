// Events.java
// practice with basic GUI elements
// CS-212 2014 with Barrett Koster

package guis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Events1 extends JFrame implements ActionListener
{
   JButton dogButton; // just a button
   JButton catButton; 
   boolean drawBox = false;
   
   public static void main( String[] args )
   {
      new Events1();
   }
   
   // constructor
   public Events1()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Layout practice");
      
      setLayout( new FlowLayout() );
      
      dogButton = new JButton("dog"); // makes the button
      add(dogButton);                 // adds it to the window
      dogButton.addActionListener(this); // connects it to the listener
      
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
      
      if      ( e.getSource()==dogButton )
      { System.out.println("bow wow");
         getContentPane().setBackground( Color.pink );
      }
      else if ( e.getSource()==catButton )
      {
         System.out.println("meow");
         drawBox = !drawBox; // toggles this boolean variable
      } 
      //validate(); // forces system to update all window related stuff
                  // We don't actually need this one right now.
      repaint(); // makes system call paint() soon
   }
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      if (drawBox)
      {
         g.setColor( Color.red );
         g.fillRect(100,100,200,200);
      }
   }
}
