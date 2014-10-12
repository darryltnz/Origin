import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class TradingStrategyControllerTest {
	
	ArrayList<String> rules; 
	

	@Before
	public void setUp() throws Exception {
	
		rules = new ArrayList<String>();
	
	}

	@Test
	public void testCreateTradingStrategy() {
		
		assertTrue(TradingStrategyController.createTradingStrategy("testStrat", "testUser", rules));
		
		
	}

	@Test
	public void testCreateDefaultTradingStrategy() {
		
		assertTrue(TradingStrategyController.createDefaultTradingStrategy("testStrat2", rules));
	}

	@Test
	public void testGetAvailableStrategies() {
		
		TradingStrategyController.createTradingStrategy("testStrat", "testUser", rules);
		
		boolean test = false;
		
		for(TradingStrategy ts : TradingStrategyController.getAvailableStrategies("testUser")) {
			
			
			if(ts.getName().equals("testStrat")) {
				
				test = true; 
			}
		}
	
	assertTrue(test);
	}

	@Test
	public void testReturnDefault() {
		
		TradingStrategy tester = TradingStrategyController.returnDefault();
		
		assertEquals("default", tester.getName());
	}

	@Test
	public void testReturnStrategy() {
		
		TradingStrategyController.createTradingStrategy("testStrat", "testUser", rules);
		
		TradingStrategy tester = TradingStrategyController.returnStrategy("testStrat");
		
		assertNotNull(tester);
		
		assertTrue(tester.getName().equals("testStrat"));
		
	}



}
