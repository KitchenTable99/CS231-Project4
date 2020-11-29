import java.awt.Graphics;
import java.util.Random;

/*
   File: Agent.java
   Author: Caleb Bitting
   Date: 09/24/2020
   Agent Class
*/

public abstract class Agent {
	
	protected double x, y, r;
	protected boolean moved;
	
	// constructors
	public Agent() {
		x = 0;
		y = 0;
		r = 0;
		moved = false;
	}
	
	public Agent(double x0, double y0, double radius) {
		x = x0;
		y = y0;
		r = radius;
		moved = false;
	}
	
	// accessors and mutators
	public boolean getMoved() {
		return moved;
	}
	
	public double getRadius() {
		return r;
	}
	
	public void setRadius(double newR) {
		r = newR;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double newX) {
		x = newX;
	}
	
	public void setY(double newY) {
		y = newY;
	}
	
	// utility methods
	public abstract void updateState(Landscape scape);
	
	public abstract void draw(Graphics g);
	
	public void move() {
		this.x += genMoveNum();
		this.y += genMoveNum();
	};
	
	public static double genMoveNum() {
		Random rand = new Random(); 
		double num1 = rand.nextDouble() * 10; 		 // random double in range [0, 10)
		double num2 = (rand.nextDouble() * 10) - 10; // random double in range [-10, 0)
		if (rand.nextDouble() < .5) {				 // return one of the two numbers	
			return num1;
		} else {
			return num2;
		} // this algorithm gives an equal chance of every double in range [-10, 10) due to the non-overlapping nature of the two double ranges and the even choice between the two ranges for the double to return
	}
	
	// usurper methods
	public String toString() {
		String toReturn = String.format("(%s, %s)", x, y);
		
		return toReturn;
	}

}
