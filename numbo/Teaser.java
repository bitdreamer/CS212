// Teaser.java
// super class for HumanTeaser or ComputerTeaser

package numbo;

public abstract class Teaser
{
   Pattern target;
   
   // dummy method
   public abstract Score scoreGuess( Pattern theGuess );
   /*
   {
      Score theScore = new Score(0,0);
      
      return theScore;
   }*/
}
