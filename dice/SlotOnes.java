package dice;

public class SlotOnes extends Slot
{
   public SlotOnes()
   {
      super("1s");
   }

   @Override
   public int computeScore()
   {
      int total = 0;
      for ( int i=0; i<5; i++ )
      {
         if ( dice[i].faceUp==1 )  { total += 1; }
      }
      return total;
   }
}
