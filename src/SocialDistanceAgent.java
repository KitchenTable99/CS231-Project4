import java.util.ArrayList;

public class SocialDistanceAgent extends SocialAgent{
	
	private double r;

	public SocialDistanceAgent() {
		super();
		r = 0;
	}
	
	public SocialDistanceAgent(double x0, double y0, double radius) {
		super(x0, y0, radius);
		r = radius;
	}
	
	public void updateState(Landscape scape) {
		// setup needed variables
		ArrayList<Agent> neighbors = scape.getNeighbors(this.x, this.y, this.r);
		// count them
		int counter = 0;
		for (Agent agent : neighbors) {
			if (!agent.equals(this)) {
				counter++;
			}
		}
		// move the agent
		if (counter == 0) {
			moved = false;
//			System.out.println("h");
		} else {
			this.move();
			this.moved = true;
		}
	}

}
