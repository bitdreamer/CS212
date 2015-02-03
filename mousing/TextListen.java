// TextListen.java Barrett Koster 2013 for CS-212 
// This class shows how to make a text field and get user input through it.

package mousing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TextListen extends JFrame implements ActionListener
{
   JTextField tf;
   
   public static void main(String[] args )
   {
       System.out.println("hi there");
       new TextListen();
   }

   // contructor, add a text field with listener
   public TextListen()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      setLayout( new FlowLayout() );
      
      tf = new JTextField("whatever",20);
      add( tf );
      tf.addActionListener( this );
      
      setSize( new Dimension(500,500) );
      setVisible(true);
   }
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource()==tf     ) { System.out.println("said:"+tf.getText()); }
   }
}