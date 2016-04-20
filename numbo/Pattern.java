// Pattern.java
// this is what the target looks like and what
// guesses look like.
// 4 digits, possibly with duplicates

package numbo;

public class Pattern
{
   int[] numbers;
   static int patternLength = 4;
   
   Score theScore;
   
   
   // constructor.  With no arguments it just makes up
   // random digits
   public Pattern()
   {
      numbers = new int[patternLength];
   
      for ( int i=0; i<patternLength; i++ )
      {
         numbers[i] = (int)(Math.random()*10);
      }
   }
   
   // constructor.  takes as argument the numbers that 
   // you want.  just save them.
   public Pattern( int[] spec )
   {
      numbers = new int[patternLength];
   
      for ( int i=0; i<patternLength; i++ )
      {
         numbers[i] = spec[i];
      }
      
   }
   
   // scores theGuess against THIS pattern and returns
   // the Score
   public Score match( Pattern theGuess )
   {
      Score theScore = new Score(0,0);
      
      for ( int i=0; i<patternLength; i++ )
      {
         // take the i-th digit of theGuess and see what it
         // score against the target
         for ( int j=0; j<patternLength; j++ )
         {
            if ( theGuess.numbers[i]==numbers[j] )
            {
               if ( i==j ) { theScore.bulls++; }
               else        { theScore.hits++; }
            }
         }
      }

      
      return theScore;
   }
   
   public String toString()
   {
      String r = "";
      
      for ( int i=0; i<patternLength; i++ )
      {
         r += " " + numbers[i];
      }
      
      r += " " + theScore.hits + " " + theScore.bulls;
      
      return r;
   }
   
   // access
   public void setScore( Score ts ) { theScore = ts; }
   
}
