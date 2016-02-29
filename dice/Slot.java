// Slot.java
// CS-212 2016

package dice;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Slot extends JPanel
{
   Random randy;

   public Slot()
   {
      randy = new Random();
      setPreferredSize( new Dimension(300, 30 ) );
      setBackground( doPastel() );
   }
   
   public Color doPastel()
   {
      int   red = 150 + randy.nextInt(100);
      int green = 150 + randy.nextInt(100);
      int  blue = 150 + randy.nextInt(100);
      
      return new Color( red, green, blue );
   }
   
}
