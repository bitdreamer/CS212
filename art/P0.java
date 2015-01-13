// P0.java 
//Barrett Koster and the CS-212 class 2015

package art;

import javax.swing.*;

public class P0 extends JFrame
{
   public static void main(String[] args )
   {
	   System.out.println("Hello world.");
       new P0();
   }
   
   //constructor 
   public P0()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Hello world.");
      setSize( 500, 500 );
      setVisible(true);
   }
}
