import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;


public class TradingStrategyTest {

	// trading strategies, user account and rule list for testing
	TradingStrategy tsOne;
	
	TradingStrategy tsTwo;
	
	ArrayList<String> rules;
	
	UserAccount user;
	
	@Before
	public void setUp() throws Exception { // initialise values for test objects before each test
	
		rules = new ArrayList<String>();
		
		user = new UserAccount(1, "testPlayer", "testEmail", "testUsername", "testPassword", 1000.00);
		
		tsOne = new TradingStrategy("testOne", user, rules);
		
		tsTwo = new TradingStrategy("testTwo", rules);
		
		
	
	
	}
// test constructor creates a valid object
	@Test
	public void testTradingStrategyStringUserAccountArrayListOfString() {
		
		assertNotNull(tsOne);
		
		assertEquals("testOne", tsOne.getName());
	}

	// test constructor creates a valid object
	@Test
	public void testTradingStrategyStringArrayListOfString() {
		
        assertNotNull(tsTwo);
		
		assertEquals("testTwo", tsTwo.getName());

	}



}
