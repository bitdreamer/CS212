// Layout6.java


package guis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Layout6 extends JFrame
{
   // atrributes
   JButton dogButton;


   public static void main ( String [] args )
   {
      new Layout6();
   }
   
   // constructor
   public Layout6()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      setLayout( new FlowLayout() );

      
      
      setSize( 500, 500 );
      setVisible( true );
   }

}
