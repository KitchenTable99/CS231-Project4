import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LandscapeTest {
	
	Landscape basic, scape;
	SocialAgent agent1, agent2, agent3;
	
	@BeforeEach
	void init() {
		scape = new Landscape(500, 600);
		agent1 = new SocialAgent(2, 3, 10);
		agent2 = new SocialAgent(3, 4, 10);
		agent3 = new SocialAgent(3, 5, 10);
	}

	@Test
	void constructorTest() {
		basic = new Landscape();
		assertEquals(basic.getHeight(), 0);
		assertEquals(basic.getWidth(), 0);
		
		assertEquals(scape.getWidth(), 500);
		assertEquals(scape.getHeight(), 600);
		
	}
	
	@Test
	void agentTest() {
		scape.addAgent(agent1);
		scape.addAgent(agent2);
		scape.addAgent(agent3);
		ArrayList<Agent> foo = scape.getNeighbors(2, 3, 1.5);
		assertTrue(foo.contains(agent1) && foo.contains(agent2) && !foo.contains(agent3));
		assertEquals(foo.size(), 2);
	}

}
