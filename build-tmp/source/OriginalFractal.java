import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class OriginalFractal extends PApplet {

int xPos, yPos, zoomMod;

public void setup() {
	size(1600, 500, P3D);
	zoomMod = -3800;
	xPos = -6800;
	yPos = -600;
}
public void draw() {
	background(0);
	translate(xPos, yPos, zoomMod);
	fractal(60, 100, 15000);
	//System.out.println("X: " + xPos + "Y: " + yPos + "Zoom: " + zoomMod);
}
public void fractal(int x, int y, int len) {
	fill(255, 165, 0);
	noStroke();
	if (len < 40) {
		rect(0, 0, len, len/8);
	} else {
		pushMatrix(); // F
			translate(x, y);
			pushMatrix();	
				rotate(radians(90));
				fractal(0, 0, len/8);
			popMatrix();
			pushMatrix();
				//translate(len/128, 0);
				fractal(0, 0, len/12);
				translate(0, len/16);
				fractal(0, 0, len/12);
			popMatrix();
		popMatrix();

		pushMatrix(); // R
			translate(x + len/8, y);
			pushMatrix();	
				rotate(radians(90));
				fractal(0, 0, len/8);
			popMatrix();
			pushMatrix();
				//translate(len/120, 0);
				fractal(0, 0, len/12);
				translate(0, len/16);
				fractal(0, 0, len/12);
			popMatrix();
			pushMatrix();
				translate( len/12, 0);	
				rotate(radians(90));
				fractal(0, 0, len/14);
			popMatrix();
			pushMatrix();
				translate(len/48, 2*len/24);
				rotate(radians(30));
				fractal(0, 0, len/14);
			popMatrix();
		popMatrix();

		pushMatrix(); // A
			translate(x + len/4, y);
			pushMatrix();	
				rotate(radians(90));
				fractal(0, 0, len/8);
				translate(0, - len/12);
				fractal(0, 0, len/8);
			popMatrix();
			//translate(len/200, 0);
			fractal(0, 0, len/12);
			translate(0, len/16);
			fractal(0, 0, len/12);
		popMatrix();

		pushMatrix(); // C
			translate(x + 3*len/8, y);
			pushMatrix();	
				rotate(radians(90));
				fractal(0, 0, len/8);
			popMatrix();
			//translate(len/120, 0);
			fractal(0, 0, len/12);
			translate(0, len/8 - len/50);
			fractal(0, 0, len/12);
		popMatrix();

		pushMatrix(); // T
			translate(x + len/2 - len/32, y);
			pushMatrix();
				fractal(0, 0, len/8);
				translate(len/16, len/48 + len/96);
				rotate(radians(90));
				fractal(0, 0, len/12);
			popMatrix();
		popMatrix();

		pushMatrix(); // A
		translate(x + 5*len/8, y);
			pushMatrix();	
				rotate(radians(90));
				fractal(0, 0, len/8);
				translate(0, - len/12);
				fractal(0, 0, len/8);
			popMatrix();
			//translate(len/200, 0);
			fractal(0, 0, len/12);
			translate(0, len/16);
			fractal(0, 0, len/12);
		popMatrix();

		pushMatrix();
			translate(x + 3*len/4, y);
			pushMatrix();
				rotate(radians(90));
				fractal(0, 0, len/8);
			popMatrix();
			translate(0, len/8 - len/50);
			fractal(0, 0, len/12);
		popMatrix();
	}
}

public void keyPressed() {
	if (key == 'd') {xPos -= 100;}
	if (key == 'a') {xPos += 100;}
	if (key == 's') {yPos -= 100;}
	if (key == 'w') {yPos += 100;}
	if (key == 'q') {zoomMod += 100;}
	if (key == 'e') {zoomMod -= 100;}
}


/*if (len < 14) {
		pushMatrix(); // F
		translate(x, y);
		pushMatrix();	
		rotate(radians(90));
		rect(0, 0, 20, 4);
		popMatrix();
		rect(0, 0, 10, 4);
		rect(0, 10, 10, 4);
		popMatrix();

		pushMatrix(); // R
		translate(x + 20, y);
		pushMatrix();	
		rotate(radians(90));
		rect(0, 0, 20, 4);
		popMatrix();
		rect(0, 0, 10, 4);
		rect(0, 10, 10, 4);
		pushMatrix();
		translate(10, 0);	
		rotate(radians(90));
		rect(0, 0, 10, 4);
		translate(10, 4);
		rect(0, 0, 10, 4);
		popMatrix();
		popMatrix();

		pushMatrix(); // A
		translate(x + 40, y);
		pushMatrix();	
		rotate(radians(90));
		rect(0, 0, 20, 4);
		translate(0, -10);
		rect(0, 0, 20, 4);
		popMatrix();
		rect(0, 0, 10, 4);
		rect(0, 10, 10, 4);
		popMatrix();

		pushMatrix(); // C
		translate(x + 60, y);
		pushMatrix();	
		rotate(radians(90));
		rect(0, 0, 20, 4);
		popMatrix();
		rect(0, 0, 10, 4);
		rect(0, 16, 10, 4);
		popMatrix();

		pushMatrix();
		translate(x + 80, y);
		rect(0, 0, 20, 4);
		pushMatrix();
		rotate(radians(90));
		rect(0, -12, 20, 4);
		popMatrix();
		popMatrix();

		
	}*/
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OriginalFractal" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
