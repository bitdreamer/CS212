package ttt;

public class Computer extends Player
{
   public Computer( char letter1 )
   {
      super(letter1);
      name = "number5";
      System.out.println("Computer: ="+myIndex);
      
      // start();
   }
   
   @Override
   public void run()
   {
      // constantly check to see if it's your turn, play if so
      while ( true )
      {
         if ( theBoard.whoseTurn == myIndex ) // my turn
         {
            int i = (int)( Math.random()*3 );
            int j = (int)( Math.random()*3 );
            
            theBoard.play( i, j, letter );
         }
         try { sleep(1000); } catch ( Exception e ) { System.out.println("insomnia"); }
      }
   }
}
