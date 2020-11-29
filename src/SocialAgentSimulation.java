import java.util.Random;

public class SocialAgentSimulation {
	
	public static void main(String[] args) {
		// deal with command-line
		if (args.length != 3) {
			System.out.println("You did not pass the correct number of command-line arguments.");
			System.out.println("usage: java SocialAgentSimulation numberAgents radiusNumber typeAgent");
			System.out.println();
			System.out.println("numberAgents: number of agents on screen");
			System.out.println("radiusNumber: how far away agents consider a neighbor");
			System.out.println("typeAgent: [SocialAgent, SocialDistanceAgent, CatSocialAgent]");
		}
		// set up objects
		int numAgents = Integer.parseInt(args[0]);
		int radiusNum = Integer.parseInt(args[1]);
		Landscape scape = new Landscape(500, 500);
		LandscapeDisplay display = new LandscapeDisplay(scape);
		
		// run simulation
		if (args[2].equals("SocialAgent")) {
			for (int i = 0; i < numAgents; i++) {
				Random rand = new Random();
				SocialAgent foo = new SocialAgent(rand.nextDouble()*scape.getWidth(), rand.nextDouble()*scape.getHeight(), radiusNum);
				scape.addAgent(foo);
			}
		} else if (args[2].equals("SocialDistanceAgent")) {
			for (int i = 0; i < numAgents; i++) {
	        	Random rand = new Random();
	        	SocialDistanceAgent foo = new SocialDistanceAgent(rand.nextDouble()*scape.getWidth(), rand.nextDouble()*scape.getHeight(), radiusNum);
	        	scape.addAgent(foo);
	        }
		} else if (args[2].equals("CatSocialAgent")) {
			for (int i = 0; i < numAgents; i++) {
				Random rand = new Random();
				int cat;
				if (rand.nextFloat() < .5) {
					cat = 1;
				} else {
					cat = 2;
				}
				CatSocialAgent foo = new CatSocialAgent(rand.nextDouble()*scape.getWidth(), rand.nextDouble()*scape.getHeight(), radiusNum, cat);
				scape.addAgent(foo);
			}
		} else {
			System.out.println("Please specify a valid type of agent.");
			System.out.println();
			System.out.println("usage: java SocialAgentSimulation numberAgents radiusNumber typeAgent");
			System.out.println("numberAgents: number of agents on screen");
			System.out.println("radiusNumber: how far away agents consider a neighbor");
			System.out.println("typeAgent: [SocialAgent, SocialDistanceAgent, CatSocialAgent]");
			return;
		}
		
		// paint the display
        for (int i = 0; i < 300; i++) {
        	scape.updateAgents();
        	display.repaint();
        	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        
        }
		
		
	}

}
