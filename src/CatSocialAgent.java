import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class CatSocialAgent extends Agent {
	
	private int cat;
	
	public CatSocialAgent(double x0, double y0, double r, int cat) {
		super(x0, y0, r);
		this.cat = cat;
	}
	
	public int getCat() {
		return cat;
	}
	
	public void draw(Graphics g) {
		int red, green, blue;
		if (cat == 1) {
			red = 60;
			green = 110;
			blue = 140;
		} else {
			red = 140;
			green = 70;
			blue = 110;
		}
		if (moved) {
			g.setColor(new Color((int)((255-red)*.5 + red), (int)((255-green)*.5 + green), (int)((255-blue)*.5 + blue)));
		} else {
			g.setColor(new Color(red, green, blue));
		}
		g.fillOval((int)(x-(r/2)), (int)(y-(r/2)), 5, 5);		// draw a circle centered on the coordinate (x, y)
	}
	
	public static double genMoveNum() {
		Random rand = new Random(); 
		int foo = rand.nextInt(11);
		if (rand.nextFloat() < .5) {
			foo *= -1;
			foo -= rand.nextDouble();
			if (foo < -10) {
				foo = -10;
			}
		} else {
			foo += rand.nextDouble();
			if (foo > 10) {
				foo = 10;
			}
		}
		
		return foo;
	}
	
	public void updateState(Landscape scape) {
		// setup
		ArrayList<Agent> neighbors = scape.getNeighbors(x, y, r);
		Random rand = new Random();
		int counter = 0;
		// count
		for (Agent a : neighbors) {
			if (((CatSocialAgent) a).getCat() == this.getCat() && !a.equals(this)) {
				counter++;
			}
		}
		// move
		if (counter >= 2) {
			if (rand.nextDouble() < .5) {
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
	
	public String toString() {
		return "" + cat;
	}

}
