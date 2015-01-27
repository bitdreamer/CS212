// Breaker.java
// Barrett Koster 2012.01
// This program doubles numbers until they break, printing out the results.
// It does this with different types of numbers, since each breaks
// in its own way.

package art;

public class Breaker
{
   public static void main( String[] args )
   {
	   Breaker b = new Breaker();
   }
   
   public Breaker()
   {
	   int x=1;
	   long y = 1;
	   float z = 1;
	   double w = 1;
	   
	   for ( int i=0; i<1025; i++ )
	   {
		   System.out.println("i="+i+", int x="+x+", long y="+y+", float z="+z
				   +", double w="+w
				             );
		   x = x * 2;
		   y = y * 2;
		   z = z * 2;
		   w = w * 2;
	   }
   }
}
