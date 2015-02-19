package mousing;

public class Money
{
   int dollars; // whole dollars, must be greater >= 0 
   int cents; //should be between 0 and 99 inclusive
   
   public Money()
   {
      dollars = 0;
      cents = 1; 
   }
   
   // add the money in m to THIS object 
   public void addToThis( Money m )
   {
      dollars += m.dollars;
      cents += m.cents;
      if ( cents >= 100 )
      {
         dollars++;
         cents -= 100;
      }
   }

}
