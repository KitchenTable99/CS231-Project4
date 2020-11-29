import java.awt.Graphics;
import java.util.ArrayList;

/*
   File: Landscape.java
   Author: Caleb Bitting
   Date: 09/24/2020
   Landscape Class
*/

public class Landscape {
	
	private int width, height;
	private LinkedList<Agent> agents;
	
	// constructors
	public Landscape() {
		width = 0;
		height = 0;
		agents = new LinkedList<Agent>();
	}
	
	public Landscape(int width, int height) {
		this.width = width;
		this.height = height;
		agents = new LinkedList<Agent>();
	}
	
	// accessors and mutators
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void addAgent(Agent a) {
		agents.addFirst(a);
	}
	
	// utility methods
	private static double getDistance(double x0, double y0, Agent a) {
		double agentX = a.getX();
		double agentY = a.getY();
		return Math.sqrt((y0 - agentY) * (y0 - agentY) + (x0 - agentX) * (x0 - agentX));
	}
	
	public ArrayList<Agent> getNeighbors(double x0, double y0, double radius) {
		// create ArrayList
		ArrayList<Agent> toReturn = new ArrayList<Agent>();
		// loop over all the Nodes looking for close ones
		for (Agent agent : agents) {
			if (getDistance(x0, y0, agent) < radius) {
				toReturn.add(agent);
			}
		}
		// return list
		return toReturn;
	}
	
	public void draw(Graphics g) {
		for (Agent agent : agents) {
			agent.draw(g);
		}
	}
	
	public void updateAgents() {
		ArrayList<Agent> shuffled = agents.toShuffledList();
		for(Agent a : shuffled) {
			a.updateState(this);
		}
	}
	
	// usurper methods
	public String toString() {
		return "" + agents.size();
	}

}
