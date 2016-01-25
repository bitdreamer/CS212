// Layout5.java

package guis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Layout5 extends JFrame
{
   // atrributes
   JPanel upperLeftPanel;
   JPanel upperRightPanel;
   JPanel lowerLeftPanel;

   public static void main ( String [] args )
   {
      new Layout5();
   }
   
   // constructor
   public Layout5()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      // set up 2x2 window, major panels ....
      
      setLayout( new GridLayout(2,2) ); 
      Container c = getContentPane();
      c.setBackground( Color.pink );
      
      upperLeftPanel = new JPanel();
      upperLeftPanel.setBackground( new Color( 200,200,240)  );
      add( upperLeftPanel );
      
      upperRightPanel = new JPanel();
      upperRightPanel.setBackground( Color.green );
      add( upperRightPanel );
      
      lowerLeftPanel = new JPanel();
      lowerLeftPanel.setBackground( Color.red );
      add( lowerLeftPanel );
      
      // do upper left panel as a border layout
      upperLeftPanel.setLayout( new BorderLayout() );
      upperLeftPanel.add( new JLabel("CA"), BorderLayout.WEST );
      upperLeftPanel.add( new JLabel("NC"), BorderLayout.EAST );
      upperLeftPanel.add( new JButton("TX"), BorderLayout.CENTER );
      
      
      
      setSize( 500, 500 );
      setVisible( true );
   }
   
   

}
