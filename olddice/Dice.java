// Dice.java
// This class represents a single die (one of a pair of dice).
// It should have the number and a button to make it roll.

package olddice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dice extends JPanel implements ActionListener
{
   protected int face; // how many dots are showing, 1-6
   protected JButton rollButton; // change whether this dice can be rolled
   protected boolean rollable = true; // true=this dice can change value
                                      // false= face is stuck
   
   public Dice()
   {
      roll();
      setBackground( randomPastel() );
      setPreferredSize( new Dimension(50,100) );
      
      setLayout(new FlowLayout());
      
      rollButton = new JButton("hold");
      add(rollButton);
      rollButton.addActionListener(this);
   }
   
   // randomly set face to 1 thru 6 if rollable
   public void roll()
   {
      if ( rollable )
      {
         face = (int)( Math.random()*6+1);
      }
   }
   
   // take the hold off, and change face to 0 ?
   public void reset()
   {
      rollable = true;
      face = 0;
      repaint();
   }
   
   
   
   public Color randomColor()
   {
      Color color = new Color(
            (int)( Math.random()*255),
            (int)( Math.random()*255),
            (int)( Math.random()*255)
                       );
      return color;
   }
   public Color randomPastel()
   {
      Color color = new Color(
            (int)( 150 + Math.random()*100),
            (int)( 150 + Math.random()*100),
            (int)( 150 + Math.random()*100)
                       );
      return color;
   }
   
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource()==rollButton ) { rollable = !rollable; }
      repaint();
   }

   // draw the number 'face' on the screen.
   public void paint( Graphics g )
   {
      super.paint(g);
      
      g.drawString( ""+face, 20, 40 );

      if (!rollable) { g.drawString("on hold", 10, 95); }
      
      
      if ( face==1 || face==3 || face==5 )
      {
         g.fillOval( 20, 60, 5, 5 );  // center dot, used for 1 3 and 5
      }
      if ( face==2 || face==3 || face==5 || face==4 || face==6)
      {
         g.fillOval( 10, 50, 5, 5 ); // upper left, lower right
         g.fillOval( 30, 70, 5, 5 );
      }
      if ( face==5 || face==4 || face==6)
      {
         g.fillOval( 10, 70, 5, 5 ); // upper right, lower left
         g.fillOval( 30, 50, 5, 5 );
      }
      if ( face==6 )
      {
         g.fillOval( 10, 60, 5, 5 ); // center side dots
         g.fillOval( 30, 60, 5, 5 );

      }
      
   }
}
