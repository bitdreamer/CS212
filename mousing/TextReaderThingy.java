package mousing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextReaderThingy extends JFrame implements ActionListener
{
   JTextField jtf;  // 
   String[] names;
   int nameCount;

   public static void main( String [] args )
   {
      new TextReaderThingy();
   }
   
   // constructor
   public TextReaderThingy()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      setTitle("TextReaderThingy");
      
      setLayout( new FlowLayout() ); // just to get going
      
      names = new String[1000];
      nameCount = 0;
      
      jtf = new JTextField(10); // make it
      add(jtf);  // add it to the window
      jtf.addActionListener( this );
      
      setSize(new Dimension(500,500));
      setVisible(true);
   }
   
   @Override
   public void actionPerformed( ActionEvent e )
   {
      String n = jtf.getText();
      jtf.setText("");
      System.out.println("You typed " + n );
      names[nameCount++] = n;
      repaint();
   }
   
   public void paint( Graphics g )
   {
      super.paint(g);
      
      for ( int i=0; i<nameCount; i++ )
      {
         g.drawString( names[i], 100, 100 + 20 * i );
      }
   }
    
}
