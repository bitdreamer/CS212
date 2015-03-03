// Sorry.java
// CS-212 2015
// This is for starters just a way to call NumberCube.

package dice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sorry extends JFrame
{
   NumberCube[] cubies;  // holds two dice

   public static void main ( String [] args )
   {
      new Sorry();
   }
   
   // constructor
   public Sorry()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      setLayout( new FlowLayout() );
      
      getContentPane().
      setBackground( Color.yellow );
      
      cubies = new NumberCube[20];
      for ( int i=0; i<20; i++ )
      {
         cubies[i] = new NumberCube();
         add( cubies[i] );
      }
      /*
      cubies[0] = new NumberCube();
      cubies[1] = new NumberCube();
      add( cubies[0] );
      add( cubies[1] );
      */
      
      
      setSize( 500,500 );
      setVisible(true);
   }
}
