// Link.java
// CS-212 class 2014


package twixt2;

import java.awt.*;

public class Link
{
   static Board theBoard;
   boolean there; // true = line is there
   int myIndex; // which link we are from ends[0]
   Color color; 
   Peg[] ends;
   static int pegWidth;
   boolean redBlock = false; // true means red can't play here
   boolean blackBlock = false;
   boolean[] block; // block[i]=true means player i can't play here any more
   
   public Link( Peg p0, Peg p1, int my1 )
   {
      there = false; // really starts false
      color = Color.RED; // really doesn't matter to start
      
      ends = new Peg[2];
      ends[0] = p0;
      ends[1] = p1;
      
      myIndex = my1;
      
      block = new boolean[2];
      block[0] = block[1] = false;
   }
   
   // this link possibly has a new color, so if so do that 
   // and block all the links that this now blocks
   public void connect()
   {      
      if ( !there )
      {
         if ( ends[0].owner != null && ends[1].owner != null )
         {
            int mi = ends[0].owner.myIndex; // index of owner making this connection
            if ( mi == ends[1].owner.myIndex )
            {
               if ( block[mi] == false )
               {   
                  int yu = (mi+1)%2; // the other index, color to block
                  there = true;
                  color = ends[0].owner.color;
                  doBlocks( mi, yu );
               }
            } 
         }
      }
   }
   
   // so, we are putting this link in for player[mi],
   // and so we want to block all of the links that we should
   public void doBlocks( int mi, int yu )
   {
      int i = ends[0].ih;
      int j = ends[0].jv;
      if ( myIndex==0 )
      {
         blockOne( i,   j-1, 3, yu ); // A
         blockOne( i,   j-1, 2, yu ); // B
         blockOne( i,   j-1, 1, yu ); // C
         blockOne( i+1, j-1, 5, yu ); // D
         blockOne( i+1, j-1, 6, yu ); // E
         blockOne( i+1, j-1, 7, yu ); // F
         blockOne( i+1, j  , 7, yu ); // G
         blockOne( i+1, j  , 6, yu ); // H
         blockOne( i  , j-2, 2, yu ); // I
      }
      else if ( myIndex==1 )
      {
         blockOne( i+1, j-1, 4, yu ); // A
         blockOne( i+1, j-1, 3, yu ); // B
         blockOne( i+1, j-1, 2, yu ); // C
         blockOne( i+1, j  , 6, yu ); // D
         blockOne( i+1, j  , 7, yu ); // E
         blockOne( i+1, j  , 0, yu ); // F
         blockOne( i  , j-1, 3, yu ); // G
         blockOne( i  , j-1, 2, yu ); // H
         blockOne( i+2, j  , 2, yu ); // I
      }
      else if ( myIndex==2 )
      {
         blockOne( i+1, j  , 5, yu ); // A
         blockOne( i+1, j  , 4, yu ); // B
         blockOne( i+1, j  , 3, yu ); // C
         blockOne( i+1, j+1, 7, yu ); // D
         blockOne( i+1, j+1, 0, yu ); // E
         blockOne( i+1, j+1, 1, yu ); // F
         blockOne( i  , j+1, 0, yu ); // G
         blockOne( i  , j+1, 1, yu ); // H
         blockOne( i+2, j  , 4, yu ); // I
      }
      else if ( myIndex==3 )
      {
         blockOne( i,   j+1, 0, yu ); // A
         blockOne( i,   j+1, 1, yu ); // B
         blockOne( i,   j+1, 2, yu ); // C
         blockOne( i+1, j+1, 5, yu ); // D
         blockOne( i+1, j+1, 6, yu ); // E
         blockOne( i+1, j+1, 4, yu ); // F
         blockOne( i+1, j  , 5, yu ); // G
         blockOne( i+1, j  , 4, yu ); // H
         blockOne( i  , j+2, 1, yu ); // I
      }
   }
   
   // from peg[i][j], if it exists, find link[which], and if THAT exists (not null),
   // block[who] = true, i.e., set it so who can't play there any more.
   public void blockOne(int i, int j, int which, int who )
   {
      Peg p = theBoard.peg[i][j];
      if ( p!= null )
      {
         Link m = p.link[which];
         if ( m != null )
         {
            m.block[who] = true;
         }
      }
   }
   
   public void drawMe( Graphics g )
   {
      if ( there )
      {
         g.setColor( color );
         g.drawLine(  ends[0].x+pegWidth/2, ends[0].y+pegWidth/2, 
                      ends[1].x+pegWidth/2, ends[1].y+pegWidth/2 
                   );
      }
   }
}
