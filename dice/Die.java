// Die.java
// CS-212 2016
// singular of "dice", the noun, not the verb.

package dice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Die extends JPanel
   implements MouseListener
{
   int numberOfSides; // numbering is one to this number
   int faceUp; // the number currently rolled
   static Font f;
   static Random randy;
   static Color theColor;  // background
   boolean hold; // false means it rolls, true means is stays at faceUp
   
   
   // constructor
   public Die()
   {
      hold = false; // start letting it roll
      
      if (f==null)
      {      f= new Font("TimesNewRoman",0,30); }
      
      setPreferredSize( new Dimension(50,50) );
      
      if ( randy==null )
      { randy = new Random(); }
      
      if ( theColor==null ) { theColor = doPastel(); }
      //setBackground(theColor);
      setBackground(Color.white);
      
      roll();
      
      addMouseListener(this);
   }
   
   // randomly set faceUp and return that number
   public int roll()
   {
      if ( !hold) { faceUp = (int)(1+6*Math.random()); }
      return faceUp; // stub 
   }
   
   public int getFaceUp() { return faceUp; }
   
   public Color doPastel()
   {
      int   red = 150 + randy.nextInt(100);
      int green = 150 + randy.nextInt(100);
      int  blue = 150 + randy.nextInt(100);
      
      return new Color( red, green, blue );
   }
   
   @Override public void mouseClicked ( MouseEvent m )
   {
      hold = !hold;
      
      if ( hold ) { setBackground(Color.pink); } 
      else        { setBackground(Color.white); }
   }
   @Override public void mousePressed ( MouseEvent m ) {}
   @Override public void mouseReleased( MouseEvent m ) {}
   @Override public void mouseEntered ( MouseEvent m ) {}
   @Override public void mouseExited  ( MouseEvent m ) {}
   
   @Override
   public void paint( Graphics g )
   {
      super.paint(g);
      g.setColor( Color.black );
      g.setFont(f);
      g.drawString(""+faceUp, 10, 40 );
      
   }
   
}
