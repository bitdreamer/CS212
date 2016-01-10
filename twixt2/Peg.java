// Peg.java

package twixt2;

import java.awt.*;
import javax.swing.*;

public class Peg
{
   int x,y; // coordinate in pixels or this peg
   int ih,jv; // coordinates in the array in Board
   static Board theBoard; // points to the board this peg is on
   Player owner=null;
   boolean showing; // true = this peg is on the board, 
                    // false = invisible , no play
   static int pegWidth;
   Link[] link; // these are the edges between pegs, numbered from
                // 0 at about 1 o'clock 
   boolean win = false; // true=connected to starting side for this color
  
   
   public Peg( int i1, int j1 )
   {
      ih = i1; jv = j1;
      
      int spacing = 500 / theBoard.boardSize;
      x = theBoard.xoffset + ih * spacing;
      y = theBoard.yoffset + jv * spacing;
      
      // cut out the corners 
      showing = true;
      if (  ( ih==0 || ih==theBoard.boardSize-1 )
          &&( jv==0 || jv==theBoard.boardSize-1 )
         )
      { showing = false; }
      
      link = new Link[8];

   }
   
   // adds the 8 Link objects to this Peg,
   // call this AFTER all the Pegs are made
   public void addLinks()
   {
      addOneLink( 0, ih+1, jv-2 );
      addOneLink( 1, ih+2, jv-1 ); 
      addOneLink( 2, ih+2, jv+1 );
      addOneLink( 3, ih+1, jv+2 );
      //Peg p;
      //p = theBoard.getPeg(ih+1,jv-2);
      //if ( p!=null ) { link[0] = new Link( this, p  ); }

      // more linkes needed here
   }
   
   // add link[which] to peg[i][j] if it exists
   public void addOneLink( int which, int i, int j )
   {
      Peg p; // the other end of the link
      p = theBoard.getPeg(i,j);
      if ( p!=null )
      {
         link[which] = new Link( this, p, which  );
         p.link[which+4] = link[which];
      }
   }
   
   // This peg just got made a color, so look around and see if there
   // are similarly colored pegs and make lines to them.
   public void connect()
   {
      for ( int k=0; k<8; k++ )
      {
         Link linky = link[k];
         if ( linky != null )
         {
            linky.connect();

         }
      }
   }
   
   // if not already set to win, set it and 
   // propogate to all other pegs with a link that is there
   public void prop()
   {
      if ( !win )
      {
         win = true;
         
         for ( int k=0; k<8; k++ )
         {
            if ( link[k] != null )
            {
               if ( link[k].there )
               {
                  Peg otherEnd;
                  if ( k<4 ) { otherEnd = link[k].ends[1]; }
                  else       { otherEnd = link[k].ends[0]; }
                  
                  if ( otherEnd.owner == owner ) { otherEnd.prop(); }
               }
            }
         }
      }
   }
   
   public void drawMe( Graphics g )
   {
      if ( showing )
      {
         if( owner==null )
         {
            g.setColor(Color.black);
            g.drawOval( x, y, pegWidth, pegWidth  );
         }
         else
         { g.setColor( owner.color );
            g.fillOval( x, y, pegWidth, pegWidth  ); 
            if ( win ) { g.drawString("w",x+pegWidth, y+pegWidth+10 ); }
         }
         
         for ( int k=0; k<8; k++ )
         {
            if ( link[k]!=null ) { link[k].drawMe(g); }
         }
      }
   }
}
