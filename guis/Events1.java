// Events.java
// practice with basic GUI elements
// CS-212 2014 with Barrett Koster

package guis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Events1 extends JFrame implements ActionListener
{
   // attrobites
   JButton dogButton; // just a button
   JButton catButton; 
   JButton fishButton;
   boolean drawBox = false;
   int fishCount=0; // counts through the states from the fishButton
                    // 0=nothing, 1=square, 2=dot, 3=triangle
   
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
      
      fishButton = new JButton("fish");
      add(fishButton);
      fishButton.addActionListener(this);
      
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
      else if ( e.getSource()==fishButton)
      {
         fishCount = (fishCount+1) %4; // counts 0 1 2 3 0 1 2 3 0 1 2 3
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
      
      if ( fishCount==1 ) // draw box
      {
         g.fillRect( 100, 300, 50, 90 );
      }
      else if (fishCount==2 ) // draw dot
      {
         g.fillOval( 100, 300, 50, 90 );
         
      }
      else if (fishCount == 3 ) // draw triangle
      {
         g.drawLine( 100, 300, 150, 300 );
         g.drawLine( 150, 300, 100, 390 );
         g.drawLine( 100, 390, 100, 300 );
      }
      
   }
}
