import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class TradingStrategyControllerTest {
	
	ArrayList<String> rules; // test rules for the strategies
	

	@Before
	public void setUp() throws Exception {
	
		rules = new ArrayList<String>();
	
	}

	// ensure a newly defined strategy can be created
	@Test
	public void testCreateTradingStrategy() {
		
		assertTrue(TradingStrategyController.createTradingStrategy("testStrat", "testUser", rules)); 
		
		
	}
// ensure a new default strategy can be created
	@Test
	public void testCreateDefaultTradingStrategy() {
		
		assertTrue(TradingStrategyController.createDefaultTradingStrategy("testStrat3", rules));
	}

	// Ensure a strategy can be created in the list of strategies and then recalled for the user it was intended for
	@Test
	public void testGetAvailableStrategies() {
		
		TradingStrategyController.createTradingStrategy("testStrat", "testUser", rules); // make a new strategy
		
		boolean test = false;
		
		for(TradingStrategy ts : TradingStrategyController.getAvailableStrategies("testUser")) { // go through all the strategies
			
			
			if(ts.getName().equals("testStrat")) {
				
				test = true;  // find the created strategy
			}
		}
	
	assertTrue(test); // ensure the strategy can be found
	}

	// make sure the default system strategy can be retrieved
	@Test
	public void testReturnDefault() {
		
		TradingStrategy tester = TradingStrategyController.returnDefault();
		
		assertEquals("default", tester.getName());
	}

	// make sure a strategy created and added can be retrieved 
	@Test
	public void testReturnStrategy() {
		
		TradingStrategyController.createTradingStrategy("testStrat", "testUser", rules);
		
		TradingStrategy tester = TradingStrategyController.returnStrategy("testStrat");
		
		assertNotNull(tester);
		
		assertTrue(tester.getName().equals("testStrat"));
		
	}



}
