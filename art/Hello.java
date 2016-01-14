// Hello.java
// CS-212 2016 class

package art;

import javax.swing.JFrame;

public class Hello extends JFrame
{
   public static void main ( String[] args )
   {
      System.out.println("woohoo!");
      new Hello();
   }
   
   public Hello()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize( 500, 500 );
      setVisible(true);
   }
   
}
