// WordWriter.java

package guis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import mousing.ColorPicker3;

public class WordWriter extends JFrame
   implements ActionListener, MouseListener
{
   JTextField writeOnMe; // place for user to enter text
   int mouseX, mouseY; // last place mouse was clicked
   Font theFont;
   
   JButton doubleModeButton;
   int doubleMode=0;  // 0=plain, 1=double stuff
   
   ColorPicker3 cp;
   
   Word[] words;
   int wordCount=0;

   public static void main ( String[] args )
   {
      new WordWriter();
   }
   
   public WordWriter()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      setTitle("WordWriter");
      
      setLayout( new FlowLayout() );
      
      cp = new ColorPicker3();
      cp.setLocation( 550, 100 );
      
      words = new Word[100];

      theFont = new Font("Courier",Font.BOLD+Font.ITALIC,20);
      
      writeOnMe = new JTextField("write here", 30);
      writeOnMe.setFont( theFont );
      add( writeOnMe );
      writeOnMe.addActionListener(this);
      
      
      doubleModeButton = new JButton("double talk");
      add(doubleModeButton);
      doubleModeButton.addActionListener(this);
      
      
      addMouseListener(this);
      
      setSize(500,500 );
      setVisible(true);
   }
   
   @Override public void mouseClicked ( MouseEvent m)
   {
      mouseX = m.getX(); mouseY = m.getY();
      
      words[wordCount++] = new 
         Word( mouseX, mouseY, writeOnMe.getText(), cp.getColor() );
      
      repaint();
   }
   
   
   @Override public void mouseEntered ( MouseEvent m) {}
   @Override public void mouseExited  ( MouseEvent m) {}
   @Override public void mousePressed ( MouseEvent m) {}
   @Override public void mouseReleased( MouseEvent m) {}
   
      
   @Override
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource()==writeOnMe )
      { System.out.println("text:"+writeOnMe.getText()); }
      else if ( e.getSource()==doubleModeButton ) { doubleMode = 1; }
      repaint();
   }
   
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      
      g.setFont ( theFont );
      
      String writeMe = writeOnMe.getText();
      
      if ( doubleMode==1 ) { writeMe += writeOnMe.getText(); }
      
      g.setColor( cp.getColor() );
      
     // g.drawString( writeMe, mouseX, mouseY );
      
      for ( int i=0; i<wordCount; i++ )
      {
         words[i].drawMe(g);
      }
      
   }
}
