// ComputerTeaser.java


package numbo;

public class ComputerTeaser extends Teaser
{
   // constructor
   // Teaser thinks up random target
   public ComputerTeaser()
   {
      target = new Pattern();
   }
   
   // Score the guess against the target (and return the score)
   @Override
   public Score scoreGuess( Pattern theGuess )
   {
      Score theScore = target.match( theGuess ) ;

      return theScore;
   }
}
