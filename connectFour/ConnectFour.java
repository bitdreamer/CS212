// ConnectFour.java


package connectFour;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConnectFour extends JFrame
{
   public static void main( String[] args )
   {
      new ConnectFour();
   }
   
   public ConnectFour()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      setTitle("Connect Four");
      
      setSize(800,600);
      setVisible(true);
   }
}
