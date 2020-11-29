import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/*
   File: SocialAgent.java
   Author: Caleb Bitting
   Date: 09/24/2020
   Social Agent Class
*/

public class SocialAgent extends Agent {
	
	protected boolean moved = false;
	protected double r;
	
	// constructors
	public SocialAgent() {
		super();
		r = 0;
	}
	
	public SocialAgent(double x0, double y0, double radius) {
		super(x0, y0, radius);
		r = radius;
	}
	
	// utility methods	
	public void updateState(Landscape scape) {
		// setup needed variables
		ArrayList<Agent> neighbors = scape.getNeighbors(this.x, this.y, this.r);
		//System.out.println(neighbors); //------ testing purposes
		Random rand = new Random();
		// count them
		int counter = 0;
		for (Agent agent : neighbors) {
			if (!agent.equals(this)) {
				counter++;
			}
		}
		// move the agent
		if (counter > 3) {
			if (rand.nextDouble() < .01) { // only one percent of the time if enough neighbors
				this.move();
				this.moved = true;
			} else {
				this.moved = false;
			}
		} else {
			this.move();
			this.moved = true;
		}
	}
	
	// usurper methods
	public void draw(Graphics g) {
		if (moved) {
			g.setColor(Color.LIGHT_GRAY);
		} else {
			g.setColor(Color.DARK_GRAY);
		}
		g.fillOval((int)(x-(r/2)), (int)(y-(r/2)), 5, 5);		// draw a circle centered on the coordinate (x, y)
	}
	
	public static void main(String[] args) {
		Landscape scape = new Landscape();
		SocialAgent agent1 = new SocialAgent(5, 5, 10);
		scape.addAgent(agent1);
		SocialAgent agent2 = new SocialAgent(10, 10, 10);
		scape.addAgent(agent2);
		SocialAgent agent3 = new SocialAgent(15, 15, 10);
		scape.addAgent(agent3);
		SocialAgent agent4 = new SocialAgent(20, 20, 10);
		scape.addAgent(agent4);
		agent4.updateState(scape);
	}
	
	

}
