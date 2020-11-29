import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SocialAgentTest {
	
	SocialAgent basic, socialAgent;
	
	@BeforeEach
	void init() {
		basic = new SocialAgent();
		socialAgent = new SocialAgent(2, 3, 4);
	}

	@Test
	void constructorTests() {
		assertEquals(basic.getRadius(), 0);
		assertEquals(basic.getX(), 0);
		assertEquals(basic.getY(), 0);
		assertFalse(basic.getMoved());
		
		assertEquals(socialAgent.getX(), 2);
		assertEquals(socialAgent.getY(), 3);
		assertEquals(socialAgent.getRadius(), 4);
		assertFalse(basic.getMoved());
	}
	
	@Test
	void mutatorTests() {
		socialAgent.setRadius(1);
		assertEquals(socialAgent.getRadius(), 1);
	}

}
