package numbo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Guesser extends JPanel
{
   Pattern[] already; // ones you've guessed already
   int alreadyCount; // how many guesses so far
   
   Teaser theTeaser;
   
   public Guesser( Teaser t )
   {
      theTeaser = t;
   
      already = new Pattern[50];
      alreadyCount = 0;
      
      setLayout( new FlowLayout() );
   }
}
