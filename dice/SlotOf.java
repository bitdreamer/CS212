package dice;

public class SlotOf extends Slot
{
   int dots;  // the number we are looking for on the dice

   public SlotOf()
   {
      super("1s");
   }
   
   public SlotOf( int d )
   {
      super(""+d+"s");
      dots = d;
   }

   @Override
   public int computeScore()
   {
      int total = 0;
      for ( int i=0; i<5; i++ )
      {
         if ( dice[i].faceUp==dots )  { total += dots; }
      }
      return total;
   }
}
