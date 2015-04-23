
//Jimmy.java
// This is the dot that bounces around and wrecks bricks.

package brickOut;

import java.awt.*;

public class Jimmy 
{
	double x, y; //position in pixels from upper left. (position based on center of dot)
	double vx, vy; // velocity of this dot in pixels per second
	Color color; //color of dot, red or blue presumably
	int size; // the diameter of the dot, to be used for size in oval for both directions
	final double vyraw = 200; // this is the vertical speed of Jimmy, 
	
	public Jimmy()
	{
		x = 250;
		y = 250;
		vx = 100;
		vy = -vyraw;
		color = Color.black;
		size = 10;
	}
	
	// bounce the ball on the window, except no bounce at bottom, person
	// has to use the paddle
	public void stayOnScreen()
	{
		if ( x > 495 ) { vx = - Math.abs(vx); /* x = 590; */ }
		//if ( y > 495 ) { vy = - Math.abs(vy); }
		if ( x < 5 )   { vx =   Math.abs(vx); }
		if ( y < 15 )   { vy =  vyraw; }
	}
	
	//moves the dot a little
	public void move( double dt )
	{
		x += vx * dt;
		y += vy * dt;
		stayOnScreen();
		// System.out.println("vx="+vx+" vy="+vy);
	}
	
	// draw the Jimmy
	public void drawMe( Graphics g )
	{
		g.setColor( color );
		g.fillOval( (int) (x-size/2), (int) (y-size/2), size, size);
	}
}
