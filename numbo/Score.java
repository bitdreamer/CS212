// Score.java

package numbo;

public class Score
{
   int hits;
   int bulls;
   
   public Score( int h, int b )
   {
      hits = h;
      bulls = b;
   }
   
   // return true iff h and b exactly match this Score
   public boolean equals( int h, int b )
   {
      return ( hits==h && bulls==b );
   }
}
