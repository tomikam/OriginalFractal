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

public void setup() {
	size(1600, 500);
}
public void draw() {
	fractal(100, 100, 5);
}
public void fractal(int x, int y, int len) {
	fill(255, 165, 0);
	noStroke();
	if (len < 14) {
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
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OriginalFractal" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
