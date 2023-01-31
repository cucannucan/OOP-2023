package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(0);

		
		
	}

	
	
	public void draw()
	{	
		stroke(255);
		line(10,10,100,100);
		circle(300,250,70);
		fill(50,100,0);
		rect(10,300,20,100);
		stroke(127);
		fill(241,254,0);
		noStroke();
		strokeWeight(1);
		triangle(40,90,300,20,80,70);
		fill(0,0,255);
	}
}
