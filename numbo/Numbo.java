// Numbo.java
// CS-212 2016

package numbo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Numbo extends JFrame 
{
   Teaser theTeaser;
   Guesser theGuesser;

   public static void main (String[] args)
   {
      new Numbo();
   }
   
   // constructor
   public Numbo()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      setTitle("Numbo");
      
      theTeaser = new ComputerTeaser();
      theGuesser = new HumanGuesser( theTeaser );
      add(theGuesser);
      
      setSize( 600,600 );
      setVisible(true);
   }
   
   
   
   
}
