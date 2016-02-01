// Layout4.java
// 2016 CS-212 class

package guis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Layout4 extends JFrame implements ActionListener
{
   // atrributes
   JButton dogButton;
   JButton catButton;

   public static void main ( String [] args )
   {
      Layout4 sue = new Layout4();
   }
   
   // constructor
   public Layout4()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      setLayout( new FlowLayout() );
      
      dogButton = new JButton("dog");
      add( dogButton );
      dogButton.addActionListener( this );
      
      catButton = new JButton("cat");
      add( catButton );
      
      
      
      setSize( 500, 500 );
      setVisible( true );
   }
   
   // This method is given an even when someone does something
   // that this class (ActionListener) is listening for.
   @Override
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource()==dogButton ) { System.out.println("bow wow");  }
   }

}
